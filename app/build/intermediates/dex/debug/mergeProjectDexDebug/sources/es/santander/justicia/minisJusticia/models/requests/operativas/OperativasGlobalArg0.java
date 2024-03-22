package es.santander.justicia.minisJusticia.models.requests.operativas;

import org.simpleframework.xml.Element;

public class OperativasGlobalArg0 {
    @Element(name = "arg0", required = false)
    private OperativasGlobalArg0Detail operativasGlobalArg0Detail;

    public OperativasGlobalArg0(OperativasGlobalArg0Detail operativasGlobalArg0Detail2) {
        this.operativasGlobalArg0Detail = operativasGlobalArg0Detail2;
    }
}
