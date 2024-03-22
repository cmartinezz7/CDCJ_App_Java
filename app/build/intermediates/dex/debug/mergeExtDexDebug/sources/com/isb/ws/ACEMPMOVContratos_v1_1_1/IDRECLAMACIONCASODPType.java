package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_RECLAMACION_CASO_DP_Type", propOrder = {"centro", "codigocasoreclamacion", "version", "codigoreclamacion"})
public class IDRECLAMACIONCASODPType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_CASO_RECLAMACION")
    protected long codigocasoreclamacion;
    @XmlElement(name = "CODIGO_RECLAMACION", required = true)
    protected String codigoreclamacion;
    @XmlElement(name = "VERSION", required = true)
    protected String version;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public long getCODIGOCASORECLAMACION() {
        return this.codigocasoreclamacion;
    }

    public void setCODIGOCASORECLAMACION(long j) {
        this.codigocasoreclamacion = j;
    }

    public String getVERSION() {
        return this.version;
    }

    public void setVERSION(String str) {
        this.version = str;
    }

    public String getCODIGORECLAMACION() {
        return this.codigoreclamacion;
    }

    public void setCODIGORECLAMACION(String str) {
        this.codigoreclamacion = str;
    }
}
