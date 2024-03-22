package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_RIESGO_OPER_LOCAL_2_Type", propOrder = {"tipriesgooperlocal1", "idtipriesgolocal2"})
public class TIPRIESGOOPERLOCAL2Type {
    @XmlElement(name = "ID_TIP_RIESGO_LOCAL_2", required = true)
    protected String idtipriesgolocal2;
    @XmlElement(name = "TIP_RIESGO_OPER_LOCAL_1", required = true)
    protected TIPRIESGOOPERLOCAL1Type tipriesgooperlocal1;

    public TIPRIESGOOPERLOCAL1Type getTIPRIESGOOPERLOCAL1() {
        return this.tipriesgooperlocal1;
    }

    public void setTIPRIESGOOPERLOCAL1(TIPRIESGOOPERLOCAL1Type tIPRIESGOOPERLOCAL1Type) {
        this.tipriesgooperlocal1 = tIPRIESGOOPERLOCAL1Type;
    }

    public String getIDTIPRIESGOLOCAL2() {
        return this.idtipriesgolocal2;
    }

    public void setIDTIPRIESGOLOCAL2(String str) {
        this.idtipriesgolocal2 = str;
    }
}
