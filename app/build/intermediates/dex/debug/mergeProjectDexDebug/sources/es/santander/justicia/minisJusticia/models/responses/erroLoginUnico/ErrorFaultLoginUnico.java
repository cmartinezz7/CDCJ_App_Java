package es.santander.justicia.minisJusticia.models.responses.erroLoginUnico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ErrorFaultLoginUnico {
    @Element(name = "detail", required = false)
    private ErrorPrefixLoginUnico errorPrefixLoginUnico;

    public ErrorPrefixLoginUnico getErrorPrefixLoginUnico() {
        return this.errorPrefixLoginUnico;
    }
}
