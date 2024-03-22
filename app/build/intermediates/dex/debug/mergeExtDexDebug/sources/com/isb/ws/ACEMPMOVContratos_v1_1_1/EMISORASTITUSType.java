package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EMISORAS_TITUS_Type", propOrder = {"codigoemisoratitus", "ratingtitus"})
public class EMISORASTITUSType {
    @XmlElement(name = "CODIGO_EMISORA_TITUS", required = true)
    protected String codigoemisoratitus;
    @XmlElement(name = "RATING_TITUS", required = true)
    protected RATINGTITUSType ratingtitus;

    public String getCODIGOEMISORATITUS() {
        return this.codigoemisoratitus;
    }

    public void setCODIGOEMISORATITUS(String str) {
        this.codigoemisoratitus = str;
    }

    public RATINGTITUSType getRATINGTITUS() {
        return this.ratingtitus;
    }

    public void setRATINGTITUS(RATINGTITUSType rATINGTITUSType) {
        this.ratingtitus = rATINGTITUSType;
    }
}
