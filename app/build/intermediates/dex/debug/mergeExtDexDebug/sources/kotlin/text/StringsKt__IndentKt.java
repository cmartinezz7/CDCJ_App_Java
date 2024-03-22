package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* compiled from: Indent.kt */
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return StringsKt.trimMargin(str, str2);
    }

    public static final String trimMargin(String $this$trimMargin, String marginPrefix) {
        Intrinsics.checkNotNullParameter($this$trimMargin, "$this$trimMargin");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return StringsKt.replaceIndentByMargin($this$trimMargin, "", marginPrefix);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return StringsKt.replaceIndentByMargin(str, str2, str3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fe, code lost:
        r0 = (java.lang.String) r11.invoke(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String replaceIndentByMargin(java.lang.String r36, java.lang.String r37, java.lang.String r38) {
        /*
            r0 = r36
            r7 = r38
            java.lang.String r1 = "$this$replaceIndentByMargin"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "newIndent"
            r8 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "marginPrefix"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            r1 = r1 ^ 1
            if (r1 == 0) goto L_0x0157
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.util.List r9 = kotlin.text.StringsKt.lines(r1)
            int r1 = r36.length()
            int r2 = r37.length()
            int r3 = r9.size()
            int r2 = r2 * r3
            int r10 = r1 + r2
            kotlin.jvm.functions.Function1 r11 = getIndentFunction$StringsKt__IndentKt(r37)
            r12 = r9
            r13 = 0
            int r14 = kotlin.collections.CollectionsKt.getLastIndex(r12)
            r15 = r12
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            r16 = 0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            r17 = r15
            r18 = 0
            r19 = r17
            r20 = 0
            r1 = 0
            java.util.Iterator r21 = r19.iterator()
        L_0x005e:
            boolean r2 = r21.hasNext()
            if (r2 == 0) goto L_0x011f
            java.lang.Object r22 = r21.next()
            int r23 = r1 + 1
            if (r1 >= 0) goto L_0x006f
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x006f:
            r24 = r1
            r25 = r22
            r26 = 0
            r27 = r25
            java.lang.String r27 = (java.lang.String) r27
            r5 = r24
            r28 = 0
            r29 = 0
            if (r5 == 0) goto L_0x0083
            if (r5 != r14) goto L_0x0090
        L_0x0083:
            r1 = r27
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.isBlank(r1)
            if (r1 == 0) goto L_0x0090
            r7 = r6
            goto L_0x010c
        L_0x0090:
            r4 = r27
            r30 = 0
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            int r3 = r1.length()
            r0 = 0
        L_0x009d:
            r31 = r2
            r2 = -1
            if (r0 >= r3) goto L_0x00b7
            char r32 = r1.charAt(r0)
            r33 = 0
            boolean r34 = kotlin.text.CharsKt.isWhitespace(r32)
            r32 = r34 ^ 1
            if (r32 == 0) goto L_0x00b1
            goto L_0x00b8
        L_0x00b1:
            int r0 = r0 + 1
            r2 = r31
            goto L_0x009d
        L_0x00b7:
            r0 = r2
        L_0x00b8:
            if (r0 != r2) goto L_0x00c2
            r31 = r5
            r7 = r6
            r1 = r29
            goto L_0x00fc
        L_0x00c2:
            r31 = 0
            r32 = 4
            r33 = 0
            r1 = r4
            r2 = r38
            r3 = r0
            r35 = r4
            r4 = r31
            r31 = r5
            r5 = r32
            r7 = r6
            r6 = r33
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x00f8
            int r1 = r38.length()
            int r1 = r1 + r0
            r2 = r35
            if (r2 == 0) goto L_0x00f0
            java.lang.String r1 = r2.substring(r1)
            java.lang.String r3 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            goto L_0x00fc
        L_0x00f0:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r3 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r3)
            throw r1
        L_0x00f8:
            r2 = r35
            r1 = r29
        L_0x00fc:
            if (r1 == 0) goto L_0x0109
            java.lang.Object r0 = r11.invoke(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0109
            r29 = r0
            goto L_0x010b
        L_0x0109:
            r29 = r27
        L_0x010b:
        L_0x010c:
            if (r29 == 0) goto L_0x0115
            r0 = r29
            r1 = 0
            r7.add(r0)
            goto L_0x0116
        L_0x0115:
        L_0x0116:
            r0 = r36
            r6 = r7
            r1 = r23
            r7 = r38
            goto L_0x005e
        L_0x011f:
            r7 = r6
            r0 = r7
            java.util.List r0 = (java.util.List) r0
            r17 = r0
            java.lang.Iterable r17 = (java.lang.Iterable) r17
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            r18 = r0
            java.lang.Appendable r18 = (java.lang.Appendable) r18
            java.lang.String r0 = "\n"
            r19 = r0
            java.lang.CharSequence r19 = (java.lang.CharSequence) r19
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 124(0x7c, float:1.74E-43)
            r26 = 0
            java.lang.Appendable r0 = kotlin.collections.CollectionsKt.joinTo$default(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "mapIndexedNotNull { inde…\"\\n\")\n        .toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        L_0x0157:
            r0 = 0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "marginPrefix must be non-blank string."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__IndentKt.replaceIndentByMargin(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static final String trimIndent(String $this$trimIndent) {
        Intrinsics.checkNotNullParameter($this$trimIndent, "$this$trimIndent");
        return StringsKt.replaceIndent($this$trimIndent, "");
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return StringsKt.replaceIndent(str, str2);
    }

    public static final String replaceIndent(String $this$replaceIndent, String newIndent) {
        String it$iv$iv$iv;
        String str;
        String str2 = $this$replaceIndent;
        Intrinsics.checkNotNullParameter(str2, "$this$replaceIndent");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List $this$filter$iv = StringsKt.lines(str2);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!StringsKt.isBlank((String) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<String> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (String p1 : $this$map$iv) {
            destination$iv$iv2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt(p1)));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((List) destination$iv$iv2);
        int minCommonIndent = num != null ? num.intValue() : 0;
        int resultSizeEstimate$iv = $this$replaceIndent.length() + (newIndent.length() * $this$filter$iv.size());
        Function1 indentAddFunction$iv = getIndentFunction$StringsKt__IndentKt(newIndent);
        List $this$reindent$iv = $this$filter$iv;
        int lastIndex$iv = CollectionsKt.getLastIndex($this$reindent$iv);
        Collection destination$iv$iv$iv = new ArrayList();
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv$iv : $this$reindent$iv) {
            int index$iv$iv$iv$iv = index$iv$iv$iv + 1;
            if (index$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String value$iv = (String) item$iv$iv$iv$iv;
            int index$iv = index$iv$iv$iv;
            if ((index$iv == 0 || index$iv == lastIndex$iv) && StringsKt.isBlank(value$iv)) {
                it$iv$iv$iv = null;
            } else {
                int i = index$iv;
                String line = StringsKt.drop(value$iv, minCommonIndent);
                it$iv$iv$iv = (line == null || (str = (String) indentAddFunction$iv.invoke(line)) == null) ? value$iv : str;
            }
            if (it$iv$iv$iv != null) {
                destination$iv$iv$iv.add(it$iv$iv$iv);
            }
            String str3 = $this$replaceIndent;
            index$iv$iv$iv = index$iv$iv$iv$iv;
        }
        String sb = ((StringBuilder) CollectionsKt.joinTo$default((List) destination$iv$iv$iv, new StringBuilder(resultSizeEstimate$iv), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return StringsKt.prependIndent(str, str2);
    }

    public static final String prependIndent(String $this$prependIndent, String indent) {
        Intrinsics.checkNotNullParameter($this$prependIndent, "$this$prependIndent");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence($this$prependIndent), new StringsKt__IndentKt$prependIndent$1(indent)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private static final int indentWidth$StringsKt__IndentKt(String $this$indentWidth) {
        CharSequence $this$indexOfFirst$iv = $this$indentWidth;
        int length = $this$indexOfFirst$iv.length();
        int index$iv = 0;
        while (true) {
            if (index$iv >= length) {
                index$iv = -1;
                break;
            } else if ((CharsKt.isWhitespace($this$indexOfFirst$iv.charAt(index$iv)) ^ 1) != 0) {
                break;
            } else {
                index$iv++;
            }
        }
        int it = index$iv;
        return it == -1 ? $this$indentWidth.length() : it;
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String indent) {
        if (indent.length() == 0) {
            return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(indent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007d, code lost:
        if (r0 != null) goto L_0x0085;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String reindent$StringsKt__IndentKt(java.util.List<java.lang.String> r20, int r21, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> r22, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> r23) {
        /*
            r0 = 0
            int r1 = kotlin.collections.CollectionsKt.getLastIndex(r20)
            r2 = r20
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = r2
            r6 = 0
            r7 = r5
            r8 = 0
            r9 = 0
            java.util.Iterator r10 = r7.iterator()
        L_0x001e:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0097
            java.lang.Object r11 = r10.next()
            int r12 = r9 + 1
            if (r9 >= 0) goto L_0x0043
            r13 = 3
            r14 = 0
            r15 = 1
            boolean r13 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r15, r13, r14)
            if (r13 == 0) goto L_0x0039
            kotlin.collections.CollectionsKt.throwIndexOverflow()
            goto L_0x0043
        L_0x0039:
            java.lang.ArithmeticException r9 = new java.lang.ArithmeticException
            java.lang.String r10 = "Index overflow has happened."
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        L_0x0043:
            r13 = r11
            r14 = 0
            r15 = r13
            java.lang.String r15 = (java.lang.String) r15
            r16 = r9
            r17 = 0
            r18 = r0
            r0 = r16
            if (r0 == 0) goto L_0x0054
            if (r0 != r1) goto L_0x0065
        L_0x0054:
            r16 = r15
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = kotlin.text.StringsKt.isBlank(r16)
            if (r16 == 0) goto L_0x0065
            r16 = 0
            r19 = r1
            r1 = r22
            goto L_0x0087
        L_0x0065:
            r16 = r0
            r0 = r23
            java.lang.Object r19 = r0.invoke(r15)
            r0 = r19
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0080
            r19 = r1
            r1 = r22
            java.lang.Object r0 = r1.invoke(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0084
            goto L_0x0085
        L_0x0080:
            r19 = r1
            r1 = r22
        L_0x0084:
            r0 = r15
        L_0x0085:
            r16 = r0
        L_0x0087:
            if (r16 == 0) goto L_0x0090
            r0 = r16
            r15 = 0
            r4.add(r0)
            goto L_0x0091
        L_0x0090:
        L_0x0091:
            r9 = r12
            r0 = r18
            r1 = r19
            goto L_0x001e
        L_0x0097:
            r18 = r0
            r0 = r4
            java.util.List r0 = (java.util.List) r0
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r2 = r21
            r0.<init>(r2)
            r5 = r0
            java.lang.Appendable r5 = (java.lang.Appendable) r5
            java.lang.String r0 = "\n"
            r6 = r0
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 124(0x7c, float:1.74E-43)
            r13 = 0
            java.lang.Appendable r0 = kotlin.collections.CollectionsKt.joinTo$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "mapIndexedNotNull { inde…\"\\n\")\n        .toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__IndentKt.reindent$StringsKt__IndentKt(java.util.List, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):java.lang.String");
    }
}