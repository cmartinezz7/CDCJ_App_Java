package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SINIESTRO_SEGUROS_Type", propOrder = {"modalidaddeseguros", "numsiniestroseguros"})
public class SINIESTROSEGUROSType {
    @XmlElement(name = "MODALIDAD_DE_SEGUROS", required = true)
    protected MODALIDADDESEGUROSType modalidaddeseguros;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_SINIESTRO_SEGUROS")
    protected int numsiniestroseguros;

    public MODALIDADDESEGUROSType getMODALIDADDESEGUROS() {
        return this.modalidaddeseguros;
    }

    public void setMODALIDADDESEGUROS(MODALIDADDESEGUROSType mODALIDADDESEGUROSType) {
        this.modalidaddeseguros = mODALIDADDESEGUROSType;
    }

    public int getNUMSINIESTROSEGUROS() {
        return this.numsiniestroseguros;
    }

    public void setNUMSINIESTROSEGUROS(int i) {
        this.numsiniestroseguros = i;
    }
}
