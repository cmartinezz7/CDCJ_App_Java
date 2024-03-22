package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ESTADO_INTENTO_OBM_Type", propOrder = {"instalacionobm", "codestadointentoobm"})
public class ESTADOINTENTOOBMType {
    @XmlElement(name = "COD_ESTADO_INTENTO_OBM", required = true)
    protected String codestadointentoobm;
    @XmlElement(name = "INSTALACION_OBM", required = true)
    protected INSTALACIONOBMType instalacionobm;

    public INSTALACIONOBMType getINSTALACIONOBM() {
        return this.instalacionobm;
    }

    public void setINSTALACIONOBM(INSTALACIONOBMType iNSTALACIONOBMType) {
        this.instalacionobm = iNSTALACIONOBMType;
    }

    public String getCODESTADOINTENTOOBM() {
        return this.codestadointentoobm;
    }

    public void setCODESTADOINTENTOOBM(String str) {
        this.codestadointentoobm = str;
    }
}
