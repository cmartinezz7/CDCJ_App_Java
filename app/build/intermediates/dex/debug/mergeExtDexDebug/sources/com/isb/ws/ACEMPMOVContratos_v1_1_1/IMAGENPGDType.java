package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMAGEN_PGD_Type", propOrder = {"ordendocumentopgd", "refimagen"})
public class IMAGENPGDType {
    @XmlElement(name = "ORDEN_DOCUMENTO_PGD", required = true)
    protected ORDENDOCUMENTOPGDType ordendocumentopgd;
    @XmlElement(name = "REF_IMAGEN", required = true)
    protected String refimagen;

    public ORDENDOCUMENTOPGDType getORDENDOCUMENTOPGD() {
        return this.ordendocumentopgd;
    }

    public void setORDENDOCUMENTOPGD(ORDENDOCUMENTOPGDType oRDENDOCUMENTOPGDType) {
        this.ordendocumentopgd = oRDENDOCUMENTOPGDType;
    }

    public String getREFIMAGEN() {
        return this.refimagen;
    }

    public void setREFIMAGEN(String str) {
        this.refimagen = str;
    }
}
