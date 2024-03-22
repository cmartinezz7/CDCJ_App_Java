package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SUBFUNCION_FRANQUICIA_TJT_Type", propOrder = {"codfuncionfranquiciatjt", "codsubfuncionfrqtjt"})
public class SUBFUNCIONFRANQUICIATJTType {
    @XmlElement(name = "CODFUNCION_FRANQUICIA_TJT", required = true)
    protected CODFUNCIONFRANQUICIATJTType codfuncionfranquiciatjt;
    @XmlElement(name = "CODSUBFUNCION_FRQ_TJT", required = true)
    protected String codsubfuncionfrqtjt;

    public CODFUNCIONFRANQUICIATJTType getCODFUNCIONFRANQUICIATJT() {
        return this.codfuncionfranquiciatjt;
    }

    public void setCODFUNCIONFRANQUICIATJT(CODFUNCIONFRANQUICIATJTType cODFUNCIONFRANQUICIATJTType) {
        this.codfuncionfranquiciatjt = cODFUNCIONFRANQUICIATJTType;
    }

    public String getCODSUBFUNCIONFRQTJT() {
        return this.codsubfuncionfrqtjt;
    }

    public void setCODSUBFUNCIONFRQTJT(String str) {
        this.codsubfuncionfrqtjt = str;
    }
}
