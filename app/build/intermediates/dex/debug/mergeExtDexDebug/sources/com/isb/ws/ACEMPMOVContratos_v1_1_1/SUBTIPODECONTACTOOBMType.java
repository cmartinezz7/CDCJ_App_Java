package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBTIPO_DE_CONTACTO_OBM_Type", propOrder = {"instalacionobm", "codsubtipocontactoobm"})
public class SUBTIPODECONTACTOOBMType {
    @XmlElement(name = "COD_SUBTIPO_CONTACTO_OBM", required = true)
    protected String codsubtipocontactoobm;
    @XmlElement(name = "INSTALACION_OBM", required = true)
    protected INSTALACIONOBMType instalacionobm;

    public INSTALACIONOBMType getINSTALACIONOBM() {
        return this.instalacionobm;
    }

    public void setINSTALACIONOBM(INSTALACIONOBMType iNSTALACIONOBMType) {
        this.instalacionobm = iNSTALACIONOBMType;
    }

    public String getCODSUBTIPOCONTACTOOBM() {
        return this.codsubtipocontactoobm;
    }

    public void setCODSUBTIPOCONTACTOOBM(String str) {
        this.codsubtipocontactoobm = str;
    }
}
