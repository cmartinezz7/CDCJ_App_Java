package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ATRIBUT_LDAP_CATALOG_CONT_Type", propOrder = {"categoriaatributoldap", "codalfanum3"})
public class ATRIBUTLDAPCATALOGCONTType {
    @XmlElement(name = "CATEGORIA_ATRIBUTO_LDAP", required = true)
    protected String categoriaatributoldap;
    @XmlElement(name = "COD_ALFANUM_3", required = true)
    protected String codalfanum3;

    public String getCATEGORIAATRIBUTOLDAP() {
        return this.categoriaatributoldap;
    }

    public void setCATEGORIAATRIBUTOLDAP(String str) {
        this.categoriaatributoldap = str;
    }

    public String getCODALFANUM3() {
        return this.codalfanum3;
    }

    public void setCODALFANUM3(String str) {
        this.codalfanum3 = str;
    }
}
