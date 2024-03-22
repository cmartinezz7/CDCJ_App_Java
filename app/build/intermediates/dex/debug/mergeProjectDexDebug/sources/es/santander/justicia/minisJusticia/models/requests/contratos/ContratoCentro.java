package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratoCentro {
    @Element(name = "CENTRO", required = false)
    private String centro;
    @Element(name = "EMPRESA", required = false)
    private String empresa;

    public String getEmpresa() {
        return this.empresa;
    }

    public String getCentro() {
        return this.centro;
    }

    public void setEmpresa(String empresa2) {
        this.empresa = empresa2;
    }

    public void setCentro(String centro2) {
        this.centro = centro2;
    }
}
