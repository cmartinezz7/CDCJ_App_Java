package org.kobjects.xmlrpc;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.kobjects.base64.Base64;
import org.kobjects.isodate.IsoDate;
import org.kobjects.xml.XmlReader;

public class XmlRpcParser {
    private XmlReader parser = null;

    public XmlRpcParser(XmlReader parser2) {
        this.parser = parser2;
    }

    private final Hashtable parseStruct() throws IOException {
        Hashtable result = new Hashtable();
        int type = nextTag();
        while (type != 3) {
            nextTag();
            String name = nextText();
            nextTag();
            result.put(name, parseValue());
            type = nextTag();
        }
        nextTag();
        return result;
    }

    private final Object parseValue() throws IOException {
        Object result = null;
        int event = this.parser.next();
        if (event == 4) {
            result = this.parser.getText();
            event = this.parser.next();
        }
        if (event == 2) {
            String name = this.parser.getName();
            if (name.equals("array")) {
                result = parseArray();
            } else if (name.equals("struct")) {
                result = parseStruct();
            } else {
                if (name.equals("string")) {
                    result = nextText();
                } else if (name.equals("i4") || name.equals("int")) {
                    result = new Integer(Integer.parseInt(nextText().trim()));
                } else if (name.equals("boolean")) {
                    result = new Boolean(nextText().trim().equals("1"));
                } else if (name.equals("dateTime.iso8601")) {
                    result = IsoDate.stringToDate(nextText(), 3);
                } else if (name.equals("base64")) {
                    result = Base64.decode(nextText());
                } else if (name.equals("double")) {
                    result = nextText();
                }
                nextTag();
            }
        }
        nextTag();
        return result;
    }

    private final Vector parseArray() throws IOException {
        nextTag();
        int type = nextTag();
        Vector vec = new Vector();
        while (type != 3) {
            vec.addElement(parseValue());
            type = this.parser.getType();
        }
        nextTag();
        nextTag();
        return vec;
    }

    private final Object parseFault() throws IOException {
        nextTag();
        Object value = parseValue();
        nextTag();
        return value;
    }

    private final Object parseParams() throws IOException {
        Vector params = new Vector();
        int type = nextTag();
        while (type != 3) {
            nextTag();
            params.addElement(parseValue());
            type = nextTag();
        }
        nextTag();
        return params;
    }

    public final Object parseResponse() throws IOException {
        nextTag();
        if (nextTag() != 2) {
            return null;
        }
        if ("fault".equals(this.parser.getName())) {
            return parseFault();
        }
        if ("params".equals(this.parser.getName())) {
            return parseParams();
        }
        return null;
    }

    private final int nextTag() throws IOException {
        int type = this.parser.getType();
        int type2 = this.parser.next();
        if (type2 == 4 && this.parser.isWhitespace()) {
            type2 = this.parser.next();
        }
        if (type2 == 3 || type2 == 2) {
            return type2;
        }
        throw new IOException("unexpected type: " + type2);
    }

    private final String nextText() throws IOException {
        String result;
        if (this.parser.getType() == 2) {
            int type = this.parser.next();
            if (type == 4) {
                result = this.parser.getText();
                type = this.parser.next();
            } else {
                result = "";
            }
            if (type == 3) {
                return result;
            }
            throw new IOException("END_TAG expected");
        }
        throw new IOException("precondition: START_TAG");
    }
}
