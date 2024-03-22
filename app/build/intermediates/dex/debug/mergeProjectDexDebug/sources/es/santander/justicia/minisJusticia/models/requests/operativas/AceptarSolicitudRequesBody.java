package es.santander.justicia.minisJusticia.models.requests.operativas;

import org.simpleframework.xml.Element;

public class AceptarSolicitudRequesBody {
    @Element(name = "wsj:aceptarSolicitudProfesional", required = false)
    private OperativasGlobalArg0 operativasGlobalArg0;

    public AceptarSolicitudRequesBody(OperativasGlobalArg0 operativasGlobalArg02) {
        this.operativasGlobalArg0 = operativasGlobalArg02;
    }
}
