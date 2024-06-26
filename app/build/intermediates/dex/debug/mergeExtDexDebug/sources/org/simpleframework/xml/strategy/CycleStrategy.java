package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

public class CycleStrategy implements Strategy {
    private final Contract contract;
    private final ReadState read;
    private final WriteState write;

    public CycleStrategy() {
        this(Name.MARK, Name.REFER);
    }

    public CycleStrategy(String mark, String refer) {
        this(mark, refer, Name.LABEL);
    }

    public CycleStrategy(String mark, String refer, String label) {
        this(mark, refer, label, Name.LENGTH);
    }

    public CycleStrategy(String mark, String refer, String label, String length) {
        Contract contract2 = new Contract(mark, refer, label, length);
        this.contract = contract2;
        this.write = new WriteState(contract2);
        this.read = new ReadState(contract2);
    }

    public Value read(Type type, NodeMap node, Map map) throws Exception {
        ReadGraph graph = this.read.find(map);
        if (graph != null) {
            return graph.read(type, node);
        }
        return null;
    }

    public boolean write(Type type, Object value, NodeMap node, Map map) {
        WriteGraph graph = this.write.find(map);
        if (graph != null) {
            return graph.write(type, value, node);
        }
        return false;
    }
}
