package es.santander.justicia.minisJusticia.models.requests.bajaEmbargo;

import org.simpleframework.xml.Element;

public class BajaEmbargoArg0 {
    @Element(name = "arg0", required = false)
    private BajaEmbargoArg0Detail bajaEmbargoArg0Detail;

    public BajaEmbargoArg0(BajaEmbargoArg0Detail bajaEmbargoArg0Detail2) {
        this.bajaEmbargoArg0Detail = bajaEmbargoArg0Detail2;
    }
}
