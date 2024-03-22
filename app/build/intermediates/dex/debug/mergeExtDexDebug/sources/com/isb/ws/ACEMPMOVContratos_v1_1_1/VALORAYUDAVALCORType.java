package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_AYUDA_VALCOR_Type", propOrder = {"columnaayudavalcor", "idayudavalcor"})
public class VALORAYUDAVALCORType {
    @XmlElement(name = "COLUMNA_AYUDA_VALCOR", required = true)
    protected COLUMNAAYUDAVALCORType columnaayudavalcor;
    @XmlElement(name = "ID_AYUDA_VALCOR", required = true)
    protected String idayudavalcor;

    public COLUMNAAYUDAVALCORType getCOLUMNAAYUDAVALCOR() {
        return this.columnaayudavalcor;
    }

    public void setCOLUMNAAYUDAVALCOR(COLUMNAAYUDAVALCORType cOLUMNAAYUDAVALCORType) {
        this.columnaayudavalcor = cOLUMNAAYUDAVALCORType;
    }

    public String getIDAYUDAVALCOR() {
        return this.idayudavalcor;
    }

    public void setIDAYUDAVALCOR(String str) {
        this.idayudavalcor = str;
    }
}
