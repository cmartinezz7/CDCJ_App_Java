package es.santander.justicia.minisJusticia.models.requests.consultaJuzgados;

import org.simpleframework.xml.Element;

public class ConsultaJuzgadosRequestBody {
    @Element(name = "wsj:consultaJuzgados", required = false)
    private ConsultaJuzgadosArg0 consultaJuzgadosArg0;

    public ConsultaJuzgadosRequestBody(ConsultaJuzgadosArg0 consultaJuzgadosArg02) {
        this.consultaJuzgadosArg0 = consultaJuzgadosArg02;
    }
}
