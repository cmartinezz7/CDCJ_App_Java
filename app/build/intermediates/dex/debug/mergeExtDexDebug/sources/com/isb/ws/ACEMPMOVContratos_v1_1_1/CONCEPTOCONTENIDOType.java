package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPTO_CONTENIDO_Type", propOrder = {"conceptodgo", "codigocontenido"})
public class CONCEPTOCONTENIDOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_CONTENIDO")
    protected int codigocontenido;
    @XmlElement(name = "CONCEPTO_DGO", required = true)
    protected String conceptodgo;

    public String getCONCEPTODGO() {
        return this.conceptodgo;
    }

    public void setCONCEPTODGO(String str) {
        this.conceptodgo = str;
    }

    public int getCODIGOCONTENIDO() {
        return this.codigocontenido;
    }

    public void setCODIGOCONTENIDO(int i) {
        this.codigocontenido = i;
    }
}
