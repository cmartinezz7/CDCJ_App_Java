package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_RIESGO_OPER_ORX_2_Type", propOrder = {"tipriesgoopercorp1", "idtipriesgocorp2"})
public class TIPRIESGOOPERORX2Type {
    @XmlElement(name = "ID_TIP_RIESGO_CORP_2", required = true)
    protected String idtipriesgocorp2;
    @XmlElement(name = "TIP_RIESGO_OPER_CORP_1", required = true)
    protected String tipriesgoopercorp1;

    public String getTIPRIESGOOPERCORP1() {
        return this.tipriesgoopercorp1;
    }

    public void setTIPRIESGOOPERCORP1(String str) {
        this.tipriesgoopercorp1 = str;
    }

    public String getIDTIPRIESGOCORP2() {
        return this.idtipriesgocorp2;
    }

    public void setIDTIPRIESGOCORP2(String str) {
        this.idtipriesgocorp2 = str;
    }
}
