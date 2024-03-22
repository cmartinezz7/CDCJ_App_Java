package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDENTIF_ORGANISMO_GR_Type", propOrder = {"biciso", "ibeiiso", "beiiso", "eanglniso", "chipsiso", "dunsiso", "relclbaniso", "tasaidiso", "idenproiso", "entidproiso"})
public class IDENTIFORGANISMOGRType {
    @XmlElement(name = "BEI_ISO", required = true)
    protected String beiiso;
    @XmlElement(name = "BIC_ISO", required = true)
    protected String biciso;
    @XmlElement(name = "CHIPS_ISO", required = true)
    protected String chipsiso;
    @XmlElement(name = "DUNS_ISO", required = true)
    protected String dunsiso;
    @XmlElement(name = "EANGLN_ISO", required = true)
    protected String eanglniso;
    @XmlElement(name = "ENTIDPRO_ISO", required = true)
    protected String entidproiso;
    @XmlElement(name = "IBEI_ISO", required = true)
    protected String ibeiiso;
    @XmlElement(name = "IDENPRO_ISO", required = true)
    protected String idenproiso;
    @XmlElement(name = "RELCLBAN_ISO", required = true)
    protected String relclbaniso;
    @XmlElement(name = "TASAID_ISO", required = true)
    protected String tasaidiso;

    public String getBICISO() {
        return this.biciso;
    }

    public void setBICISO(String str) {
        this.biciso = str;
    }

    public String getIBEIISO() {
        return this.ibeiiso;
    }

    public void setIBEIISO(String str) {
        this.ibeiiso = str;
    }

    public String getBEIISO() {
        return this.beiiso;
    }

    public void setBEIISO(String str) {
        this.beiiso = str;
    }

    public String getEANGLNISO() {
        return this.eanglniso;
    }

    public void setEANGLNISO(String str) {
        this.eanglniso = str;
    }

    public String getCHIPSISO() {
        return this.chipsiso;
    }

    public void setCHIPSISO(String str) {
        this.chipsiso = str;
    }

    public String getDUNSISO() {
        return this.dunsiso;
    }

    public void setDUNSISO(String str) {
        this.dunsiso = str;
    }

    public String getRELCLBANISO() {
        return this.relclbaniso;
    }

    public void setRELCLBANISO(String str) {
        this.relclbaniso = str;
    }

    public String getTASAIDISO() {
        return this.tasaidiso;
    }

    public void setTASAIDISO(String str) {
        this.tasaidiso = str;
    }

    public String getIDENPROISO() {
        return this.idenproiso;
    }

    public void setIDENPROISO(String str) {
        this.idenproiso = str;
    }

    public String getENTIDPROISO() {
        return this.entidproiso;
    }

    public void setENTIDPROISO(String str) {
        this.entidproiso = str;
    }
}
