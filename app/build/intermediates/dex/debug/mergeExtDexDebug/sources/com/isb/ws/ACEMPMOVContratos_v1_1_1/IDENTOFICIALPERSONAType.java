package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDENT_OFICIAL_PERSONA_Type", propOrder = {"tipodocumentoofic", "codigodedocumento"})
public class IDENTOFICIALPERSONAType {
    @XmlElement(name = "CODIGO_DE_DOCUMENTO", required = true)
    protected String codigodedocumento;
    @XmlElement(name = "TIPO_DOCUMENTO_OFIC", required = true)
    protected String tipodocumentoofic;

    public String getTIPODOCUMENTOOFIC() {
        return this.tipodocumentoofic;
    }

    public void setTIPODOCUMENTOOFIC(String str) {
        this.tipodocumentoofic = str;
    }

    public String getCODIGODEDOCUMENTO() {
        return this.codigodedocumento;
    }

    public void setCODIGODEDOCUMENTO(String str) {
        this.codigodedocumento = str;
    }
}
