package es.santander.justicia.utils;

import android.util.Log;
import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLParser {
    public Document getDomElement(String xml) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(cleanXml(xml)));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e2) {
            Log.e("Error: ", e2.getMessage());
            return null;
        } catch (IOException e3) {
            Log.e("Error: ", e3.getMessage());
            return null;
        }
    }

    public String getValue(Element item, String str) {
        return getElementValue(item.getElementsByTagName(str).item(0));
    }

    public final String getElementValue(Node elem) {
        if (elem == null || !elem.hasChildNodes()) {
            return "";
        }
        for (Node child = elem.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == 3) {
                return child.getNodeValue();
            }
        }
        return "";
    }

    public String cleanXml(String xml) {
        return xml.replaceAll(Pattern.quote("<![CDATA[<div class=\"tit\">"), "").replaceAll("<\\/div>", "").replaceAll("\\|]]>", "").replace("\n", "").replace("\t", "").replaceAll(Pattern.quote("<div id=\"tit\">"), "").replaceAll(Pattern.quote("<div id=\"txt\">"), "");
    }
}
