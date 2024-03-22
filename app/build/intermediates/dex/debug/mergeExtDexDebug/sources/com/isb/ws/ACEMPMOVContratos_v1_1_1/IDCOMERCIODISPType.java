package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_COMERCIO_DISP_Type", propOrder = {"tipofranquiciadisp", "codcomercio"})
public class IDCOMERCIODISPType {
    @XmlElement(name = "COD_COMERCIO", required = true)
    protected String codcomercio;
    @XmlElement(name = "TIPO_FRANQUICIA_DISP", required = true)
    protected TIPOFRANQUICIADISPType tipofranquiciadisp;

    public TIPOFRANQUICIADISPType getTIPOFRANQUICIADISP() {
        return this.tipofranquiciadisp;
    }

    public void setTIPOFRANQUICIADISP(TIPOFRANQUICIADISPType tIPOFRANQUICIADISPType) {
        this.tipofranquiciadisp = tIPOFRANQUICIADISPType;
    }

    public String getCODCOMERCIO() {
        return this.codcomercio;
    }

    public void setCODCOMERCIO(String str) {
        this.codcomercio = str;
    }
}
