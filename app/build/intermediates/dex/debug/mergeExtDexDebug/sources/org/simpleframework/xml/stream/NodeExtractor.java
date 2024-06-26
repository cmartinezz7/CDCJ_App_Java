package org.simpleframework.xml.stream;

import java.util.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class NodeExtractor extends LinkedList<Node> {
    public NodeExtractor(Document source) {
        extract(source);
    }

    private void extract(Document source) {
        Node node = source.getDocumentElement();
        if (node != null) {
            offer(node);
            extract(node);
        }
    }

    private void extract(Node source) {
        NodeList list = source.getChildNodes();
        int length = list.getLength();
        for (int i = 0; i < length; i++) {
            Node node = list.item(i);
            if (node.getNodeType() != 8) {
                offer(node);
                extract(node);
            }
        }
    }
}
