package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AREAPG4_BR_Type", propOrder = {"indtrx", "transac", "inddebito", "indcadcta", "indcript", "indautlim", "indaghibr", "indmultreq"})
public class AREAPG4BRType {
    @XmlElement(name = "INDAGHIBR", required = true)
    protected String indaghibr;
    @XmlElement(name = "INDAUTLIM", required = true)
    protected String indautlim;
    @XmlElement(name = "INDCADCTA", required = true)
    protected String indcadcta;
    @XmlElement(name = "INDCRIPT", required = true)
    protected String indcript;
    @XmlElement(name = "INDDEBITO", required = true)
    protected String inddebito;
    @XmlElement(name = "INDMULTREQ", required = true)
    protected String indmultreq;
    @XmlElement(name = "INDTRX", required = true)
    protected String indtrx;
    @XmlElement(name = "TRANSAC", required = true)
    protected String transac;

    public String getINDTRX() {
        return this.indtrx;
    }

    public void setINDTRX(String str) {
        this.indtrx = str;
    }

    public String getTRANSAC() {
        return this.transac;
    }

    public void setTRANSAC(String str) {
        this.transac = str;
    }

    public String getINDDEBITO() {
        return this.inddebito;
    }

    public void setINDDEBITO(String str) {
        this.inddebito = str;
    }

    public String getINDCADCTA() {
        return this.indcadcta;
    }

    public void setINDCADCTA(String str) {
        this.indcadcta = str;
    }

    public String getINDCRIPT() {
        return this.indcript;
    }

    public void setINDCRIPT(String str) {
        this.indcript = str;
    }

    public String getINDAUTLIM() {
        return this.indautlim;
    }

    public void setINDAUTLIM(String str) {
        this.indautlim = str;
    }

    public String getINDAGHIBR() {
        return this.indaghibr;
    }

    public void setINDAGHIBR(String str) {
        this.indaghibr = str;
    }

    public String getINDMULTREQ() {
        return this.indmultreq;
    }

    public void setINDMULTREQ(String str) {
        this.indmultreq = str;
    }
}
