package es.santander.justicia.minisJusticia.models.requests.operativas;

import org.simpleframework.xml.Element;

public class BajaSolicitudRequestBody {
    @Element(name = "wsj:bajaSolicitudProfesional", required = false)
    private OperativasGlobalArg0 operativasGlobalArg0;

    public BajaSolicitudRequestBody(OperativasGlobalArg0 operativasGlobalArg02) {
        this.operativasGlobalArg0 = operativasGlobalArg02;
    }
}
