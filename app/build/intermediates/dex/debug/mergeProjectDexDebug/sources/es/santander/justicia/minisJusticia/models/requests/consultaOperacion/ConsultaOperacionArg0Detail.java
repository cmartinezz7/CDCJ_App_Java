package es.santander.justicia.minisJusticia.models.requests.consultaOperacion;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class ConsultaOperacionArg0Detail {
    @Element(name = "datosPaginacion", required = false)
    private DatosPaginacionRequest datosPaginacionRequest;
    @Element(name = "fechaFin", required = false)
    private String fechaFin;
    @Element(name = "fechaInicio", required = false)
    private String fechaInicio;
    @Element(name = "juzgadoDestino", required = false)
    private String juzgadoDetino;
    @Element(name = "moneda", required = false)
    private String moneda;
    @Element(name = "operacionSeleccionadaMenu", required = false)
    private String operacionSeleccionadaMenu;
    @Element(name = "tipoOperacion", required = false)
    private String tipoOperacion;

    public ConsultaOperacionArg0Detail(DatosPaginacionRequest datosPaginacionRequest2, String juzgadoDetino2, String moneda2, String tipoOperacion2, String operacionSeleccionadaMenu2, String fechaFin2, String fechaInicio2) {
        this.datosPaginacionRequest = datosPaginacionRequest2;
        this.juzgadoDetino = juzgadoDetino2;
        this.moneda = moneda2;
        this.tipoOperacion = tipoOperacion2;
        if (operacionSeleccionadaMenu2 != null) {
            this.operacionSeleccionadaMenu = operacionSeleccionadaMenu2;
        }
        this.fechaFin = fechaFin2;
        this.fechaInicio = fechaInicio2;
    }
}
