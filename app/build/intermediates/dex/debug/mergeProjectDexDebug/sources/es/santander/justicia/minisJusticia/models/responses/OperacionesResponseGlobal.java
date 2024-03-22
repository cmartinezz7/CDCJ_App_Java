package es.santander.justicia.minisJusticia.models.responses;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;

public class OperacionesResponseGlobal {
    @ElementList(name = "return")
    private ArrayList<OperacionGlobal> operacionGlobals;

    public ArrayList<OperacionGlobal> getOperacionGlobals() {
        return this.operacionGlobals;
    }
}
