package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRANSICION_LZD_Type", propOrder = {"tipotransicionlzd", "idtransicion"})
public class TRANSICIONLZDType {
    @XmlElement(name = "ID_TRANSICION", required = true)
    protected String idtransicion;
    @XmlElement(name = "TIPO_TRANSICION_LZD", required = true)
    protected TIPOTRANSICIONLZDType tipotransicionlzd;

    public TIPOTRANSICIONLZDType getTIPOTRANSICIONLZD() {
        return this.tipotransicionlzd;
    }

    public void setTIPOTRANSICIONLZD(TIPOTRANSICIONLZDType tIPOTRANSICIONLZDType) {
        this.tipotransicionlzd = tIPOTRANSICIONLZDType;
    }

    public String getIDTRANSICION() {
        return this.idtransicion;
    }

    public void setIDTRANSICION(String str) {
        this.idtransicion = str;
    }
}
