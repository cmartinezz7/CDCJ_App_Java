package es.santander.justicia.minisJusticia.models.responses.contratos;

import org.simpleframework.xml.Element;

public class ContratosResponseEntrada {
    @Element(name = "indApoderadoDelegado", required = false)
    private String indApoderadoDelegado;
    @Element(name = "token", required = false)
    private String token;

    public String getToken() {
        return this.token;
    }

    public String getIndApoderadoDelegado() {
        return this.indApoderadoDelegado;
    }
}
