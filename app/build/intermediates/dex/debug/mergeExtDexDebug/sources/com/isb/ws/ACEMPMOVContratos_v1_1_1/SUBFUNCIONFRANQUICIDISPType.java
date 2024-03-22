package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBFUNCION_FRANQUICI_DISP_Type", propOrder = {"tipofranquiciadisp", "codsolucionincidendisp", "codsubfuncion"})
public class SUBFUNCIONFRANQUICIDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_SOLUCION_INCIDEN_DISP")
    protected int codsolucionincidendisp;
    @XmlElement(name = "COD_SUBFUNCION", required = true)
    protected String codsubfuncion;
    @XmlElement(name = "TIPO_FRANQUICIA_DISP", required = true)
    protected TIPOFRANQUICIADISPType tipofranquiciadisp;

    public TIPOFRANQUICIADISPType getTIPOFRANQUICIADISP() {
        return this.tipofranquiciadisp;
    }

    public void setTIPOFRANQUICIADISP(TIPOFRANQUICIADISPType tIPOFRANQUICIADISPType) {
        this.tipofranquiciadisp = tIPOFRANQUICIADISPType;
    }

    public int getCODSOLUCIONINCIDENDISP() {
        return this.codsolucionincidendisp;
    }

    public void setCODSOLUCIONINCIDENDISP(int i) {
        this.codsolucionincidendisp = i;
    }

    public String getCODSUBFUNCION() {
        return this.codsubfuncion;
    }

    public void setCODSUBFUNCION(String str) {
        this.codsubfuncion = str;
    }
}
