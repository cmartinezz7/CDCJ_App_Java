package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACUERDO_COMERCIAL_INTMED_Type", propOrder = {"idintermediariointmed", "idfabricaintmed", "iddistribuidorintmed", "idproductointmed", "idcanalintmed"})
public class ACUERDOCOMERCIALINTMEDType {
    @XmlElement(name = "ID_CANAL_INTMED", required = true)
    protected String idcanalintmed;
    @XmlElement(name = "ID_DISTRIBUIDOR_INTMED", required = true)
    protected String iddistribuidorintmed;
    @XmlElement(name = "ID_FABRICA_INTMED", required = true)
    protected String idfabricaintmed;
    @XmlElement(name = "ID_INTERMEDIARIO_INTMED", required = true)
    protected String idintermediariointmed;
    @XmlElement(name = "ID_PRODUCTO_INTMED", required = true)
    protected String idproductointmed;

    public String getIDINTERMEDIARIOINTMED() {
        return this.idintermediariointmed;
    }

    public void setIDINTERMEDIARIOINTMED(String str) {
        this.idintermediariointmed = str;
    }

    public String getIDFABRICAINTMED() {
        return this.idfabricaintmed;
    }

    public void setIDFABRICAINTMED(String str) {
        this.idfabricaintmed = str;
    }

    public String getIDDISTRIBUIDORINTMED() {
        return this.iddistribuidorintmed;
    }

    public void setIDDISTRIBUIDORINTMED(String str) {
        this.iddistribuidorintmed = str;
    }

    public String getIDPRODUCTOINTMED() {
        return this.idproductointmed;
    }

    public void setIDPRODUCTOINTMED(String str) {
        this.idproductointmed = str;
    }

    public String getIDCANALINTMED() {
        return this.idcanalintmed;
    }

    public void setIDCANALINTMED(String str) {
        this.idcanalintmed = str;
    }
}
