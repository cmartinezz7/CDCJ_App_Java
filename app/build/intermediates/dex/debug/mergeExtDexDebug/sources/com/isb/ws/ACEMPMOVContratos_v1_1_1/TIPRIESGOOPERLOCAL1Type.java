package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_RIESGO_OPER_LOCAL_1_Type", propOrder = {"empresa", "idtipriesgolocal1"})
public class TIPRIESGOOPERLOCAL1Type {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "ID_TIP_RIESGO_LOCAL_1", required = true)
    protected String idtipriesgolocal1;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getIDTIPRIESGOLOCAL1() {
        return this.idtipriesgolocal1;
    }

    public void setIDTIPRIESGOLOCAL1(String str) {
        this.idtipriesgolocal1 = str;
    }
}
