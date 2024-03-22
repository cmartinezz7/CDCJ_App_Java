package es.santander.justicia.minisJusticia.models.requests.activarExpediente;

import org.simpleframework.xml.Element;

public class ActivarExpedienteArg0Detail {
    @Element(name = "anoAperturaExpediente", required = false)
    private String anoAperturaExpediente;
    @Element(name = "codigoExpediente", required = false)
    private String codigoExpediente;
    @Element(name = "codigoJuzgadoDestino", required = false)
    private String codigoJuzgadoDestino;
    @Element(name = "codigoJuzgadoOrigen", required = false)
    private String codigoJuzgadoOrigen;
    @Element(name = "codigoMoneda", required = false)
    private String codigoMoneda;
    @Element(name = "codigoProcedimiento", required = false)
    private String codigoProcedimiento;
    @Element(name = "firma", required = false)
    private String firma;
    @Element(name = "numeroExpediente", required = false)
    private String numeroExpediente;

    public ActivarExpedienteArg0Detail(String anoAperturaExpediente2, String numeroExpediente2, String codigoJuzgadoDestino2, String codigoJuzgadoOrigen2, String codigoProcedimiento2, String codigoExpediente2, String codigoMoneda2, String firma2) {
        this.anoAperturaExpediente = anoAperturaExpediente2;
        this.numeroExpediente = numeroExpediente2;
        this.codigoJuzgadoDestino = codigoJuzgadoDestino2;
        this.codigoJuzgadoOrigen = codigoJuzgadoOrigen2;
        this.codigoProcedimiento = codigoProcedimiento2;
        this.codigoExpediente = codigoExpediente2;
        this.codigoMoneda = codigoMoneda2;
        this.firma = firma2;
    }
}
