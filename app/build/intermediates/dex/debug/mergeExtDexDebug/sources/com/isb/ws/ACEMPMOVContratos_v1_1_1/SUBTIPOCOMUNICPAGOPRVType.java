package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_COMUNIC_PAGO_PRV_Type", propOrder = {"tipcomunicacionpagoprv", "codsubtipocomunic"})
public class SUBTIPOCOMUNICPAGOPRVType {
    @XmlElement(name = "COD_SUBTIPO_COMUNIC", required = true)
    protected String codsubtipocomunic;
    @XmlElement(name = "TIP_COMUNICACION_PAGO_PRV", required = true)
    protected String tipcomunicacionpagoprv;

    public String getTIPCOMUNICACIONPAGOPRV() {
        return this.tipcomunicacionpagoprv;
    }

    public void setTIPCOMUNICACIONPAGOPRV(String str) {
        this.tipcomunicacionpagoprv = str;
    }

    public String getCODSUBTIPOCOMUNIC() {
        return this.codsubtipocomunic;
    }

    public void setCODSUBTIPOCOMUNIC(String str) {
        this.codsubtipocomunic = str;
    }
}
