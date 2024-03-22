package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_RESOLUCION_PMAS_Type", propOrder = {"tipresultado", "codresultado"})
public class CODIGORESOLUCIONPMASType {
    @XmlElement(name = "COD_RESULTADO", required = true)
    protected String codresultado;
    @XmlElement(name = "TIP_RESULTADO", required = true)
    protected String tipresultado;

    public String getTIPRESULTADO() {
        return this.tipresultado;
    }

    public void setTIPRESULTADO(String str) {
        this.tipresultado = str;
    }

    public String getCODRESULTADO() {
        return this.codresultado;
    }

    public void setCODRESULTADO(String str) {
        this.codresultado = str;
    }
}
