package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosInterviniente", propOrder = {"dnompers", "jcoddoc", "jdomiper", "jtipdoc", "tipoDocumento"})
public class DatosInterviniente {
    protected String dnompers;
    protected String jcoddoc;
    protected String jdomiper;
    protected String jtipdoc;
    protected String tipoDocumento;

    public String getDnompers() {
        return this.dnompers;
    }

    public void setDnompers(String str) {
        this.dnompers = str;
    }

    public String getJcoddoc() {
        return this.jcoddoc;
    }

    public void setJcoddoc(String str) {
        this.jcoddoc = str;
    }

    public String getJdomiper() {
        return this.jdomiper;
    }

    public void setJdomiper(String str) {
        this.jdomiper = str;
    }

    public String getJtipdoc() {
        return this.jtipdoc;
    }

    public void setJtipdoc(String str) {
        this.jtipdoc = str;
    }

    public String getTipoDocumento() {
        return this.tipoDocumento;
    }

    public void setTipoDocumento(String str) {
        this.tipoDocumento = str;
    }
}
