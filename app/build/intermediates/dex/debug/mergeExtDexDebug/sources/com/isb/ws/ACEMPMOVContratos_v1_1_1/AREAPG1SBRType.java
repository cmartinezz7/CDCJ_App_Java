package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AREAPG1S_BR_Type", propOrder = {"codret", "transac", "tpoper", "feccont", "canalpg", "canalnio", "contrato"})
public class AREAPG1SBRType {
    @XmlElement(name = "CANALNIO", required = true)
    protected String canalnio;
    @XmlElement(name = "CANALPG", required = true)
    protected String canalpg;
    @XmlElement(name = "CODRET", required = true)
    protected String codret;
    @XmlElement(name = "CONTRATO", required = true)
    protected CONTRATOBRType contrato;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FECCONT", required = true)
    protected XMLGregorianCalendar feccont;
    @XmlElement(name = "TPOPER", required = true)
    protected String tpoper;
    @XmlElement(name = "TRANSAC", required = true)
    protected String transac;

    public String getCODRET() {
        return this.codret;
    }

    public void setCODRET(String str) {
        this.codret = str;
    }

    public String getTRANSAC() {
        return this.transac;
    }

    public void setTRANSAC(String str) {
        this.transac = str;
    }

    public String getTPOPER() {
        return this.tpoper;
    }

    public void setTPOPER(String str) {
        this.tpoper = str;
    }

    public XMLGregorianCalendar getFECCONT() {
        return this.feccont;
    }

    public void setFECCONT(XMLGregorianCalendar xMLGregorianCalendar) {
        this.feccont = xMLGregorianCalendar;
    }

    public String getCANALPG() {
        return this.canalpg;
    }

    public void setCANALPG(String str) {
        this.canalpg = str;
    }

    public String getCANALNIO() {
        return this.canalnio;
    }

    public void setCANALNIO(String str) {
        this.canalnio = str;
    }

    public CONTRATOBRType getCONTRATO() {
        return this.contrato;
    }

    public void setCONTRATO(CONTRATOBRType cONTRATOBRType) {
        this.contrato = cONTRATOBRType;
    }
}
