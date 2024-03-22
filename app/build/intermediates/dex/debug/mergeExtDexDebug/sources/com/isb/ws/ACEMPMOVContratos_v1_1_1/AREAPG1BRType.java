package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AREAPG1_BR_Type", propOrder = {"codent", "centalt", "transac", "tpoper", "canalpg", "canalnsu", "meiopg", "dtorigem", "hrorigem", "tpcdcli", "indagend"})
public class AREAPG1BRType {
    @XmlElement(name = "CANALNSU", required = true)
    protected String canalnsu;
    @XmlElement(name = "CANALPG", required = true)
    protected String canalpg;
    @XmlElement(name = "CENTALT", required = true)
    protected String centalt;
    @XmlElement(name = "CODENT", required = true)
    protected String codent;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "DTORIGEM", required = true)
    protected XMLGregorianCalendar dtorigem;
    @XmlSchemaType(name = "time")
    @XmlElement(name = "HRORIGEM", required = true)
    protected XMLGregorianCalendar hrorigem;
    @XmlElement(name = "INDAGEND", required = true)
    protected String indagend;
    @XmlElement(name = "MEIOPG", required = true)
    protected String meiopg;
    @XmlElement(name = "TPCDCLI", required = true)
    protected String tpcdcli;
    @XmlElement(name = "TPOPER", required = true)
    protected String tpoper;
    @XmlElement(name = "TRANSAC", required = true)
    protected String transac;

    public String getCODENT() {
        return this.codent;
    }

    public void setCODENT(String str) {
        this.codent = str;
    }

    public String getCENTALT() {
        return this.centalt;
    }

    public void setCENTALT(String str) {
        this.centalt = str;
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

    public String getCANALPG() {
        return this.canalpg;
    }

    public void setCANALPG(String str) {
        this.canalpg = str;
    }

    public String getCANALNSU() {
        return this.canalnsu;
    }

    public void setCANALNSU(String str) {
        this.canalnsu = str;
    }

    public String getMEIOPG() {
        return this.meiopg;
    }

    public void setMEIOPG(String str) {
        this.meiopg = str;
    }

    public XMLGregorianCalendar getDTORIGEM() {
        return this.dtorigem;
    }

    public void setDTORIGEM(XMLGregorianCalendar xMLGregorianCalendar) {
        this.dtorigem = xMLGregorianCalendar;
    }

    public XMLGregorianCalendar getHRORIGEM() {
        return this.hrorigem;
    }

    public void setHRORIGEM(XMLGregorianCalendar xMLGregorianCalendar) {
        this.hrorigem = xMLGregorianCalendar;
    }

    public String getTPCDCLI() {
        return this.tpcdcli;
    }

    public void setTPCDCLI(String str) {
        this.tpcdcli = str;
    }

    public String getINDAGEND() {
        return this.indagend;
    }

    public void setINDAGEND(String str) {
        this.indagend = str;
    }
}
