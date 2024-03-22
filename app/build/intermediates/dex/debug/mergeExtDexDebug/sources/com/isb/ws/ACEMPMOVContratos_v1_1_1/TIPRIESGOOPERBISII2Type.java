package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_RIESGO_OPER_BIS_II_2_Type", propOrder = {"tipriesgooperbisii1", "idtipriesgobisii2"})
public class TIPRIESGOOPERBISII2Type {
    @XmlElement(name = "ID_TIP_RIESGO_BIS_II_2", required = true)
    protected String idtipriesgobisii2;
    @XmlElement(name = "TIP_RIESGO_OPER_BIS_II_1", required = true)
    protected String tipriesgooperbisii1;

    public String getTIPRIESGOOPERBISII1() {
        return this.tipriesgooperbisii1;
    }

    public void setTIPRIESGOOPERBISII1(String str) {
        this.tipriesgooperbisii1 = str;
    }

    public String getIDTIPRIESGOBISII2() {
        return this.idtipriesgobisii2;
    }

    public void setIDTIPRIESGOBISII2(String str) {
        this.idtipriesgobisii2 = str;
    }
}
