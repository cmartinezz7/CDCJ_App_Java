package es.santander.justicia.minisJusticia.models.requests.seizures;

import org.simpleframework.xml.Element;

public class EmbargoArg0 {
    @Element(name = "arg0", required = false)
    private EmbargoArgo0Detail embargoArgo0Detail;

    public EmbargoArg0(EmbargoArgo0Detail embargoArgo0Detail2) {
        this.embargoArgo0Detail = embargoArgo0Detail2;
    }
}
