package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POST_CODE_Type", propOrder = {"codigodearea", "codigodedistrito", "codigodesector", "codigodegrupo"})
public class POSTCODEType {
    @XmlElement(name = "CODIGO_DE_AREA", required = true)
    protected String codigodearea;
    @XmlElement(name = "CODIGO_DE_DISTRITO", required = true)
    protected String codigodedistrito;
    @XmlElement(name = "CODIGO_DE_GRUPO", required = true)
    protected String codigodegrupo;
    @XmlElement(name = "CODIGO_DE_SECTOR", required = true)
    protected String codigodesector;

    public String getCODIGODEAREA() {
        return this.codigodearea;
    }

    public void setCODIGODEAREA(String str) {
        this.codigodearea = str;
    }

    public String getCODIGODEDISTRITO() {
        return this.codigodedistrito;
    }

    public void setCODIGODEDISTRITO(String str) {
        this.codigodedistrito = str;
    }

    public String getCODIGODESECTOR() {
        return this.codigodesector;
    }

    public void setCODIGODESECTOR(String str) {
        this.codigodesector = str;
    }

    public String getCODIGODEGRUPO() {
        return this.codigodegrupo;
    }

    public void setCODIGODEGRUPO(String str) {
        this.codigodegrupo = str;
    }
}
