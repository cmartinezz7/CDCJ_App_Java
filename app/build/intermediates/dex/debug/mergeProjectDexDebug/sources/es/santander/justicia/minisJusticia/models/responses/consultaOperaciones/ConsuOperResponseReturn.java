package es.santander.justicia.minisJusticia.models.responses.consultaOperaciones;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;

public class ConsuOperResponseReturn {
    @ElementList(name = "return")
    private ArrayList<ConsultaOperaciones> consultaOperaciones;

    public ArrayList<ConsultaOperaciones> getConsultaOperaciones() {
        return this.consultaOperaciones;
    }
}
