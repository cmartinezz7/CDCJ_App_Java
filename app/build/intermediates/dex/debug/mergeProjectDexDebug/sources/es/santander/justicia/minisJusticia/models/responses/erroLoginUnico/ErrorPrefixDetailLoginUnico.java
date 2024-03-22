package es.santander.justicia.minisJusticia.models.responses.erroLoginUnico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ErrorPrefixDetailLoginUnico {
    @Element(name = "error", required = false)
    private ErrorDetailLoginUnico error;

    public ErrorDetailLoginUnico getError() {
        return this.error;
    }
}
