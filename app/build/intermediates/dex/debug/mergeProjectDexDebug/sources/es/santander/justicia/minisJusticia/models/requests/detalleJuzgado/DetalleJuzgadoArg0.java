package es.santander.justicia.minisJusticia.models.requests.detalleJuzgado;

import org.simpleframework.xml.Element;

public class DetalleJuzgadoArg0 {
    @Element(name = "arg0", required = false)
    private DetalleJuzgadoArg0Detail detalleJuzgadoArg0Detail;

    public DetalleJuzgadoArg0(DetalleJuzgadoArg0Detail detalleJuzgadoArg0Detail2) {
        this.detalleJuzgadoArg0Detail = detalleJuzgadoArg0Detail2;
    }
}
