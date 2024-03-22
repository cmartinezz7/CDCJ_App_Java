package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_CONSULTA_CSN_Type", propOrder = {"tipoconsultacsn", "codigonum3"})
public class SUBTIPOCONSULTACSNType {
    @XmlElement(name = "CODIGO_NUM_3", required = true)
    protected String codigonum3;
    @XmlElement(name = "TIPO_CONSULTA_CSN", required = true)
    protected TIPOCONSULTACSNType tipoconsultacsn;

    public TIPOCONSULTACSNType getTIPOCONSULTACSN() {
        return this.tipoconsultacsn;
    }

    public void setTIPOCONSULTACSN(TIPOCONSULTACSNType tIPOCONSULTACSNType) {
        this.tipoconsultacsn = tIPOCONSULTACSNType;
    }

    public String getCODIGONUM3() {
        return this.codigonum3;
    }

    public void setCODIGONUM3(String str) {
        this.codigonum3 = str;
    }
}
