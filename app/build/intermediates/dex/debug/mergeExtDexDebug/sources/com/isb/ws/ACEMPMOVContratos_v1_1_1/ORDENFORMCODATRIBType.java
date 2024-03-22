package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORDEN_FORM_COD_ATRIB_Type", propOrder = {"codatributoproducto", "codigonumerico1"})
public class ORDENFORMCODATRIBType {
    @XmlElement(name = "COD_ATRIBUTO_PRODUCTO", required = true)
    protected String codatributoproducto;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_NUMERICO_1")
    protected int codigonumerico1;

    public String getCODATRIBUTOPRODUCTO() {
        return this.codatributoproducto;
    }

    public void setCODATRIBUTOPRODUCTO(String str) {
        this.codatributoproducto = str;
    }

    public int getCODIGONUMERICO1() {
        return this.codigonumerico1;
    }

    public void setCODIGONUMERICO1(int i) {
        this.codigonumerico1 = i;
    }
}
