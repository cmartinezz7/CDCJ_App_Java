package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INTERACCION_CIC_Type", propOrder = {"centrodeinteraccion", "nrodeinteracci0NCIC"})
public class INTERACCIONCICType {
    @XmlElement(name = "CENTRO_DE_INTERACCION", required = true)
    protected CENTROType centrodeinteraccion;
    @XmlElement(name = "NRO_DE_INTERACCI0N_CIC", required = true)
    protected String nrodeinteracci0NCIC;

    public CENTROType getCENTRODEINTERACCION() {
        return this.centrodeinteraccion;
    }

    public void setCENTRODEINTERACCION(CENTROType cENTROType) {
        this.centrodeinteraccion = cENTROType;
    }

    public String getNRODEINTERACCI0NCIC() {
        return this.nrodeinteracci0NCIC;
    }

    public void setNRODEINTERACCI0NCIC(String str) {
        this.nrodeinteracci0NCIC = str;
    }
}
