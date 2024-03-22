package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import es.santander.justicia.minisJusticia.models.requests.DatosFiltradoRequest;
import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class ListaMoveArg0Detail {
    @Element(name = "datosOperacion")
    private DatosExpediente datosExpediente;
    @Element(name = "datosFiltrado", required = false)
    private DatosFiltradoRequest datosFiltrado;
    @Element(name = "datosPaginacion", required = false)
    private DatosPaginacionRequest datosPaginacionRequest;

    public ListaMoveArg0Detail(DatosExpediente datosExpediente2, DatosPaginacionRequest datosPaginacionRequest2, DatosFiltradoRequest datosFiltrado2) {
        this.datosExpediente = datosExpediente2;
        this.datosPaginacionRequest = datosPaginacionRequest2;
        this.datosFiltrado = datosFiltrado2;
    }
}
