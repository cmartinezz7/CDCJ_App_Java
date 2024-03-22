package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRODUCTO_DE_TESORERIA_Type", propOrder = {"estructuradetesoreria", "tipoproducto", "numerodeproducto"})
public class PRODUCTODETESORERIAType {
    @XmlElement(name = "ESTRUCTURA_DE_TESORERIA", required = true)
    protected ESTRUCTURADETESORERIAType estructuradetesoreria;
    @XmlElement(name = "NUMERO_DE_PRODUCTO", required = true)
    protected String numerodeproducto;
    @XmlElement(name = "TIPO_PRODUCTO", required = true)
    protected String tipoproducto;

    public ESTRUCTURADETESORERIAType getESTRUCTURADETESORERIA() {
        return this.estructuradetesoreria;
    }

    public void setESTRUCTURADETESORERIA(ESTRUCTURADETESORERIAType eSTRUCTURADETESORERIAType) {
        this.estructuradetesoreria = eSTRUCTURADETESORERIAType;
    }

    public String getTIPOPRODUCTO() {
        return this.tipoproducto;
    }

    public void setTIPOPRODUCTO(String str) {
        this.tipoproducto = str;
    }

    public String getNUMERODEPRODUCTO() {
        return this.numerodeproducto;
    }

    public void setNUMERODEPRODUCTO(String str) {
        this.numerodeproducto = str;
    }
}
