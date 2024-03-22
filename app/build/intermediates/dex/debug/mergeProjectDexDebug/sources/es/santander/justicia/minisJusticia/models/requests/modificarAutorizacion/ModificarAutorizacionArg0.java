package es.santander.justicia.minisJusticia.models.requests.modificarAutorizacion;

import org.simpleframework.xml.Element;

public class ModificarAutorizacionArg0 {
    @Element(name = "arg0", required = false)
    private ModificarAutorizacionArg0Detail modificarAutorizacionArg0Detail;

    public ModificarAutorizacionArg0(ModificarAutorizacionArg0Detail modificarAutorizacionArg0Detail2) {
        this.modificarAutorizacionArg0Detail = modificarAutorizacionArg0Detail2;
    }
}
