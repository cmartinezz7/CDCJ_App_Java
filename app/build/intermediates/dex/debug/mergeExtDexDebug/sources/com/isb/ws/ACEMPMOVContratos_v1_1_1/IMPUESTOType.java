package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPUESTO_Type", propOrder = {"tipodeimpositivo", "codigodeimpuesto"})
public class IMPUESTOType {
    @XmlElement(name = "CODIGO_DE_IMPUESTO", required = true)
    protected String codigodeimpuesto;
    @XmlElement(name = "TIPO_DE_IMPOSITIVO", required = true)
    protected String tipodeimpositivo;

    public String getTIPODEIMPOSITIVO() {
        return this.tipodeimpositivo;
    }

    public void setTIPODEIMPOSITIVO(String str) {
        this.tipodeimpositivo = str;
    }

    public String getCODIGODEIMPUESTO() {
        return this.codigodeimpuesto;
    }

    public void setCODIGODEIMPUESTO(String str) {
        this.codigodeimpuesto = str;
    }
}
