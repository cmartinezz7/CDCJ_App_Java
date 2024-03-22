package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_RESPUESTA_ACCIO_EXCOGL_Type", propOrder = {"empresa", "canalbasico", "codrespuestaaccio"})
public class IDRESPUESTAACCIOEXCOGLType {
    @XmlElement(name = "CANAL_BASICO", required = true)
    protected String canalbasico;
    @XmlElement(name = "COD_RESPUESTA_ACCIO", required = true)
    protected String codrespuestaaccio;
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getCANALBASICO() {
        return this.canalbasico;
    }

    public void setCANALBASICO(String str) {
        this.canalbasico = str;
    }

    public String getCODRESPUESTAACCIO() {
        return this.codrespuestaaccio;
    }

    public void setCODRESPUESTAACCIO(String str) {
        this.codrespuestaaccio = str;
    }
}
