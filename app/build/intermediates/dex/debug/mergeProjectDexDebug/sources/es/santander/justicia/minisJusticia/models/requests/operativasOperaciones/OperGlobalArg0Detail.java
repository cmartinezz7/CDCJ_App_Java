package es.santander.justicia.minisJusticia.models.requests.operativasOperaciones;

import org.simpleframework.xml.Element;

public class OperGlobalArg0Detail {
    @Element(name = "datosOperacion", required = false)
    private OperDatosOperacion datosOperacion;
    @Element(name = "firma", required = false)
    private String firma;
    @Element(name = "motivoAnulacion", required = false)
    private String motivoAnulacion;

    public OperGlobalArg0Detail(OperDatosOperacion datosOperacion2, String firma2, String motivoAnulacion2) {
        this.datosOperacion = datosOperacion2;
        this.firma = firma2;
        this.motivoAnulacion = motivoAnulacion2;
    }
}
