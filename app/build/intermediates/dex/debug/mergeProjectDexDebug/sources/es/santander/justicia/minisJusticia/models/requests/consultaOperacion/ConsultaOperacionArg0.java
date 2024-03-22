package es.santander.justicia.minisJusticia.models.requests.consultaOperacion;

import org.simpleframework.xml.Element;

public class ConsultaOperacionArg0 {
    @Element(name = "arg0", required = false)
    private ConsultaOperacionArg0Detail consultaOperacionArg0Detail;

    public ConsultaOperacionArg0(ConsultaOperacionArg0Detail consultaOperacionArg0Detail2) {
        this.consultaOperacionArg0Detail = consultaOperacionArg0Detail2;
    }
}
