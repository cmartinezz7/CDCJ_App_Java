package com.stanfy.gsonxml;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlReader extends JsonReader {
    private static final int END_TAG = 2;
    private static final int IGNORE = -1;
    private static final int START_TAG = 1;
    private static final int VALUE = 3;
    private final AttributesData attributes;
    private final Stack<ClosedTag> closeStack = new Stack<>();
    private boolean endReached;
    private JsonToken expectedToken;
    private boolean firstStart = true;
    private boolean lastTextWhiteSpace = false;
    final Options options;
    private final Stack<Scope> scopeStack = new Stack<>();
    private boolean skipping;
    private int textNameCounter = 0;
    private JsonToken token;
    private final RefsPool<TokenRef> tokensPool = new RefsPool<>(new Creator<TokenRef>() {
        public TokenRef create() {
            return new TokenRef();
        }
    });
    private TokenRef tokensQueue;
    private TokenRef tokensQueueStart;
    private final RefsPool<ValueRef> valuesPool = new RefsPool<>(new Creator<ValueRef>() {
        public ValueRef create() {
            return new ValueRef();
        }
    });
    private ValueRef valuesQueue;
    private ValueRef valuesQueueStart;
    private final XmlPullParser xmlParser;
    private final XmlTokenInfo xmlToken;

    private interface Creator<T> {
        T create();
    }

    public static class Options {
        boolean namespaces;
        boolean primitiveArrays;
        boolean rootArrayPrimitive;
        boolean sameNameList;
        boolean skipRoot;
    }

    private enum Scope {
        INSIDE_OBJECT(false),
        INSIDE_ARRAY(true),
        INSIDE_EMBEDDED_ARRAY(true),
        INSIDE_PRIMITIVE_EMBEDDED_ARRAY(true),
        INSIDE_PRIMITIVE_ARRAY(true),
        PRIMITIVE_VALUE(false),
        NAME(false);
        
        final boolean insideArray;

        private Scope(boolean insideArray2) {
            this.insideArray = insideArray2;
        }
    }

    public XmlReader(Reader in, XmlParserCreator creator, Options options2) {
        super(in);
        XmlTokenInfo xmlTokenInfo = new XmlTokenInfo();
        this.xmlToken = xmlTokenInfo;
        this.attributes = new AttributesData(10);
        XmlPullParser createParser = creator.createParser();
        this.xmlParser = createParser;
        this.options = options2;
        xmlTokenInfo.type = -1;
        try {
            createParser.setInput(in);
            createParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, options2.namespaces);
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        }
    }

    private CharSequence dump() {
        return new StringBuilder().append("Scopes: ").append(this.scopeStack).append(10).append("Closed tags: ").append(this.closeStack).append(10).append("Token: ").append(this.token).append(10).append("Tokens queue: ").append(this.tokensQueueStart).append(10).append("Values queue: ").append(this.valuesQueueStart).append(10);
    }

    public String toString() {
        return "--- XmlReader ---\n" + dump();
    }

    private JsonToken peekNextToken() {
        TokenRef tokenRef = this.tokensQueueStart;
        if (tokenRef != null) {
            return tokenRef.token;
        }
        return null;
    }

    private JsonToken nextToken() {
        TokenRef ref = this.tokensQueueStart;
        if (ref == null) {
            return JsonToken.END_DOCUMENT;
        }
        this.tokensQueueStart = ref.next;
        if (ref == this.tokensQueue) {
            this.tokensQueue = null;
        }
        this.tokensPool.release(ref);
        return ref.token;
    }

    private ValueRef nextValue() {
        ValueRef ref = this.valuesQueueStart;
        if (ref != null) {
            if (ref == this.valuesQueue) {
                this.valuesQueue = null;
            }
            this.valuesPool.release(ref);
            this.valuesQueueStart = ref.next;
            return ref;
        }
        throw new IllegalStateException("No value can be given");
    }

    private void expect(JsonToken token2) throws IOException {
        JsonToken actual = peek();
        this.token = null;
        if (actual != token2) {
            throw new IllegalStateException(token2 + " expected, but met " + actual + "\n" + dump());
        }
    }

    public void beginObject() throws IOException {
        JsonToken jsonToken = JsonToken.BEGIN_OBJECT;
        this.expectedToken = jsonToken;
        expect(jsonToken);
    }

    public void endObject() throws IOException {
        JsonToken jsonToken = JsonToken.END_OBJECT;
        this.expectedToken = jsonToken;
        expect(jsonToken);
    }

    public void beginArray() throws IOException {
        JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
        this.expectedToken = jsonToken;
        expect(jsonToken);
    }

    public void endArray() throws IOException {
        JsonToken jsonToken = JsonToken.END_ARRAY;
        this.expectedToken = jsonToken;
        expect(jsonToken);
    }

    public boolean hasNext() throws IOException {
        peek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public void skipValue() throws IOException {
        this.skipping = true;
        int count = 0;
        do {
            try {
                JsonToken token2 = peek();
                if (token2 != JsonToken.BEGIN_ARRAY) {
                    if (token2 != JsonToken.BEGIN_OBJECT) {
                        if (token2 != JsonToken.END_ARRAY) {
                            if (token2 != JsonToken.END_OBJECT) {
                                if (this.valuesQueue != null) {
                                    nextValue();
                                }
                                this.token = null;
                            }
                        }
                        count--;
                        this.token = null;
                    }
                }
                count++;
                this.token = null;
            } finally {
                this.skipping = false;
            }
        } while (count != 0);
    }

    private void adaptCurrentToken() throws XmlPullParserException, IOException {
        JsonToken jsonToken = this.token;
        JsonToken jsonToken2 = this.expectedToken;
        if (jsonToken != jsonToken2 && jsonToken2 == JsonToken.BEGIN_ARRAY) {
            int i = AnonymousClass3.$SwitchMap$com$google$gson$stream$JsonToken[this.token.ordinal()];
            if (i == 1) {
                this.token = JsonToken.BEGIN_ARRAY;
                Scope lastScope = this.scopeStack.peek();
                if (peekNextToken() != JsonToken.NAME) {
                    return;
                }
                if (this.options.sameNameList) {
                    this.scopeStack.cleanup(1);
                    pushToQueue(JsonToken.BEGIN_OBJECT);
                    this.scopeStack.push(Scope.INSIDE_EMBEDDED_ARRAY);
                    this.scopeStack.push(Scope.INSIDE_OBJECT);
                    if (lastScope == Scope.NAME) {
                        this.scopeStack.push(Scope.NAME);
                        return;
                    }
                    return;
                }
                nextToken();
                nextValue();
                int pushPos = this.scopeStack.size();
                if (this.options.primitiveArrays && peekNextToken() == null) {
                    fillQueues(true);
                }
                int pushPos2 = this.scopeStack.cleanup(3, pushPos);
                if (!this.options.primitiveArrays || peekNextToken() != JsonToken.STRING) {
                    this.scopeStack.pushAt(pushPos2, Scope.INSIDE_ARRAY);
                    if (this.scopeStack.size() <= pushPos2 + 1 || this.scopeStack.get(pushPos2 + 1) != Scope.INSIDE_OBJECT) {
                        this.scopeStack.pushAt(pushPos2 + 1, Scope.INSIDE_OBJECT);
                    }
                    if (peekNextToken() != JsonToken.BEGIN_OBJECT) {
                        pushToQueue(JsonToken.BEGIN_OBJECT);
                        return;
                    }
                    return;
                }
                this.scopeStack.pushAt(pushPos2, Scope.INSIDE_PRIMITIVE_ARRAY);
            } else if (i == 2) {
                this.token = JsonToken.BEGIN_ARRAY;
                if (!this.options.sameNameList) {
                    pushToQueue(JsonToken.END_ARRAY);
                } else if (this.options.primitiveArrays) {
                    pushToQueue(JsonToken.STRING);
                    this.scopeStack.push(Scope.INSIDE_PRIMITIVE_EMBEDDED_ARRAY);
                } else {
                    String value = nextValue().value;
                    pushToQueue(JsonToken.END_OBJECT);
                    pushToQueue(JsonToken.STRING);
                    pushToQueue(JsonToken.NAME);
                    pushToQueue(JsonToken.BEGIN_OBJECT);
                    pushToQueue(value);
                    pushToQueue("$");
                    this.scopeStack.push(Scope.INSIDE_EMBEDDED_ARRAY);
                }
            }
        }
    }

    public JsonToken peek() throws IOException {
        if (this.expectedToken == null && this.firstStart) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (this.token != null) {
            try {
                adaptCurrentToken();
                this.expectedToken = null;
                return this.token;
            } catch (XmlPullParserException e) {
                throw new JsonSyntaxException("XML parsing exception", e);
            }
        } else {
            try {
                fillQueues(false);
                this.expectedToken = null;
                JsonToken nextToken = nextToken();
                this.token = nextToken;
                return nextToken;
            } catch (XmlPullParserException e2) {
                throw new JsonSyntaxException("XML parsing exception", e2);
            }
        }
    }

    public String nextString() throws IOException {
        expect(JsonToken.STRING);
        return nextValue().value;
    }

    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        String value = nextValue().value;
        if ("true".equalsIgnoreCase(value) || "false".equalsIgnoreCase(value)) {
            return true;
        }
        throw new IOException("Cannot parse <" + value + "> to boolean");
    }

    public double nextDouble() throws IOException {
        expect(JsonToken.STRING);
        return Double.parseDouble(nextValue().value);
    }

    public int nextInt() throws IOException {
        expect(JsonToken.STRING);
        return Integer.parseInt(nextValue().value);
    }

    public long nextLong() throws IOException {
        expect(JsonToken.STRING);
        return Long.parseLong(nextValue().value);
    }

    public String nextName() throws IOException {
        this.expectedToken = JsonToken.NAME;
        expect(JsonToken.NAME);
        return nextValue().value;
    }

    private XmlTokenInfo nextXmlInfo() throws IOException, XmlPullParserException {
        int type = this.xmlParser.next();
        XmlTokenInfo info = this.xmlToken;
        info.clear();
        if (type != 1) {
            if (type == 2) {
                info.type = 1;
                info.name = this.xmlParser.getName();
                info.ns = this.xmlParser.getNamespace();
                if (this.xmlParser.getAttributeCount() > 0) {
                    this.attributes.fill(this.xmlParser);
                    info.attributesData = this.attributes;
                }
            } else if (type == 3) {
                info.type = 2;
                info.name = this.xmlParser.getName();
                info.ns = this.xmlParser.getNamespace();
            } else if (type == 4) {
                String text = this.xmlParser.getText().trim();
                if (text.length() == 0) {
                    this.lastTextWhiteSpace = true;
                    info.type = -1;
                    return info;
                }
                this.lastTextWhiteSpace = false;
                info.type = 3;
                info.value = text;
            }
            return info;
        }
        this.endReached = true;
        info.type = -1;
        return info;
    }

    private void addToQueue(JsonToken token2) {
        TokenRef tokenRef = this.tokensPool.get();
        tokenRef.token = token2;
        tokenRef.next = null;
        TokenRef tokenRef2 = this.tokensQueue;
        if (tokenRef2 == null) {
            this.tokensQueue = tokenRef;
            this.tokensQueueStart = tokenRef;
            return;
        }
        tokenRef2.next = tokenRef;
        this.tokensQueue = tokenRef;
    }

    private void pushToQueue(JsonToken token2) {
        TokenRef tokenRef = this.tokensPool.get();
        tokenRef.token = token2;
        tokenRef.next = null;
        TokenRef tokenRef2 = this.tokensQueueStart;
        if (tokenRef2 == null) {
            this.tokensQueueStart = tokenRef;
            this.tokensQueue = tokenRef;
            return;
        }
        tokenRef.next = tokenRef2;
        this.tokensQueueStart = tokenRef;
    }

    private void addToQueue(String value) {
        ValueRef valueRef = this.valuesPool.get();
        valueRef.value = value.trim();
        valueRef.next = null;
        ValueRef valueRef2 = this.valuesQueue;
        if (valueRef2 == null) {
            this.valuesQueue = valueRef;
            this.valuesQueueStart = valueRef;
            return;
        }
        valueRef2.next = valueRef;
        this.valuesQueue = valueRef;
    }

    private void pushToQueue(String value) {
        ValueRef valueRef = this.valuesPool.get();
        valueRef.value = value;
        valueRef.next = null;
        ValueRef valueRef2 = this.valuesQueueStart;
        if (valueRef2 == null) {
            this.valuesQueue = valueRef;
            this.valuesQueueStart = valueRef;
            return;
        }
        valueRef.next = valueRef2;
        this.valuesQueueStart = valueRef;
    }

    private void addToQueue(AttributesData attrData) throws IOException, XmlPullParserException {
        int count = attrData.count;
        for (int i = 0; i < count; i++) {
            addToQueue(JsonToken.NAME);
            addToQueue("@" + attrData.getName(i));
            addToQueue(JsonToken.STRING);
            addToQueue(attrData.values[i]);
        }
    }

    private void fillQueues(boolean force) throws IOException, XmlPullParserException {
        boolean mustRepeat = force;
        while (true) {
            if ((this.tokensQueue == null && !this.endReached) || mustRepeat) {
                XmlTokenInfo xml = nextXmlInfo();
                if (this.endReached) {
                    if (!this.options.skipRoot) {
                        addToQueue(JsonToken.END_OBJECT);
                        return;
                    }
                    return;
                } else if (xml.type != -1) {
                    mustRepeat = false;
                    int i = xml.type;
                    if (i != 1) {
                        if (i == 2) {
                            processEnd(xml);
                        } else if (i == 3) {
                            mustRepeat = processText(xml);
                        }
                    } else if (this.firstStart) {
                        this.firstStart = false;
                        processRoot(xml);
                    } else {
                        processStart(xml);
                    }
                    if (!mustRepeat && this.skipping) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    private void processRoot(XmlTokenInfo xml) throws IOException, XmlPullParserException {
        if (!this.options.skipRoot) {
            addToQueue(this.expectedToken);
            this.scopeStack.push(Scope.INSIDE_OBJECT);
            processStart(xml);
        } else if (xml.attributesData != null) {
            addToQueue(JsonToken.BEGIN_OBJECT);
            this.scopeStack.push(Scope.INSIDE_OBJECT);
            addToQueue(xml.attributesData);
        } else {
            int i = AnonymousClass3.$SwitchMap$com$google$gson$stream$JsonToken[this.expectedToken.ordinal()];
            if (i == 1) {
                addToQueue(JsonToken.BEGIN_OBJECT);
                this.scopeStack.push(Scope.INSIDE_OBJECT);
            } else if (i == 3) {
                addToQueue(JsonToken.BEGIN_ARRAY);
                this.scopeStack.push(this.options.rootArrayPrimitive ? Scope.INSIDE_PRIMITIVE_ARRAY : Scope.INSIDE_ARRAY);
            } else {
                throw new IllegalStateException("First expectedToken=" + this.expectedToken + " (not begin_object/begin_array)");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        if (r2 != 5) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processStart(com.stanfy.gsonxml.XmlReader.XmlTokenInfo r6) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r5 = this;
            r0 = 1
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$Scope> r1 = r5.scopeStack
            java.lang.Object r1 = r1.peek()
            com.stanfy.gsonxml.XmlReader$Scope r1 = (com.stanfy.gsonxml.XmlReader.Scope) r1
            com.stanfy.gsonxml.XmlReader$Options r2 = r5.options
            boolean r2 = r2.sameNameList
            if (r2 == 0) goto L_0x0055
            boolean r2 = r1.insideArray
            if (r2 == 0) goto L_0x0055
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$ClosedTag> r2 = r5.closeStack
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0055
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$ClosedTag> r2 = r5.closeStack
            java.lang.Object r2 = r2.peek()
            com.stanfy.gsonxml.XmlReader$ClosedTag r2 = (com.stanfy.gsonxml.XmlReader.ClosedTag) r2
            int r3 = r2.depth
            org.xmlpull.v1.XmlPullParser r4 = r5.xmlParser
            int r4 = r4.getDepth()
            if (r3 != r4) goto L_0x0055
            com.stanfy.gsonxml.XmlReader$Options r3 = r5.options
            boolean r3 = r3.namespaces
            if (r3 == 0) goto L_0x003a
            org.xmlpull.v1.XmlPullParser r3 = r5.xmlParser
            java.lang.String r3 = r6.getName(r3)
            goto L_0x003c
        L_0x003a:
            java.lang.String r3 = r6.name
        L_0x003c:
            java.lang.String r4 = r2.name
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x0055
            com.google.gson.stream.JsonToken r4 = com.google.gson.stream.JsonToken.END_ARRAY
            r5.addToQueue((com.google.gson.stream.JsonToken) r4)
            r5.fixScopeStack()
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$Scope> r4 = r5.scopeStack
            java.lang.Object r4 = r4.peek()
            r1 = r4
            com.stanfy.gsonxml.XmlReader$Scope r1 = (com.stanfy.gsonxml.XmlReader.Scope) r1
        L_0x0055:
            int[] r2 = com.stanfy.gsonxml.XmlReader.AnonymousClass3.$SwitchMap$com$stanfy$gsonxml$XmlReader$Scope
            int r3 = r1.ordinal()
            r2 = r2[r3]
            r3 = 1
            if (r2 == r3) goto L_0x007b
            r4 = 2
            if (r2 == r4) goto L_0x007b
            r4 = 3
            if (r2 == r4) goto L_0x006d
            r4 = 4
            if (r2 == r4) goto L_0x006d
            r4 = 5
            if (r2 == r4) goto L_0x006e
            goto L_0x0084
        L_0x006d:
            r0 = 0
        L_0x006e:
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.BEGIN_OBJECT
            r5.addToQueue((com.google.gson.stream.JsonToken) r2)
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$Scope> r2 = r5.scopeStack
            com.stanfy.gsonxml.XmlReader$Scope r4 = com.stanfy.gsonxml.XmlReader.Scope.INSIDE_OBJECT
            r2.push(r4)
            goto L_0x0084
        L_0x007b:
            r0 = 0
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$Scope> r2 = r5.scopeStack
            com.stanfy.gsonxml.XmlReader$Scope r4 = com.stanfy.gsonxml.XmlReader.Scope.PRIMITIVE_VALUE
            r2.push(r4)
        L_0x0084:
            if (r0 == 0) goto L_0x009d
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$Scope> r2 = r5.scopeStack
            com.stanfy.gsonxml.XmlReader$Scope r4 = com.stanfy.gsonxml.XmlReader.Scope.NAME
            r2.push(r4)
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.NAME
            r5.addToQueue((com.google.gson.stream.JsonToken) r2)
            org.xmlpull.v1.XmlPullParser r2 = r5.xmlParser
            java.lang.String r2 = r6.getName(r2)
            r5.addToQueue((java.lang.String) r2)
            r5.lastTextWhiteSpace = r3
        L_0x009d:
            com.stanfy.gsonxml.XmlReader$AttributesData r2 = r6.attributesData
            if (r2 == 0) goto L_0x00cc
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$Scope> r2 = r5.scopeStack
            java.lang.Object r2 = r2.peek()
            r1 = r2
            com.stanfy.gsonxml.XmlReader$Scope r1 = (com.stanfy.gsonxml.XmlReader.Scope) r1
            com.stanfy.gsonxml.XmlReader$Scope r2 = com.stanfy.gsonxml.XmlReader.Scope.PRIMITIVE_VALUE
            if (r1 == r2) goto L_0x00c4
            com.stanfy.gsonxml.XmlReader$Scope r2 = com.stanfy.gsonxml.XmlReader.Scope.NAME
            if (r1 != r2) goto L_0x00be
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.BEGIN_OBJECT
            r5.addToQueue((com.google.gson.stream.JsonToken) r2)
            com.stanfy.gsonxml.Stack<com.stanfy.gsonxml.XmlReader$Scope> r2 = r5.scopeStack
            com.stanfy.gsonxml.XmlReader$Scope r3 = com.stanfy.gsonxml.XmlReader.Scope.INSIDE_OBJECT
            r2.push(r3)
        L_0x00be:
            com.stanfy.gsonxml.XmlReader$AttributesData r2 = r6.attributesData
            r5.addToQueue((com.stanfy.gsonxml.XmlReader.AttributesData) r2)
            goto L_0x00cc
        L_0x00c4:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r3 = "Attributes data in primitive scope"
            r2.<init>(r3)
            throw r2
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stanfy.gsonxml.XmlReader.processStart(com.stanfy.gsonxml.XmlReader$XmlTokenInfo):void");
    }

    /* renamed from: com.stanfy.gsonxml.XmlReader$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;
        static final /* synthetic */ int[] $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope;

        static {
            int[] iArr = new int[Scope.values().length];
            $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope = iArr;
            try {
                iArr[Scope.INSIDE_PRIMITIVE_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[Scope.INSIDE_PRIMITIVE_EMBEDDED_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[Scope.INSIDE_EMBEDDED_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[Scope.INSIDE_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[Scope.NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[Scope.PRIMITIVE_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[Scope.INSIDE_OBJECT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            int[] iArr2 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr2;
            try {
                iArr2[JsonToken.BEGIN_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    private boolean processText(XmlTokenInfo xml) {
        int i = AnonymousClass3.$SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[this.scopeStack.peek().ordinal()];
        if (i == 5) {
            addTextToQueue(xml.value, true);
            return true;
        } else if (i == 6) {
            addTextToQueue(xml.value, false);
            return false;
        } else if (i == 7) {
            String name = "$";
            if (this.textNameCounter > 0) {
                name = name + this.textNameCounter;
            }
            this.textNameCounter++;
            addToQueue(JsonToken.NAME);
            addToQueue(name);
            addTextToQueue(xml.value, false);
            return false;
        } else {
            throw new JsonSyntaxException("Cannot process text '" + xml.value + "' inside scope " + this.scopeStack.peek());
        }
    }

    private void addTextToQueue(String value, boolean canBeAppended) {
        TokenRef tokenRef;
        if (!canBeAppended || (tokenRef = this.tokensQueue) == null || tokenRef.token != JsonToken.STRING) {
            addToQueue(JsonToken.STRING);
            addToQueue(value);
        } else if (value.length() > 0) {
            StringBuilder sb = new StringBuilder();
            ValueRef valueRef = this.valuesQueue;
            valueRef.value = sb.append(valueRef.value).append(" ").append(value).toString();
        }
    }

    private void fixScopeStack() {
        this.scopeStack.fix(Scope.NAME);
    }

    private void processEnd(XmlTokenInfo xml) throws IOException, XmlPullParserException {
        switch (AnonymousClass3.$SwitchMap$com$stanfy$gsonxml$XmlReader$Scope[this.scopeStack.peek().ordinal()]) {
            case 1:
            case 4:
                addToQueue(JsonToken.END_ARRAY);
                fixScopeStack();
                break;
            case 2:
            case 3:
                addToQueue(JsonToken.END_ARRAY);
                addToQueue(JsonToken.END_OBJECT);
                fixScopeStack();
                fixScopeStack();
                break;
            case 5:
                if (this.lastTextWhiteSpace) {
                    addTextToQueue("", true);
                }
                fixScopeStack();
                break;
            case 6:
                this.scopeStack.drop();
                break;
            case 7:
                addToQueue(JsonToken.END_OBJECT);
                this.textNameCounter = 0;
                fixScopeStack();
                break;
        }
        if (this.options.sameNameList) {
            int stackSize = this.xmlParser.getDepth();
            String name = this.options.namespaces ? xml.getName(this.xmlParser) : xml.name;
            Stack<ClosedTag> closeStack2 = this.closeStack;
            while (closeStack2.size() > 0 && closeStack2.peek().depth > stackSize) {
                closeStack2.drop();
            }
            if (closeStack2.size() == 0 || closeStack2.peek().depth < stackSize) {
                closeStack2.push(new ClosedTag(stackSize, name));
            } else {
                closeStack2.peek().name = name;
            }
        }
    }

    private static final class TokenRef {
        TokenRef next;
        JsonToken token;

        private TokenRef() {
        }

        public String toString() {
            return this.token + ", " + this.next;
        }
    }

    private static final class ValueRef {
        ValueRef next;
        String value;

        private ValueRef() {
        }

        public String toString() {
            return this.value + ", " + this.next;
        }
    }

    static String nameWithNs(String name, String namespace, XmlPullParser parser) throws XmlPullParserException {
        String result = name;
        String ns = namespace;
        if (ns == null || ns.length() <= 0) {
            return result;
        }
        if (parser != null) {
            int count = parser.getNamespaceCount(parser.getDepth());
            int i = 0;
            while (true) {
                if (i >= count) {
                    break;
                } else if (ns.equals(parser.getNamespaceUri(i))) {
                    ns = parser.getNamespacePrefix(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        return "<" + ns + ">" + result;
    }

    private static final class XmlTokenInfo {
        AttributesData attributesData;
        String name;
        String ns;
        int type;
        String value;

        private XmlTokenInfo() {
        }

        public void clear() {
            this.type = -1;
            this.name = null;
            this.value = null;
            this.ns = null;
            this.attributesData = null;
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append("xml ");
            int i = this.type;
            return append.append(i == 1 ? "start" : i == 2 ? "end" : "value").append(" <").append(this.ns).append(":").append(this.name).append(">=").append(this.value).append(this.attributesData != null ? ", " + this.attributesData : "").toString();
        }

        public String getName(XmlPullParser parser) throws IOException, XmlPullParserException {
            return XmlReader.nameWithNs(this.name, this.ns, parser);
        }
    }

    private final class AttributesData {
        int count = 0;
        String[] names;
        String[] ns;
        String[] values;

        public AttributesData(int capacity) {
            createArrays(capacity);
        }

        private void createArrays(int capacity) {
            this.names = new String[capacity];
            this.values = new String[capacity];
            this.ns = new String[capacity];
        }

        public void fill(XmlPullParser parser) {
            int aCount = parser.getAttributeCount();
            if (aCount > this.names.length) {
                createArrays(aCount);
            }
            this.count = aCount;
            for (int i = 0; i < aCount; i++) {
                this.names[i] = parser.getAttributeName(i);
                if (XmlReader.this.options.namespaces) {
                    this.ns[i] = parser.getAttributePrefix(i);
                }
                this.values[i] = parser.getAttributeValue(i);
            }
        }

        public String getName(int i) throws IOException, XmlPullParserException {
            return XmlReader.nameWithNs(this.names[i], this.ns[i], (XmlPullParser) null);
        }
    }

    private static class ClosedTag {
        int depth;
        String name;

        public ClosedTag(int depth2, String name2) {
            this.depth = depth2;
            this.name = name2;
        }

        public String toString() {
            return "'" + this.name + "'/" + this.depth;
        }
    }

    private static final class RefsPool<T> {
        private static final int SIZE = 32;
        private final Creator<T> creator;
        private int len = 0;
        private final Object[] store = new Object[32];

        public RefsPool(Creator<T> factory) {
            this.creator = factory;
        }

        public T get() {
            int i = this.len;
            if (i == 0) {
                return this.creator.create();
            }
            T[] tArr = this.store;
            int i2 = i - 1;
            this.len = i2;
            return tArr[i2];
        }

        public void release(T obj) {
            int i = this.len;
            if (i < 32) {
                Object[] objArr = this.store;
                this.len = i + 1;
                objArr[i] = obj;
            }
        }
    }
}
