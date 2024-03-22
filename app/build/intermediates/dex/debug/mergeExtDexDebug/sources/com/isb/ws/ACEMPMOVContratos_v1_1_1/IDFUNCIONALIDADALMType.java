package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_FUNCIONALIDAD_ALM_Type", propOrder = {"codaplicacionalm", "codfuncionalidad"})
public class IDFUNCIONALIDADALMType {
    @XmlElement(name = "COD_APLICACION_ALM", required = true)
    protected String codaplicacionalm;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_FUNCIONALIDAD")
    protected int codfuncionalidad;

    public String getCODAPLICACIONALM() {
        return this.codaplicacionalm;
    }

    public void setCODAPLICACIONALM(String str) {
        this.codaplicacionalm = str;
    }

    public int getCODFUNCIONALIDAD() {
        return this.codfuncionalidad;
    }

    public void setCODFUNCIONALIDAD(int i) {
        this.codfuncionalidad = i;
    }
}
