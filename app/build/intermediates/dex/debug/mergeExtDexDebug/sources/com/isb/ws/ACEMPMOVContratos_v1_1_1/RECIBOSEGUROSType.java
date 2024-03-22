package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RECIBO_SEGUROS_Type", propOrder = {"modalidaddeseguros", "numreciboseguros", "numintegranterecibo"})
public class RECIBOSEGUROSType {
    @XmlElement(name = "MODALIDAD_DE_SEGUROS", required = true)
    protected MODALIDADDESEGUROSType modalidaddeseguros;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_INTEGRANTE_RECIBO")
    protected int numintegranterecibo;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NUM_RECIBO_SEGUROS")
    protected int numreciboseguros;

    public MODALIDADDESEGUROSType getMODALIDADDESEGUROS() {
        return this.modalidaddeseguros;
    }

    public void setMODALIDADDESEGUROS(MODALIDADDESEGUROSType mODALIDADDESEGUROSType) {
        this.modalidaddeseguros = mODALIDADDESEGUROSType;
    }

    public int getNUMRECIBOSEGUROS() {
        return this.numreciboseguros;
    }

    public void setNUMRECIBOSEGUROS(int i) {
        this.numreciboseguros = i;
    }

    public int getNUMINTEGRANTERECIBO() {
        return this.numintegranterecibo;
    }

    public void setNUMINTEGRANTERECIBO(int i) {
        this.numintegranterecibo = i;
    }
}
