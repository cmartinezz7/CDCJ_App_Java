package es.santander.justicia.minisJusticia.models.responses.erroLoginUnico;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap-env:Envelope")
public class ErrorLoginUnicoBody {
    @Element(name = "Fault", required = false)
    private ErrorFaultLoginUnico faultLoginUnico;

    public ErrorFaultLoginUnico getFaultLoginUnico() {
        return this.faultLoginUnico;
    }
}
