package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_SERVICIO_OBJ_Type", propOrder = {"mobobjetooper", "servicio"})
public class MOBSERVICIOOBJType {
    @XmlElement(name = "MOB_OBJETO_OPER", required = true)
    protected MOBOBJETOOPERType mobobjetooper;
    @XmlElement(name = "SERVICIO", required = true)
    protected String servicio;

    public MOBOBJETOOPERType getMOBOBJETOOPER() {
        return this.mobobjetooper;
    }

    public void setMOBOBJETOOPER(MOBOBJETOOPERType mOBOBJETOOPERType) {
        this.mobobjetooper = mOBOBJETOOPERType;
    }

    public String getSERVICIO() {
        return this.servicio;
    }

    public void setSERVICIO(String str) {
        this.servicio = str;
    }
}
