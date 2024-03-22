package es.santander.justicia.minisJusticia.models.requests.seizures;

import org.simpleframework.xml.Element;

public class EmbargoRequestBody {
    @Element(name = "wsj:buscarEmbargos", required = false)
    private EmbargoArg0 embargoArg0;

    public EmbargoRequestBody(EmbargoArg0 embargoArg02) {
        this.embargoArg0 = embargoArg02;
    }
}
