package es.santander.justicia.minisJusticia.models.responses.seizures;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class EmbargoReturn {
    @ElementList(name = "return", required = false)
    private ArrayList<Embargo> embargos;

    public ArrayList<Embargo> getEmbargos() {
        return this.embargos;
    }
}
