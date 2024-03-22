package es.santander.justicia.minisJusticia.models.requests.seizures;

import es.santander.justicia.minisJusticia.models.requests.DatosPaginacionRequest;
import org.simpleframework.xml.Element;

public class EmbargoArgo0Detail {
    @Element(name = "anoAperturaExpediente", required = false)
    private String anoAperturaExpediente;
    @Element(name = "codigoEstado", required = false)
    private String codigoEstado;
    @Element(name = "codigoTipoEmbargo", required = false)
    private String codigoTipoEmbargo;
    @Element(name = "datosPaginacion", required = false)
    private DatosPaginacionRequest datosPaginacionRequest;
    @Element(name = "fechaDesde", required = false)
    private String fechaDesde;
    @Element(name = "fechaHasta", required = false)
    private String fechaHasta;
    @Element(name = "importeEmbargadoDesde", required = false)
    private String importeEmbargadoDesde;
    @Element(name = "importeEmbargadoHasta", required = false)
    private String importeEmbargadoHasta;
    @Element(name = "juzgadoDestinoExp", required = false)
    private String juzgadoDestinoExp;
    @Element(name = "juzgadoOrigenExp", required = false)
    private String juzgadoOrigenExp;
    @Element(name = "numeroExp", required = false)
    private String numeroExp;
    @Element(name = "procedimientoExp", required = false)
    private String procedimientoExp;

    public EmbargoArgo0Detail(DatosPaginacionRequest datosPaginacionRequest2, String juzgadoDestinoExp2, String juzgadoOrigenExp2, String procedimientoExp2, String anoAperturaExpediente2, String numeroExp2, String importeEmbargadoDesde2, String importeEmbargadoHasta2, String fechaDesde2, String fechaHasta2, String codigoTipoEmbargo2, String codigoEstado2) {
        this.datosPaginacionRequest = datosPaginacionRequest2;
        this.juzgadoDestinoExp = juzgadoDestinoExp2;
        if (juzgadoOrigenExp2 != null) {
            this.juzgadoOrigenExp = juzgadoOrigenExp2;
        }
        if (procedimientoExp2 != null) {
            this.procedimientoExp = procedimientoExp2;
        }
        if (anoAperturaExpediente2 != null) {
            this.anoAperturaExpediente = anoAperturaExpediente2;
        }
        if (numeroExp2 != null) {
            this.numeroExp = numeroExp2;
        }
        if (importeEmbargadoDesde2 != null) {
            this.importeEmbargadoDesde = importeEmbargadoDesde2;
        }
        if (importeEmbargadoHasta2 != null) {
            this.importeEmbargadoHasta = importeEmbargadoHasta2;
        }
        if (fechaDesde2 != null && !fechaDesde2.isEmpty()) {
            this.fechaDesde = fechaDesde2;
        }
        if (fechaHasta2 != null && !fechaHasta2.isEmpty()) {
            this.fechaHasta = fechaHasta2;
        }
        if (codigoTipoEmbargo2 != null) {
            this.codigoTipoEmbargo = codigoTipoEmbargo2;
        }
        if (codigoEstado2 != null) {
            this.codigoEstado = codigoEstado2;
        }
    }
}
