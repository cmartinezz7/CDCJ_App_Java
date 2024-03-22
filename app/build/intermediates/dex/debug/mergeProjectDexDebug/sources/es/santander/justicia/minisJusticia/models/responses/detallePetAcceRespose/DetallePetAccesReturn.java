package es.santander.justicia.minisJusticia.models.responses.detallePetAcceRespose;

import es.santander.justicia.minisJusticia.models.requests.operativas.OperativasGlobalArg0Detail;
import org.simpleframework.xml.Element;

public class DetallePetAccesReturn {
    @Element(name = "return", required = false)
    private OperativasGlobalArg0Detail operativasGlobalArg0Detail;

    public OperativasGlobalArg0Detail getOperativasGlobalArg0Detail() {
        return this.operativasGlobalArg0Detail;
    }
}
