package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ROL_ACCION_GESTOR_PIPECO_Type", propOrder = {"acciongestor", "rol"})
public class ROLACCIONGESTORPIPECOType {
    @XmlElement(name = "ACCION_GESTOR", required = true)
    protected ACCIONGESTORPIPECOType acciongestor;
    @XmlElement(name = "ROL", required = true)
    protected String rol;

    public ACCIONGESTORPIPECOType getACCIONGESTOR() {
        return this.acciongestor;
    }

    public void setACCIONGESTOR(ACCIONGESTORPIPECOType aCCIONGESTORPIPECOType) {
        this.acciongestor = aCCIONGESTORPIPECOType;
    }

    public String getROL() {
        return this.rol;
    }

    public void setROL(String str) {
        this.rol = str;
    }
}
