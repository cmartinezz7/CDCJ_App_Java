package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPTO_CONTRATO_Type", propOrder = {"sitconceptocontrat", "tipmorosidad"})
public class CONCEPTOCONTRATOType {
    @XmlElement(name = "SIT_CONCEPTO_CONTRAT", required = true)
    protected SITCONCEPTOCONTRATOType sitconceptocontrat;
    @XmlElement(name = "TIP_MOROSIDAD", required = true)
    protected String tipmorosidad;

    public SITCONCEPTOCONTRATOType getSITCONCEPTOCONTRAT() {
        return this.sitconceptocontrat;
    }

    public void setSITCONCEPTOCONTRAT(SITCONCEPTOCONTRATOType sITCONCEPTOCONTRATOType) {
        this.sitconceptocontrat = sITCONCEPTOCONTRATOType;
    }

    public String getTIPMOROSIDAD() {
        return this.tipmorosidad;
    }

    public void setTIPMOROSIDAD(String str) {
        this.tipmorosidad = str;
    }
}
