package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BENEFICIO_FISCAL_Type", propOrder = {"tipodebeneficiofiscal", "codbeneficio"})
public class BENEFICIOFISCALType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_BENEFICIO")
    protected int codbeneficio;
    @XmlElement(name = "TIPO_DE_BENEFICIO_FISCAL", required = true)
    protected String tipodebeneficiofiscal;

    public String getTIPODEBENEFICIOFISCAL() {
        return this.tipodebeneficiofiscal;
    }

    public void setTIPODEBENEFICIOFISCAL(String str) {
        this.tipodebeneficiofiscal = str;
    }

    public int getCODBENEFICIO() {
        return this.codbeneficio;
    }

    public void setCODBENEFICIO(int i) {
        this.codbeneficio = i;
    }
}
