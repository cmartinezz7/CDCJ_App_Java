package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_CALIFICACION_AGENCIA_Type", propOrder = {"bmgagenciarating", "bmgtiporating", "codcalificador"})
public class BMGCALIFICACIONAGENCIAType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "BMG_AGENCIA_RATING")
    protected int bmgagenciarating;
    @XmlElement(name = "BMG_TIPO_RATING", required = true)
    protected String bmgtiporating;
    @XmlElement(name = "COD_CALIFICADOR", required = true)
    protected String codcalificador;

    public int getBMGAGENCIARATING() {
        return this.bmgagenciarating;
    }

    public void setBMGAGENCIARATING(int i) {
        this.bmgagenciarating = i;
    }

    public String getBMGTIPORATING() {
        return this.bmgtiporating;
    }

    public void setBMGTIPORATING(String str) {
        this.bmgtiporating = str;
    }

    public String getCODCALIFICADOR() {
        return this.codcalificador;
    }

    public void setCODCALIFICADOR(String str) {
        this.codcalificador = str;
    }
}
