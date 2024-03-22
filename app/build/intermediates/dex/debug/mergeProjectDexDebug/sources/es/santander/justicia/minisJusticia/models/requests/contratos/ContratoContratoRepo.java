package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratoContratoRepo {
    @Element(name = "CENTRO", required = false)
    private ContratoCentro contratosCentro;
    @Element(name = "NUMERO_DE_CONTRATO", required = false)
    private String numerDeContrato;
    @Element(name = "PRODUCTO", required = false)
    private String producto;

    public ContratoCentro getContratosCentro() {
        return this.contratosCentro;
    }

    public String getProducto() {
        return this.producto;
    }

    public String getNumerDeContrato() {
        return this.numerDeContrato;
    }

    public void setContratosCentro(ContratoCentro contratosCentro2) {
        this.contratosCentro = contratosCentro2;
    }

    public void setProducto(String producto2) {
        this.producto = producto2;
    }

    public void setNumerDeContrato(String numerDeContrato2) {
        this.numerDeContrato = numerDeContrato2;
    }
}
