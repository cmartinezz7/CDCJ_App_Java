package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOT_FEECOLL_FRANQ_DISP_Type", propOrder = {"tipofranquiciadisp", "codmotivo"})
public class MOTFEECOLLFRANQDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_MOTIVO")
    protected int codmotivo;
    @XmlElement(name = "TIPO_FRANQUICIA_DISP", required = true)
    protected TIPOFRANQUICIADISPType tipofranquiciadisp;

    public TIPOFRANQUICIADISPType getTIPOFRANQUICIADISP() {
        return this.tipofranquiciadisp;
    }

    public void setTIPOFRANQUICIADISP(TIPOFRANQUICIADISPType tIPOFRANQUICIADISPType) {
        this.tipofranquiciadisp = tIPOFRANQUICIADISPType;
    }

    public int getCODMOTIVO() {
        return this.codmotivo;
    }

    public void setCODMOTIVO(int i) {
        this.codmotivo = i;
    }
}
