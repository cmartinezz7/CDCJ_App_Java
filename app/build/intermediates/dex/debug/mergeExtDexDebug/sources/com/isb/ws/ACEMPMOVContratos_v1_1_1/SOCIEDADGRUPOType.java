package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOCIEDAD_GRUPO_Type", propOrder = {"tiposociedad", "codigosociedad"})
public class SOCIEDADGRUPOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_SOCIEDAD")
    protected int codigosociedad;
    @XmlElement(name = "TIPO_SOCIEDAD", required = true)
    protected String tiposociedad;

    public String getTIPOSOCIEDAD() {
        return this.tiposociedad;
    }

    public void setTIPOSOCIEDAD(String str) {
        this.tiposociedad = str;
    }

    public int getCODIGOSOCIEDAD() {
        return this.codigosociedad;
    }

    public void setCODIGOSOCIEDAD(int i) {
        this.codigosociedad = i;
    }
}
