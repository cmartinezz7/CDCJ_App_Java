package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORDEN_HCE_Type", propOrder = {"empresa", "codoperacionhce", "codigonumerico9"})
public class ORDENHCEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_NUMERICO_9")
    protected int codigonumerico9;
    @XmlElement(name = "COD_OPERACION_HCE", required = true)
    protected String codoperacionhce;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCODOPERACIONHCE() {
        return this.codoperacionhce;
    }

    public void setCODOPERACIONHCE(String str) {
        this.codoperacionhce = str;
    }

    public int getCODIGONUMERICO9() {
        return this.codigonumerico9;
    }

    public void setCODIGONUMERICO9(int i) {
        this.codigonumerico9 = i;
    }
}
