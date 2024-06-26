package org.ksoap2;

import java.io.IOException;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class SoapFault12 extends SoapFault {
    private static final long serialVersionUID = 1012001;
    public Node Code;
    public Node Detail;
    public Node Node;
    public Node Reason;
    public Node Role;

    public SoapFault12() {
        this.version = SoapEnvelope.VER12;
    }

    public SoapFault12(int version) {
        this.version = version;
    }

    public void parse(XmlPullParser parser) throws IOException, XmlPullParserException {
        parseSelf(parser);
        this.faultcode = this.Code.getElement(SoapEnvelope.ENV2003, "Value").getText(0);
        this.faultstring = this.Reason.getElement(SoapEnvelope.ENV2003, "Text").getText(0);
        this.detail = this.Detail;
        this.faultactor = null;
    }

    private void parseSelf(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(2, SoapEnvelope.ENV2003, "Fault");
        while (parser.nextTag() == 2) {
            String name = parser.getName();
            String namespace = parser.getNamespace();
            parser.nextTag();
            if (name.toLowerCase().equals("Code".toLowerCase())) {
                Node node = new Node();
                this.Code = node;
                node.parse(parser);
            } else if (name.toLowerCase().equals("Reason".toLowerCase())) {
                Node node2 = new Node();
                this.Reason = node2;
                node2.parse(parser);
            } else if (name.toLowerCase().equals("Node".toLowerCase())) {
                Node node3 = new Node();
                this.Node = node3;
                node3.parse(parser);
            } else if (name.toLowerCase().equals("Role".toLowerCase())) {
                Node node4 = new Node();
                this.Role = node4;
                node4.parse(parser);
            } else if (name.toLowerCase().equals("Detail".toLowerCase())) {
                Node node5 = new Node();
                this.Detail = node5;
                node5.parse(parser);
            } else {
                throw new RuntimeException("unexpected tag:" + name);
            }
            parser.require(3, namespace, name);
        }
        parser.require(3, SoapEnvelope.ENV2003, "Fault");
        parser.nextTag();
    }

    public void write(XmlSerializer xw) throws IOException {
        xw.startTag(SoapEnvelope.ENV2003, "Fault");
        xw.startTag(SoapEnvelope.ENV2003, "Code");
        this.Code.write(xw);
        xw.endTag(SoapEnvelope.ENV2003, "Code");
        xw.startTag(SoapEnvelope.ENV2003, "Reason");
        this.Reason.write(xw);
        xw.endTag(SoapEnvelope.ENV2003, "Reason");
        if (this.Node != null) {
            xw.startTag(SoapEnvelope.ENV2003, "Node");
            this.Node.write(xw);
            xw.endTag(SoapEnvelope.ENV2003, "Node");
        }
        if (this.Role != null) {
            xw.startTag(SoapEnvelope.ENV2003, "Role");
            this.Role.write(xw);
            xw.endTag(SoapEnvelope.ENV2003, "Role");
        }
        if (this.Detail != null) {
            xw.startTag(SoapEnvelope.ENV2003, "Detail");
            this.Detail.write(xw);
            xw.endTag(SoapEnvelope.ENV2003, "Detail");
        }
        xw.endTag(SoapEnvelope.ENV2003, "Fault");
    }

    public String getMessage() {
        return this.Reason.getElement(SoapEnvelope.ENV2003, "Text").getText(0);
    }

    public String toString() {
        return "Code: " + this.Code.getElement(SoapEnvelope.ENV2003, "Value").getText(0) + ", Reason: " + this.Reason.getElement(SoapEnvelope.ENV2003, "Text").getText(0);
    }
}
