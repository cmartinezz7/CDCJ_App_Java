package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class OperDatosOperacion {
    @Element(name = "codmon", required = false)
    private String codmon;
    @Element(name = "datosActuacionPolicial", required = false)
    private String datosActuacionPolicial = "";
    @Element(name = "datosAdicionales", required = false)
    private String datosAdicionales = "";
    @Element(name = "datosExpediente", required = false)
    private OperDatosExpediente datosExpediente;
    @Element(name = "datosFirma", required = false)
    private String datosFirma = "";
    @Element(name = "datosInterviniente", required = false)
    private String datosInterviniente = "";
    @Element(name = "datosJuzgadoPaz", required = false)
    private String datosJuzgadoPaz = "";
    @Element(name = "datosMaterializacion", required = false)
    private String datosMaterializacion = "";
    @Element(name = "datosRepresentante", required = false)
    private String datosRepresentante = "";
    @Element(name = "jnuoper", required = false)
    private String jnuoper;

    public OperDatosOperacion(String codmon2, OperDatosExpediente datosExpediente2, String jnuoper2) {
        this.codmon = codmon2;
        this.datosExpediente = datosExpediente2;
        this.jnuoper = jnuoper2;
    }
}
