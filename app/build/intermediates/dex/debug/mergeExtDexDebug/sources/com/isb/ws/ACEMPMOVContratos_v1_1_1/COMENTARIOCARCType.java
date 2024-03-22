package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMENTARIO_CARC_Type", propOrder = {"casocarc", "idcomentario"})
public class COMENTARIOCARCType {
    @XmlElement(name = "CASO_CARC", required = true)
    protected CASOCARCType casocarc;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_COMENTARIO")
    protected int idcomentario;

    public CASOCARCType getCASOCARC() {
        return this.casocarc;
    }

    public void setCASOCARC(CASOCARCType cASOCARCType) {
        this.casocarc = cASOCARCType;
    }

    public int getIDCOMENTARIO() {
        return this.idcomentario;
    }

    public void setIDCOMENTARIO(int i) {
        this.idcomentario = i;
    }
}
