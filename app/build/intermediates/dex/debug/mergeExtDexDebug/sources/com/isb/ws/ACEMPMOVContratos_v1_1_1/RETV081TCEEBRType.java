package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RETV081_TCEE_BR_Type", propOrder = {"codent", "fcambibr", "cdmoedbr", "inddivbr", "indcotbr", "cambfibr", "cambbabr", "cambalbr", "segmenbr", "ultmodbr", "banculbr", "oficulbr", "numterbr", "usultmbr"})
public class RETV081TCEEBRType {
    @XmlElement(name = "BANCUL_BR", required = true)
    protected String banculbr;
    @XmlElement(name = "CAMBAL_BR", required = true)
    protected BigDecimal cambalbr;
    @XmlElement(name = "CAMBBA_BR", required = true)
    protected BigDecimal cambbabr;
    @XmlElement(name = "CAMBFI_BR", required = true)
    protected BigDecimal cambfibr;
    @XmlElement(name = "CDMOED_BR", required = true)
    protected String cdmoedbr;
    @XmlElement(name = "CODENT", required = true)
    protected String codent;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FCAMBI_BR", required = true)
    protected XMLGregorianCalendar fcambibr;
    @XmlElement(name = "INDCOT_BR", required = true)
    protected String indcotbr;
    @XmlElement(name = "INDDIV_BR", required = true)
    protected String inddivbr;
    @XmlElement(name = "NUMTER_BR", required = true)
    protected String numterbr;
    @XmlElement(name = "OFICUL_BR", required = true)
    protected String oficulbr;
    @XmlElement(name = "SEGMEN_BR", required = true)
    protected String segmenbr;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "ULTMOD_BR", required = true)
    protected XMLGregorianCalendar ultmodbr;
    @XmlElement(name = "USULTM_BR", required = true)
    protected String usultmbr;

    public String getCODENT() {
        return this.codent;
    }

    public void setCODENT(String str) {
        this.codent = str;
    }

    public XMLGregorianCalendar getFCAMBIBR() {
        return this.fcambibr;
    }

    public void setFCAMBIBR(XMLGregorianCalendar xMLGregorianCalendar) {
        this.fcambibr = xMLGregorianCalendar;
    }

    public String getCDMOEDBR() {
        return this.cdmoedbr;
    }

    public void setCDMOEDBR(String str) {
        this.cdmoedbr = str;
    }

    public String getINDDIVBR() {
        return this.inddivbr;
    }

    public void setINDDIVBR(String str) {
        this.inddivbr = str;
    }

    public String getINDCOTBR() {
        return this.indcotbr;
    }

    public void setINDCOTBR(String str) {
        this.indcotbr = str;
    }

    public BigDecimal getCAMBFIBR() {
        return this.cambfibr;
    }

    public void setCAMBFIBR(BigDecimal bigDecimal) {
        this.cambfibr = bigDecimal;
    }

    public BigDecimal getCAMBBABR() {
        return this.cambbabr;
    }

    public void setCAMBBABR(BigDecimal bigDecimal) {
        this.cambbabr = bigDecimal;
    }

    public BigDecimal getCAMBALBR() {
        return this.cambalbr;
    }

    public void setCAMBALBR(BigDecimal bigDecimal) {
        this.cambalbr = bigDecimal;
    }

    public String getSEGMENBR() {
        return this.segmenbr;
    }

    public void setSEGMENBR(String str) {
        this.segmenbr = str;
    }

    public XMLGregorianCalendar getULTMODBR() {
        return this.ultmodbr;
    }

    public void setULTMODBR(XMLGregorianCalendar xMLGregorianCalendar) {
        this.ultmodbr = xMLGregorianCalendar;
    }

    public String getBANCULBR() {
        return this.banculbr;
    }

    public void setBANCULBR(String str) {
        this.banculbr = str;
    }

    public String getOFICULBR() {
        return this.oficulbr;
    }

    public void setOFICULBR(String str) {
        this.oficulbr = str;
    }

    public String getNUMTERBR() {
        return this.numterbr;
    }

    public void setNUMTERBR(String str) {
        this.numterbr = str;
    }

    public String getUSULTMBR() {
        return this.usultmbr;
    }

    public void setUSULTMBR(String str) {
        this.usultmbr = str;
    }
}
