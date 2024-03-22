package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDATOSARQOISAT_Type", propOrder = {"usuNotes", "tknRACF", "password"})
public class TDATOSARQOISATType {
    @XmlElement(name = "Password", required = true)
    protected String password;
    @XmlElement(name = "TknRACF", required = true)
    protected String tknRACF;
    @XmlElement(name = "UsuNotes", required = true)
    protected String usuNotes;

    public String getUsuNotes() {
        return this.usuNotes;
    }

    public void setUsuNotes(String str) {
        this.usuNotes = str;
    }

    public String getTknRACF() {
        return this.tknRACF;
    }

    public void setTknRACF(String str) {
        this.tknRACF = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }
}
