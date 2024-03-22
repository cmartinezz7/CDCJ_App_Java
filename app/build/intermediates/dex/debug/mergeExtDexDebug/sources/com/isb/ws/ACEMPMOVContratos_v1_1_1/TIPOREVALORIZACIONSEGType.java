package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_REVALORIZACION_SEG_Type", propOrder = {"idtarifafabricaseg", "tipodatoafectado", "codigorevalorizacion"})
public class TIPOREVALORIZACIONSEGType {
    @XmlElement(name = "CODIGO_REVALORIZACION", required = true)
    protected String codigorevalorizacion;
    @XmlElement(name = "ID_TARIFA_FABRICA_SEG", required = true)
    protected IDTARIFAFABRICASEGType idtarifafabricaseg;
    @XmlElement(name = "TIPO_DATO_AFECTADO", required = true)
    protected String tipodatoafectado;

    public IDTARIFAFABRICASEGType getIDTARIFAFABRICASEG() {
        return this.idtarifafabricaseg;
    }

    public void setIDTARIFAFABRICASEG(IDTARIFAFABRICASEGType iDTARIFAFABRICASEGType) {
        this.idtarifafabricaseg = iDTARIFAFABRICASEGType;
    }

    public String getTIPODATOAFECTADO() {
        return this.tipodatoafectado;
    }

    public void setTIPODATOAFECTADO(String str) {
        this.tipodatoafectado = str;
    }

    public String getCODIGOREVALORIZACION() {
        return this.codigorevalorizacion;
    }

    public void setCODIGOREVALORIZACION(String str) {
        this.codigorevalorizacion = str;
    }
}
