package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEP_VALOR_CONV_GENERAL_Type", propOrder = {"conceptoconvgeneral", "valorconcepconvgeneral"})
public class CONCEPVALORCONVGENERALType {
    @XmlElement(name = "CONCEPTO_CONV_GENERAL", required = true)
    protected CONCEPTOCONVGENERALType conceptoconvgeneral;
    @XmlElement(name = "VALOR_CONCEP_CONV_GENERAL", required = true)
    protected String valorconcepconvgeneral;

    public CONCEPTOCONVGENERALType getCONCEPTOCONVGENERAL() {
        return this.conceptoconvgeneral;
    }

    public void setCONCEPTOCONVGENERAL(CONCEPTOCONVGENERALType cONCEPTOCONVGENERALType) {
        this.conceptoconvgeneral = cONCEPTOCONVGENERALType;
    }

    public String getVALORCONCEPCONVGENERAL() {
        return this.valorconcepconvgeneral;
    }

    public void setVALORCONCEPCONVGENERAL(String str) {
        this.valorconcepconvgeneral = str;
    }
}
