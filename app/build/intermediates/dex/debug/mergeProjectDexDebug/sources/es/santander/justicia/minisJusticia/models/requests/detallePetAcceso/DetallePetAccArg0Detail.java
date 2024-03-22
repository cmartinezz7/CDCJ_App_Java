package es.santander.justicia.minisJusticia.models.requests.detallePetAcceso;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class DetallePetAccArg0Detail {
    @Element(name = "anioApertura", required = false)
    private String anioApertura;
    @Element(name = "codDocumentoIdentidad", required = false)
    private String codDocumentoIdentidad;
    @Element(name = "codExpediente", required = false)
    private String codExpediente;
    @Element(name = "codTipoDocumento", required = false)
    private String codTipoDocumento;
    @Element(name = "fechaRegistroHistorico", required = false)
    private String fechaRegistroHistorico;

    public DetallePetAccArg0Detail(String anioApertura2, String codDocumentoIdentidad2, String codExpediente2, String codTipoDocumento2, String fechaRegistroHistorico2) {
        this.anioApertura = anioApertura2;
        this.codDocumentoIdentidad = codDocumentoIdentidad2;
        this.codExpediente = codExpediente2;
        this.codTipoDocumento = codTipoDocumento2;
    }
}
