package es.santander.justicia.minisJusticia.models.requests;

import java.io.Serializable;
import org.simpleframework.xml.Element;

public class DatosPaginacionRequest implements Serializable {
    @Element(name = "numeroPagina")
    private int numerPagina;
    @Element(name = "tamannoPagina")
    private int tamannoPagina;

    public void setNumerPagina(int numerPagina2) {
        this.numerPagina = numerPagina2;
    }

    public void setTamannoPagina(int tamannoPagina2) {
        this.tamannoPagina = tamannoPagina2;
    }

    public DatosPaginacionRequest(int numerPagina2, int tamannoPagina2) {
        this.numerPagina = numerPagina2;
        this.tamannoPagina = tamannoPagina2;
    }
}
