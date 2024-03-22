package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_NEGOCIO_LOCAL_2_Type", propOrder = {"lineanegociolocal1", "idlineanegociolocal2"})
public class LINEANEGOCIOLOCAL2Type {
    @XmlElement(name = "ID_LINEA_NEGOCIO_LOCAL_2", required = true)
    protected String idlineanegociolocal2;
    @XmlElement(name = "LINEA_NEGOCIO_LOCAL_1", required = true)
    protected LINEANEGOCIOLOCAL1Type lineanegociolocal1;

    public LINEANEGOCIOLOCAL1Type getLINEANEGOCIOLOCAL1() {
        return this.lineanegociolocal1;
    }

    public void setLINEANEGOCIOLOCAL1(LINEANEGOCIOLOCAL1Type lINEANEGOCIOLOCAL1Type) {
        this.lineanegociolocal1 = lINEANEGOCIOLOCAL1Type;
    }

    public String getIDLINEANEGOCIOLOCAL2() {
        return this.idlineanegociolocal2;
    }

    public void setIDLINEANEGOCIOLOCAL2(String str) {
        this.idlineanegociolocal2 = str;
    }
}
