package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINEA_NEGOCIO_Type", propOrder = {"metodocomercial", "codlineanegocio"})
public class LINEANEGOCIOType {
    @XmlElement(name = "COD_LINEA_NEGOCIO", required = true)
    protected String codlineanegocio;
    @XmlElement(name = "METODO_COMERCIAL", required = true)
    protected METODOCOMERCIALType metodocomercial;

    public METODOCOMERCIALType getMETODOCOMERCIAL() {
        return this.metodocomercial;
    }

    public void setMETODOCOMERCIAL(METODOCOMERCIALType mETODOCOMERCIALType) {
        this.metodocomercial = mETODOCOMERCIALType;
    }

    public String getCODLINEANEGOCIO() {
        return this.codlineanegocio;
    }

    public void setCODLINEANEGOCIO(String str) {
        this.codlineanegocio = str;
    }
}
