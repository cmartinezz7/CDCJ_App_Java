package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RETROCESION_DEB_PCAS_Type", propOrder = {"conceptoeconomico", "codretrocesion"})
public class RETROCESIONDEBPCASType {
    @XmlElement(name = "COD_RETROCESION", required = true)
    protected String codretrocesion;
    @XmlElement(name = "CONCEPTO_ECONOMICO", required = true)
    protected CONCEPTOECONOMDEBPCASType conceptoeconomico;

    public CONCEPTOECONOMDEBPCASType getCONCEPTOECONOMICO() {
        return this.conceptoeconomico;
    }

    public void setCONCEPTOECONOMICO(CONCEPTOECONOMDEBPCASType cONCEPTOECONOMDEBPCASType) {
        this.conceptoeconomico = cONCEPTOECONOMDEBPCASType;
    }

    public String getCODRETROCESION() {
        return this.codretrocesion;
    }

    public void setCODRETROCESION(String str) {
        this.codretrocesion = str;
    }
}
