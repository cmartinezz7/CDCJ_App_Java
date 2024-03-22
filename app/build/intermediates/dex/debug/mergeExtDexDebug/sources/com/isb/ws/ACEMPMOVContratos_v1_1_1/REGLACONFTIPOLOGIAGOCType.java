package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REGLA_CONF_TIPOLOGIA_GOC_Type", propOrder = {"tipologiacampania", "codregla", "codconfiguracionregla"})
public class REGLACONFTIPOLOGIAGOCType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_CONFIGURACION_REGLA")
    protected int codconfiguracionregla;
    @XmlElement(name = "COD_REGLA", required = true)
    protected String codregla;
    @XmlElement(name = "TIPOLOGIA_CAMPANIA", required = true)
    protected TIPOLOGIACAMPANIACOPCOMType tipologiacampania;

    public TIPOLOGIACAMPANIACOPCOMType getTIPOLOGIACAMPANIA() {
        return this.tipologiacampania;
    }

    public void setTIPOLOGIACAMPANIA(TIPOLOGIACAMPANIACOPCOMType tIPOLOGIACAMPANIACOPCOMType) {
        this.tipologiacampania = tIPOLOGIACAMPANIACOPCOMType;
    }

    public String getCODREGLA() {
        return this.codregla;
    }

    public void setCODREGLA(String str) {
        this.codregla = str;
    }

    public int getCODCONFIGURACIONREGLA() {
        return this.codconfiguracionregla;
    }

    public void setCODCONFIGURACIONREGLA(int i) {
        this.codconfiguracionregla = i;
    }
}
