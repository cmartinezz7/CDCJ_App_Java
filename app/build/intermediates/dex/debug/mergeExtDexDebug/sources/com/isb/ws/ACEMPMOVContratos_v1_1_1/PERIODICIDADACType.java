package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODICIDAD_AC_Type", propOrder = {"subtipodeproducto", "tipoperativaacuerdo", "tipodeperiodo", "numunidperiodo"})
public class PERIODICIDADACType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_UNID_PERIODO")
    protected int numunidperiodo;
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;
    @XmlElement(name = "TIPO_DE_PERIODO", required = true)
    protected String tipodeperiodo;
    @XmlElement(name = "TIP_OPERATIVA_ACUERDO", required = true)
    protected String tipoperativaacuerdo;

    public SUBTIPODEPRODUCTOType getSUBTIPODEPRODUCTO() {
        return this.subtipodeproducto;
    }

    public void setSUBTIPODEPRODUCTO(SUBTIPODEPRODUCTOType sUBTIPODEPRODUCTOType) {
        this.subtipodeproducto = sUBTIPODEPRODUCTOType;
    }

    public String getTIPOPERATIVAACUERDO() {
        return this.tipoperativaacuerdo;
    }

    public void setTIPOPERATIVAACUERDO(String str) {
        this.tipoperativaacuerdo = str;
    }

    public String getTIPODEPERIODO() {
        return this.tipodeperiodo;
    }

    public void setTIPODEPERIODO(String str) {
        this.tipodeperiodo = str;
    }

    public int getNUMUNIDPERIODO() {
        return this.numunidperiodo;
    }

    public void setNUMUNIDPERIODO(int i) {
        this.numunidperiodo = i;
    }
}
