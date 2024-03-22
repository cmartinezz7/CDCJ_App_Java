package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SOLICITUD_CASO_PN_Type", propOrder = {"idcasopn", "codigodesolicitud"})
public class IDSOLICITUDCASOPNType {
    @XmlElement(name = "CODIGO_DE_SOLICITUD", required = true)
    protected String codigodesolicitud;
    @XmlElement(name = "ID_CASO_PN", required = true)
    protected IDCASOPNType idcasopn;

    public IDCASOPNType getIDCASOPN() {
        return this.idcasopn;
    }

    public void setIDCASOPN(IDCASOPNType iDCASOPNType) {
        this.idcasopn = iDCASOPNType;
    }

    public String getCODIGODESOLICITUD() {
        return this.codigodesolicitud;
    }

    public void setCODIGODESOLICITUD(String str) {
        this.codigodesolicitud = str;
    }
}
