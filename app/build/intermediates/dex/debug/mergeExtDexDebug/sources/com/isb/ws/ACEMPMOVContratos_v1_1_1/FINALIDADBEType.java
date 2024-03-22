package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FINALIDAD_BE_Type", propOrder = {"codestadooficial", "codfinalidad"})
public class FINALIDADBEType {
    @XmlElement(name = "COD_ESTADO_OFICIAL", required = true)
    protected String codestadooficial;
    @XmlElement(name = "COD_FINALIDAD", required = true)
    protected String codfinalidad;

    public String getCODESTADOOFICIAL() {
        return this.codestadooficial;
    }

    public void setCODESTADOOFICIAL(String str) {
        this.codestadooficial = str;
    }

    public String getCODFINALIDAD() {
        return this.codfinalidad;
    }

    public void setCODFINALIDAD(String str) {
        this.codfinalidad = str;
    }
}
