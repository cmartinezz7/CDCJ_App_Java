package es.santander.justicia.minisJusticia.models.responses.contratos;

import org.simpleframework.xml.Element;

public class ContratosMethodResult {
    @Element(name = "methodResult", required = false)
    private ContratosMedhodResultDetail contratosMedhodResultDetail;

    public ContratosMedhodResultDetail getContratosMedhodResultDetail() {
        return this.contratosMedhodResultDetail;
    }
}
