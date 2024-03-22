package es.santander.justicia.minisJusticia.models.requests;

import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpediente;
import org.simpleframework.xml.Element;

public class DatosOperacionesProfesionales {
    @Element(name = "codom", required = false)
    private String codom;
    @Element(name = "datosExpediente", required = false)
    private DatosExpediente datosExpediente;
    @Element(name = "jtipomod", required = false)
    private String jtipomod;

    public DatosOperacionesProfesionales(DatosExpediente datosExpediente2, String codom2, String jtipomod2) {
        this.datosExpediente = datosExpediente2;
        if (codom2 != null) {
            this.codom = codom2;
        }
        if (jtipomod2 != null) {
            this.jtipomod = jtipomod2;
        }
    }
}
