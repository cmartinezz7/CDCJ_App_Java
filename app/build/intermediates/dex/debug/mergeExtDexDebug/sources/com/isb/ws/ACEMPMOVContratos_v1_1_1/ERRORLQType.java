package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERROR_LQ_Type", propOrder = {"codigoaplicacion", "codigoerrorinternolq"})
public class ERRORLQType {
    @XmlElement(name = "CODIGO_APLICACION", required = true)
    protected String codigoaplicacion;
    @XmlElement(name = "CODIGO_ERROR_INTERNO_LQ", required = true)
    protected String codigoerrorinternolq;

    public String getCODIGOAPLICACION() {
        return this.codigoaplicacion;
    }

    public void setCODIGOAPLICACION(String str) {
        this.codigoaplicacion = str;
    }

    public String getCODIGOERRORINTERNOLQ() {
        return this.codigoerrorinternolq;
    }

    public void setCODIGOERRORINTERNOLQ(String str) {
        this.codigoerrorinternolq = str;
    }
}
