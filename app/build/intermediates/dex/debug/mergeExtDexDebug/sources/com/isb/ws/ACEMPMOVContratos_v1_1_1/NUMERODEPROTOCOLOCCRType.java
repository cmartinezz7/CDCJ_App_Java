package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NUMERO_DE_PROTOCOLO_CCR_Type", propOrder = {"empresa", "canal", "connid", "secuencial", "idccrasunto"})
public class NUMERODEPROTOCOLOCCRType {
    @XmlElement(name = "CANAL", required = true)
    protected String canal;
    @XmlElement(name = "CONNID", required = true)
    protected String connid;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_CCR_ASUNTO")
    protected long idccrasunto;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "SECUENCIAL")
    protected int secuencial;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANAL() {
        return this.canal;
    }

    public void setCANAL(String str) {
        this.canal = str;
    }

    public String getCONNID() {
        return this.connid;
    }

    public void setCONNID(String str) {
        this.connid = str;
    }

    public int getSECUENCIAL() {
        return this.secuencial;
    }

    public void setSECUENCIAL(int i) {
        this.secuencial = i;
    }

    public long getIDCCRASUNTO() {
        return this.idccrasunto;
    }

    public void setIDCCRASUNTO(long j) {
        this.idccrasunto = j;
    }
}
