package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_DE_EVENTO_Type", propOrder = {"clasedeevento", "codtipodeevento"})
public class TIPODEEVENTOType {
    @XmlElement(name = "CLASE_DE_EVENTO", required = true)
    protected CLASEDEEVENTOType clasedeevento;
    @XmlElement(name = "COD_TIPO_DE_EVENTO", required = true)
    protected String codtipodeevento;

    public CLASEDEEVENTOType getCLASEDEEVENTO() {
        return this.clasedeevento;
    }

    public void setCLASEDEEVENTO(CLASEDEEVENTOType cLASEDEEVENTOType) {
        this.clasedeevento = cLASEDEEVENTOType;
    }

    public String getCODTIPODEEVENTO() {
        return this.codtipodeevento;
    }

    public void setCODTIPODEEVENTO(String str) {
        this.codtipodeevento = str;
    }
}
