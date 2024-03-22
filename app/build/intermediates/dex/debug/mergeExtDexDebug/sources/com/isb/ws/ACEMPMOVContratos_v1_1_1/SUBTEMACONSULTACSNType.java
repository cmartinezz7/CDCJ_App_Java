package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTEMA_CONSULTA_CSN_Type", propOrder = {"temaconsultacsn", "codigonum3"})
public class SUBTEMACONSULTACSNType {
    @XmlElement(name = "CODIGO_NUM_3", required = true)
    protected String codigonum3;
    @XmlElement(name = "TEMA_CONSULTA_CSN", required = true)
    protected TEMACONSULTACSNType temaconsultacsn;

    public TEMACONSULTACSNType getTEMACONSULTACSN() {
        return this.temaconsultacsn;
    }

    public void setTEMACONSULTACSN(TEMACONSULTACSNType tEMACONSULTACSNType) {
        this.temaconsultacsn = tEMACONSULTACSNType;
    }

    public String getCODIGONUM3() {
        return this.codigonum3;
    }

    public void setCODIGONUM3(String str) {
        this.codigonum3 = str;
    }
}
