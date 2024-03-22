package es.santander.justicia.minisJusticia.models.responses.buscPetAcceso;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;

public class BuscPetAccResponseReturn {
    @ElementList(name = "return")
    private ArrayList<BuscarPeticionesAcceso> buscarPeticionesAccesos;

    public ArrayList<BuscarPeticionesAcceso> getBuscarPeticionesAccesos() {
        return this.buscarPeticionesAccesos;
    }
}
