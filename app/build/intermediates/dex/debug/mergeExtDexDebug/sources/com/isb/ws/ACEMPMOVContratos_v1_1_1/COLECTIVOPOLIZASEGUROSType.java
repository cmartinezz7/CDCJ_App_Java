package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COLECTIVO_POLIZA_SEGUROS_Type", propOrder = {"modalidaddeseguros", "numeropolizaseguro"})
public class COLECTIVOPOLIZASEGUROSType {
    @XmlElement(name = "MODALIDAD_DE_SEGUROS", required = true)
    protected MODALIDADDESEGUROSType modalidaddeseguros;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUMERO_POLIZA_SEGURO")
    protected int numeropolizaseguro;

    public MODALIDADDESEGUROSType getMODALIDADDESEGUROS() {
        return this.modalidaddeseguros;
    }

    public void setMODALIDADDESEGUROS(MODALIDADDESEGUROSType mODALIDADDESEGUROSType) {
        this.modalidaddeseguros = mODALIDADDESEGUROSType;
    }

    public int getNUMEROPOLIZASEGURO() {
        return this.numeropolizaseguro;
    }

    public void setNUMEROPOLIZASEGURO(int i) {
        this.numeropolizaseguro = i;
    }
}
