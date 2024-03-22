package es.santander.justicia.minisJusticia.models.responses.erroLoginUnico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ErrorDetailLoginUnico {
    @Element(name = "errorCode", required = false)
    private String errorCode;
    @Element(name = "errorDesc", required = false)
    private String errorDesc;

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
