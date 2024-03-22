package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CLAVTCEE_BR_Type", propOrder = {"indtcebr", "codent", "fcambibr", "cdmoedbr", "inddivbr", "segmenbr"})
public class CLAVTCEEBRType {
    @XmlElement(name = "CDMOED_BR", required = true)
    protected String cdmoedbr;
    @XmlElement(name = "CODENT", required = true)
    protected String codent;
    @XmlSchemaType(name = "date")
    @XmlElement(name = "FCAMBI_BR", required = true)
    protected XMLGregorianCalendar fcambibr;
    @XmlElement(name = "INDDIV_BR", required = true)
    protected String inddivbr;
    @XmlElement(name = "INDTCE_BR", required = true)
    protected String indtcebr;
    @XmlElement(name = "SEGMEN_BR", required = true)
    protected String segmenbr;

    public String getINDTCEBR() {
        return this.indtcebr;
    }

    public void setINDTCEBR(String str) {
        this.indtcebr = str;
    }

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

    public String getSEGMENBR() {
        return this.segmenbr;
    }

    public void setSEGMENBR(String str) {
        this.segmenbr = str;
    }
}
