package es.santander.justicia.minisJusticia.models.requests.bajaEmbargo;

import org.simpleframework.xml.Element;

public class BajaEmbargoRequestBody {
    @Element(name = "wsj:bajaEmbargo", required = false)
    private BajaEmbargoArg0 bajaEmbargoArg0;

    public BajaEmbargoRequestBody(BajaEmbargoArg0 bajaEmbargoArg02) {
        this.bajaEmbargoArg0 = bajaEmbargoArg02;
    }
}
