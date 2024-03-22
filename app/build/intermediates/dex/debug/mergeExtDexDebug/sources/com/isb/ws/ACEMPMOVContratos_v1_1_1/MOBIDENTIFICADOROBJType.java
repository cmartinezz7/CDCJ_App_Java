package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_IDENTIFICADOR_OBJ_Type", propOrder = {"mobobjetooper", "identificadormov"})
public class MOBIDENTIFICADOROBJType {
    @XmlElement(name = "IDENTIFICADOR_MOV", required = true)
    protected String identificadormov;
    @XmlElement(name = "MOB_OBJETO_OPER", required = true)
    protected MOBOBJETOOPERType mobobjetooper;

    public MOBOBJETOOPERType getMOBOBJETOOPER() {
        return this.mobobjetooper;
    }

    public void setMOBOBJETOOPER(MOBOBJETOOPERType mOBOBJETOOPERType) {
        this.mobobjetooper = mOBOBJETOOPERType;
    }

    public String getIDENTIFICADORMOV() {
        return this.identificadormov;
    }

    public void setIDENTIFICADORMOV(String str) {
        this.identificadormov = str;
    }
}
