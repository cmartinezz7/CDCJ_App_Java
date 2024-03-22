package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PERIODO_GEM_Type", propOrder = {"operaciongem", "codregla", "tipodeperiodo", "codprocedencia", "tippresentacion"})
public class PERIODOGEMType {
    @XmlElement(name = "COD_PROCEDENCIA", required = true)
    protected String codprocedencia;
    @XmlElement(name = "COD_REGLA", required = true)
    protected String codregla;
    @XmlElement(name = "OPERACION_GEM", required = true)
    protected OPERACIONGEMType operaciongem;
    @XmlElement(name = "TIPO_DE_PERIODO", required = true)
    protected String tipodeperiodo;
    @XmlElement(name = "TIP_PRESENTACION", required = true)
    protected String tippresentacion;

    public OPERACIONGEMType getOPERACIONGEM() {
        return this.operaciongem;
    }

    public void setOPERACIONGEM(OPERACIONGEMType oPERACIONGEMType) {
        this.operaciongem = oPERACIONGEMType;
    }

    public String getCODREGLA() {
        return this.codregla;
    }

    public void setCODREGLA(String str) {
        this.codregla = str;
    }

    public String getTIPODEPERIODO() {
        return this.tipodeperiodo;
    }

    public void setTIPODEPERIODO(String str) {
        this.tipodeperiodo = str;
    }

    public String getCODPROCEDENCIA() {
        return this.codprocedencia;
    }

    public void setCODPROCEDENCIA(String str) {
        this.codprocedencia = str;
    }

    public String getTIPPRESENTACION() {
        return this.tippresentacion;
    }

    public void setTIPPRESENTACION(String str) {
        this.tippresentacion = str;
    }
}
