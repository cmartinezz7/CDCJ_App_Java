package es.santander.justicia.minisJusticia.models.responses.avisos;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;

public class AvisosResponseReturn {
    @ElementList(name = "return")
    private ArrayList<Avisos> avisos;

    public ArrayList<Avisos> getAvisos() {
        return this.avisos;
    }
}
