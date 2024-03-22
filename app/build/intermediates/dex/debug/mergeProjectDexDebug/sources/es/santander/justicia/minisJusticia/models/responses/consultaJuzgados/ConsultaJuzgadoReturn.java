package es.santander.justicia.minisJusticia.models.responses.consultaJuzgados;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ConsultaJuzgadoReturn {
    @ElementList(name = "return", required = false)
    private ArrayList<DatosJuzgado> datosJuzgados;

    public ArrayList<DatosJuzgado> getDatosJuzgados() {
        return this.datosJuzgados;
    }
}
