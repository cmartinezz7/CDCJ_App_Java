package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_CLASIFICACION_FONDO_Type", propOrder = {"indclasificacionfondo", "codvalorindicador"})
public class VALORCLASIFICACIONFONDOType {
    @XmlElement(name = "COD_VALOR_INDICADOR", required = true)
    protected String codvalorindicador;
    @XmlElement(name = "IND_CLASIFICACION_FONDO", required = true)
    protected INDCLASIFICACIONFONDOType indclasificacionfondo;

    public INDCLASIFICACIONFONDOType getINDCLASIFICACIONFONDO() {
        return this.indclasificacionfondo;
    }

    public void setINDCLASIFICACIONFONDO(INDCLASIFICACIONFONDOType iNDCLASIFICACIONFONDOType) {
        this.indclasificacionfondo = iNDCLASIFICACIONFONDOType;
    }

    public String getCODVALORINDICADOR() {
        return this.codvalorindicador;
    }

    public void setCODVALORINDICADOR(String str) {
        this.codvalorindicador = str;
    }
}
