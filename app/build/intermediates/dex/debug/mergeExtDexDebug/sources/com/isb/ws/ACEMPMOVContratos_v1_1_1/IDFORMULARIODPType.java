package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_FORMULARIO_DP_Type", propOrder = {"empresa", "razonrec", "codproem", "codagrup", "idform"})
public class IDFORMULARIODPType {
    @XmlElement(name = "CODAGRUP", required = true)
    protected String codagrup;
    @XmlElement(name = "CODPROEM", required = true)
    protected String codproem;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "IDFORM", required = true)
    protected String idform;
    @XmlElement(name = "RAZONREC", required = true)
    protected String razonrec;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getRAZONREC() {
        return this.razonrec;
    }

    public void setRAZONREC(String str) {
        this.razonrec = str;
    }

    public String getCODPROEM() {
        return this.codproem;
    }

    public void setCODPROEM(String str) {
        this.codproem = str;
    }

    public String getCODAGRUP() {
        return this.codagrup;
    }

    public void setCODAGRUP(String str) {
        this.codagrup = str;
    }

    public String getIDFORM() {
        return this.idform;
    }

    public void setIDFORM(String str) {
        this.idform = str;
    }
}
