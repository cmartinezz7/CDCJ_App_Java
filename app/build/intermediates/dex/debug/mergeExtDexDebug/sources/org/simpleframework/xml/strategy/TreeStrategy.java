package org.simpleframework.xml.strategy;

import java.lang.reflect.Array;
import java.util.Map;
import org.simpleframework.xml.stream.Node;
import org.simpleframework.xml.stream.NodeMap;

public class TreeStrategy implements Strategy {
    private final String label;
    private final String length;
    private final Loader loader;

    public TreeStrategy() {
        this(Name.LABEL, Name.LENGTH);
    }

    public TreeStrategy(String label2, String length2) {
        this.loader = new Loader();
        this.length = length2;
        this.label = label2;
    }

    public Value read(Type type, NodeMap node, Map map) throws Exception {
        Class actual = readValue(type, node);
        Class expect = type.getType();
        if (expect.isArray()) {
            return readArray(actual, node);
        }
        if (expect != actual) {
            return new ObjectValue(actual);
        }
        return null;
    }

    private Value readArray(Class type, NodeMap node) throws Exception {
        Node entry = node.remove(this.length);
        int size = 0;
        if (entry != null) {
            size = Integer.parseInt(entry.getValue());
        }
        return new ArrayValue(type, size);
    }

    private Class readValue(Type type, NodeMap node) throws Exception {
        Node entry = node.remove(this.label);
        Class expect = type.getType();
        if (expect.isArray()) {
            expect = expect.getComponentType();
        }
        if (entry == null) {
            return expect;
        }
        return this.loader.load(entry.getValue());
    }

    public boolean write(Type type, Object value, NodeMap node, Map map) {
        Class actual = value.getClass();
        Class expect = type.getType();
        Class real = actual;
        if (actual.isArray()) {
            real = writeArray(expect, value, node);
        }
        if (actual == expect) {
            return false;
        }
        node.put(this.label, real.getName());
        return false;
    }

    private Class writeArray(Class field, Object value, NodeMap node) {
        int size = Array.getLength(value);
        String str = this.length;
        if (str != null) {
            node.put(str, String.valueOf(size));
        }
        return field.getComponentType();
    }
}
