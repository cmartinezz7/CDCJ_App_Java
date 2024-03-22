package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RESULTADO_GESTION_NIVEL2_Type", propOrder = {"resultadogestionnivel1", "codmotivodelresultado"})
public class RESULTADOGESTIONNIVEL2Type {
    @XmlElement(name = "COD_MOTIVO_DEL_RESULTADO", required = true)
    protected String codmotivodelresultado;
    @XmlElement(name = "RESULTADO_GESTION_NIVEL1", required = true)
    protected RESULTADOGESTIONNIVEL1Type resultadogestionnivel1;

    public RESULTADOGESTIONNIVEL1Type getRESULTADOGESTIONNIVEL1() {
        return this.resultadogestionnivel1;
    }

    public void setRESULTADOGESTIONNIVEL1(RESULTADOGESTIONNIVEL1Type rESULTADOGESTIONNIVEL1Type) {
        this.resultadogestionnivel1 = rESULTADOGESTIONNIVEL1Type;
    }

    public String getCODMOTIVODELRESULTADO() {
        return this.codmotivodelresultado;
    }

    public void setCODMOTIVODELRESULTADO(String str) {
        this.codmotivodelresultado = str;
    }
}
