package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_FRAUDE_FRANQ_DISP_Type", propOrder = {"tipofranquiciadisp", "codfraude"})
public class TIPOFRAUDEFRANQDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_FRAUDE")
    protected int codfraude;
    @XmlElement(name = "TIPO_FRANQUICIA_DISP", required = true)
    protected TIPOFRANQUICIADISPType tipofranquiciadisp;

    public TIPOFRANQUICIADISPType getTIPOFRANQUICIADISP() {
        return this.tipofranquiciadisp;
    }

    public void setTIPOFRANQUICIADISP(TIPOFRANQUICIADISPType tIPOFRANQUICIADISPType) {
        this.tipofranquiciadisp = tIPOFRANQUICIADISPType;
    }

    public int getCODFRAUDE() {
        return this.codfraude;
    }

    public void setCODFRAUDE(int i) {
        this.codfraude = i;
    }
}
