package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CRITERIO_PERIODICIDAD_AC_Type", propOrder = {"subtipodeproducto", "tipoperativaacuerdo", "tipodeperiodo", "valorposible"})
public class CRITERIOPERIODICIDADACType {
    @XmlElement(name = "SUBTIPO_DE_PRODUCTO", required = true)
    protected SUBTIPODEPRODUCTOType subtipodeproducto;
    @XmlElement(name = "TIPO_DE_PERIODO", required = true)
    protected String tipodeperiodo;
    @XmlElement(name = "TIP_OPERATIVA_ACUERDO", required = true)
    protected String tipoperativaacuerdo;
    @XmlElement(name = "VALOR_POSIBLE", required = true)
    protected String valorposible;

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

    public String getVALORPOSIBLE() {
        return this.valorposible;
    }

    public void setVALORPOSIBLE(String str) {
        this.valorposible = str;
    }
}
