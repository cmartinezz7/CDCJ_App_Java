package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DOMICILIO_PRESENT_BFPO_Type", propOrder = {"descripcion1", "descripcion2", "descripcion3", "descripcion4", "numbfpo"})
public class DOMICILIOPRESENTBFPOType {
    @XmlElement(name = "DESCRIPCION_1", required = true)
    protected String descripcion1;
    @XmlElement(name = "DESCRIPCION_2", required = true)
    protected String descripcion2;
    @XmlElement(name = "DESCRIPCION_3", required = true)
    protected String descripcion3;
    @XmlElement(name = "DESCRIPCION_4", required = true)
    protected String descripcion4;
    @XmlElement(name = "NUM_BFPO", required = true)
    protected String numbfpo;

    public String getDESCRIPCION1() {
        return this.descripcion1;
    }

    public void setDESCRIPCION1(String str) {
        this.descripcion1 = str;
    }

    public String getDESCRIPCION2() {
        return this.descripcion2;
    }

    public void setDESCRIPCION2(String str) {
        this.descripcion2 = str;
    }

    public String getDESCRIPCION3() {
        return this.descripcion3;
    }

    public void setDESCRIPCION3(String str) {
        this.descripcion3 = str;
    }

    public String getDESCRIPCION4() {
        return this.descripcion4;
    }

    public void setDESCRIPCION4(String str) {
        this.descripcion4 = str;
    }

    public String getNUMBFPO() {
        return this.numbfpo;
    }

    public void setNUMBFPO(String str) {
        this.numbfpo = str;
    }
}
