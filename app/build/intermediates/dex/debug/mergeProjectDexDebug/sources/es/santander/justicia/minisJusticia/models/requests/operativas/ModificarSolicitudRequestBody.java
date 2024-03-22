package es.santander.justicia.minisJusticia.models.requests.operativas;

import org.simpleframework.xml.Element;

public class ModificarSolicitudRequestBody {
    @Element(name = "wsj:modificarSolicitudProfesional", required = false)
    private OperativasGlobalArg0 operativasGlobalArg0;

    public ModificarSolicitudRequestBody(OperativasGlobalArg0 operativasGlobalArg02) {
        this.operativasGlobalArg0 = operativasGlobalArg02;
    }
}
