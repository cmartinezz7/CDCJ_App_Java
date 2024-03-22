package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DESCRIPCION_TRADUCIBLE_Type", propOrder = {"claveconcatenada", "codigotipodedato", "formatotexto", "idiomacorporativo", "concepto", "descripcion"})
public class DESCRIPCIONTRADUCIBLEType {
    @XmlElement(name = "CLAVE_CONCATENADA", required = true)
    protected String claveconcatenada;
    @XmlElement(name = "CODIGO_TIPO_DE_DATO", required = true)
    protected String codigotipodedato;
    @XmlElement(name = "CONCEPTO", required = true)
    protected String concepto;
    @XmlElement(name = "DESCRIPCION", required = true)
    protected String descripcion;
    @XmlElement(name = "FORMATO_TEXTO", required = true)
    protected String formatotexto;
    @XmlElement(name = "IDIOMA_CORPORATIVO", required = true)
    protected IDIOMACORPORATIVOType idiomacorporativo;

    public String getCLAVECONCATENADA() {
        return this.claveconcatenada;
    }

    public void setCLAVECONCATENADA(String str) {
        this.claveconcatenada = str;
    }

    public String getCODIGOTIPODEDATO() {
        return this.codigotipodedato;
    }

    public void setCODIGOTIPODEDATO(String str) {
        this.codigotipodedato = str;
    }

    public String getFORMATOTEXTO() {
        return this.formatotexto;
    }

    public void setFORMATOTEXTO(String str) {
        this.formatotexto = str;
    }

    public IDIOMACORPORATIVOType getIDIOMACORPORATIVO() {
        return this.idiomacorporativo;
    }

    public void setIDIOMACORPORATIVO(IDIOMACORPORATIVOType iDIOMACORPORATIVOType) {
        this.idiomacorporativo = iDIOMACORPORATIVOType;
    }

    public String getCONCEPTO() {
        return this.concepto;
    }

    public void setCONCEPTO(String str) {
        this.concepto = str;
    }

    public String getDESCRIPCION() {
        return this.descripcion;
    }

    public void setDESCRIPCION(String str) {
        this.descripcion = str;
    }
}
