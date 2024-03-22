package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_NEGOCIO_LOCAL_1_Type", propOrder = {"empresa", "idlineanegociolocal1"})
public class LINEANEGOCIOLOCAL1Type {
    @XmlElement(name = "EMPRESA", required = true)
    protected String empresa;
    @XmlElement(name = "ID_LINEA_NEGOCIO_LOCAL_1", required = true)
    protected String idlineanegociolocal1;

    public String getEMPRESA() {
        return this.empresa;
    }

    public void setEMPRESA(String str) {
        this.empresa = str;
    }

    public String getIDLINEANEGOCIOLOCAL1() {
        return this.idlineanegociolocal1;
    }

    public void setIDLINEANEGOCIOLOCAL1(String str) {
        this.idlineanegociolocal1 = str;
    }
}
