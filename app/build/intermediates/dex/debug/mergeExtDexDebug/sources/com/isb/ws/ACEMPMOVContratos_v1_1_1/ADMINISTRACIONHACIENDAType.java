package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ADMINISTRACION_HACIENDA_Type", propOrder = {"coddelegacionhacienda", "codadminhacienda"})
public class ADMINISTRACIONHACIENDAType {
    @XmlElement(name = "COD_ADMIN_HACIENDA", required = true)
    protected String codadminhacienda;
    @XmlElement(name = "COD_DELEGACION_HACIENDA", required = true)
    protected String coddelegacionhacienda;

    public String getCODDELEGACIONHACIENDA() {
        return this.coddelegacionhacienda;
    }

    public void setCODDELEGACIONHACIENDA(String str) {
        this.coddelegacionhacienda = str;
    }

    public String getCODADMINHACIENDA() {
        return this.codadminhacienda;
    }

    public void setCODADMINHACIENDA(String str) {
        this.codadminhacienda = str;
    }
}
