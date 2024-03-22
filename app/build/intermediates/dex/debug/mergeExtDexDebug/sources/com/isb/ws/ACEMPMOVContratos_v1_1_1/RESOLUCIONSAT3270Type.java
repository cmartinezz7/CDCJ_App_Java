package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RESOLUCION_SAT_3270_Type", propOrder = {"codigoresolucion", "subcodigoresolucion", "textoresolucion", "errorcodrecibido", "indflagrecibido"})
public class RESOLUCIONSAT3270Type {
    @XmlElement(name = "CODIGO_RESOLUCION", required = true)
    protected String codigoresolucion;
    @XmlElement(name = "ERROR_COD_RECIBIDO", required = true)
    protected String errorcodrecibido;
    @XmlElement(name = "IND_FLAG_RECIBIDO", required = true)
    protected String indflagrecibido;
    @XmlElement(name = "SUBCODIGO_RESOLUCION", required = true)
    protected String subcodigoresolucion;
    @XmlElement(name = "TEXTO_RESOLUCION", required = true)
    protected String textoresolucion;

    public String getCODIGORESOLUCION() {
        return this.codigoresolucion;
    }

    public void setCODIGORESOLUCION(String str) {
        this.codigoresolucion = str;
    }

    public String getSUBCODIGORESOLUCION() {
        return this.subcodigoresolucion;
    }

    public void setSUBCODIGORESOLUCION(String str) {
        this.subcodigoresolucion = str;
    }

    public String getTEXTORESOLUCION() {
        return this.textoresolucion;
    }

    public void setTEXTORESOLUCION(String str) {
        this.textoresolucion = str;
    }

    public String getERRORCODRECIBIDO() {
        return this.errorcodrecibido;
    }

    public void setERRORCODRECIBIDO(String str) {
        this.errorcodrecibido = str;
    }

    public String getINDFLAGRECIBIDO() {
        return this.indflagrecibido;
    }

    public void setINDFLAGRECIBIDO(String str) {
        this.indflagrecibido = str;
    }
}
