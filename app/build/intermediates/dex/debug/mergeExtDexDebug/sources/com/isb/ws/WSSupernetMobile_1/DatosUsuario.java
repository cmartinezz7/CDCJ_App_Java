package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosUsuario", propOrder = {"coddocum", "jusuario", "tipdoc"})
public class DatosUsuario {
    protected String coddocum;
    protected String jusuario;
    protected String tipdoc;

    public String getCoddocum() {
        return this.coddocum;
    }

    public void setCoddocum(String str) {
        this.coddocum = str;
    }

    public String getJusuario() {
        return this.jusuario;
    }

    public void setJusuario(String str) {
        this.jusuario = str;
    }

    public String getTipdoc() {
        return this.tipdoc;
    }

    public void setTipdoc(String str) {
        this.tipdoc = str;
    }
}
