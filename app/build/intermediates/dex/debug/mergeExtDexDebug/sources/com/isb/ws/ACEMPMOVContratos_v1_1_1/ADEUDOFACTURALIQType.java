package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ADEUDO_FACTURA_LIQ_Type", propOrder = {"empresa", "codigofactura", "numerofactura"})
public class ADEUDOFACTURALIQType {
    @XmlElement(name = "CODIGO_FACTURA", required = true)
    protected String codigofactura;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "NUMERO_FACTURA", required = true)
    protected String numerofactura;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODIGOFACTURA() {
        return this.codigofactura;
    }

    public void setCODIGOFACTURA(String str) {
        this.codigofactura = str;
    }

    public String getNUMEROFACTURA() {
        return this.numerofactura;
    }

    public void setNUMEROFACTURA(String str) {
        this.numerofactura = str;
    }
}
