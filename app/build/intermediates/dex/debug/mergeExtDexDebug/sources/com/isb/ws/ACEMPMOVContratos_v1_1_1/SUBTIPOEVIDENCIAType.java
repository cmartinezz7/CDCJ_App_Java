package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_EVIDENCIA_Type", propOrder = {"empresaconcodnum4", "codnum"})
public class SUBTIPOEVIDENCIAType {
    @XmlElement(name = "COD_NUM", required = true)
    protected String codnum;
    @XmlElement(name = "EMPRESA_CON_COD_NUM_4", required = true)
    protected TIPOEVIDENCIAType empresaconcodnum4;

    public TIPOEVIDENCIAType getEMPRESACONCODNUM4() {
        return this.empresaconcodnum4;
    }

    public void setEMPRESACONCODNUM4(TIPOEVIDENCIAType tIPOEVIDENCIAType) {
        this.empresaconcodnum4 = tIPOEVIDENCIAType;
    }

    public String getCODNUM() {
        return this.codnum;
    }

    public void setCODNUM(String str) {
        this.codnum = str;
    }
}
