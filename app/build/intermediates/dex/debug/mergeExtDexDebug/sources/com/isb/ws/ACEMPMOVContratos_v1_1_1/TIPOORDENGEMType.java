package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_ORDEN_GEM_Type", propOrder = {"formatoentradagem", "calificadorlocalorden", "tipooperacion", "codordenfinanciera"})
public class TIPOORDENGEMType {
    @XmlElement(name = "CALIFICADOR_LOCAL_ORDEN", required = true)
    protected String calificadorlocalorden;
    @XmlElement(name = "COD_ORDEN_FINANCIERA", required = true)
    protected String codordenfinanciera;
    @XmlElement(name = "FORMATO_ENTRADA_GEM", required = true)
    protected FORMATOENTRADAGEMType formatoentradagem;
    @XmlElement(name = "TIPO_OPERACION", required = true)
    protected String tipooperacion;

    public FORMATOENTRADAGEMType getFORMATOENTRADAGEM() {
        return this.formatoentradagem;
    }

    public void setFORMATOENTRADAGEM(FORMATOENTRADAGEMType fORMATOENTRADAGEMType) {
        this.formatoentradagem = fORMATOENTRADAGEMType;
    }

    public String getCALIFICADORLOCALORDEN() {
        return this.calificadorlocalorden;
    }

    public void setCALIFICADORLOCALORDEN(String str) {
        this.calificadorlocalorden = str;
    }

    public String getTIPOOPERACION() {
        return this.tipooperacion;
    }

    public void setTIPOOPERACION(String str) {
        this.tipooperacion = str;
    }

    public String getCODORDENFINANCIERA() {
        return this.codordenfinanciera;
    }

    public void setCODORDENFINANCIERA(String str) {
        this.codordenfinanciera = str;
    }
}
