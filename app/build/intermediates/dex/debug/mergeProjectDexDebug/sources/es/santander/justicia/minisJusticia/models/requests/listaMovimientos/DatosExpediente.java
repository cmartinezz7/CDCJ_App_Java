package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import org.simpleframework.xml.Element;

public class DatosExpediente {
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "datosExpediente", required = false)
    private DatosExpedienteDetail datosExpedienteDetail;
    @Element(name = "jtipomod", required = false)
    private String jtipomod;

    public DatosExpediente(DatosExpedienteDetail datosExpedienteDetail2, String codMon, String tipo) {
        this.datosExpedienteDetail = datosExpedienteDetail2;
        if (codMon != null) {
            this.codmon = codMon;
        }
        if (tipo != null) {
            this.jtipomod = tipo;
        }
    }
}
