package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMPT_INDICA_BR_Type", propOrder = {"pevinsan", "pecodemp", "peindrel", "peindcon", "peindgru", "peindavi", "peindno1", "peindno2", "peindno3", "peindno4", "peindno5", "peactriu", "pesubseg", "pesubseg2", "peidioma"})
public class COMPTINDICABRType {
    @XmlElement(name = "PEACTRIU", required = true)
    protected String peactriu;
    @XmlElement(name = "PECODEMP", required = true)
    protected String pecodemp;
    @XmlElement(name = "PEIDIOMA", required = true)
    protected String peidioma;
    @XmlElement(name = "PEINDAVI", required = true)
    protected String peindavi;
    @XmlElement(name = "PEINDCON", required = true)
    protected String peindcon;
    @XmlElement(name = "PEINDGRU", required = true)
    protected String peindgru;
    @XmlElement(name = "PEINDNO1", required = true)
    protected String peindno1;
    @XmlElement(name = "PEINDNO2", required = true)
    protected String peindno2;
    @XmlElement(name = "PEINDNO3", required = true)
    protected String peindno3;
    @XmlElement(name = "PEINDNO4", required = true)
    protected String peindno4;
    @XmlElement(name = "PEINDNO5", required = true)
    protected String peindno5;
    @XmlElement(name = "PEINDREL", required = true)
    protected String peindrel;
    @XmlElement(name = "PESUBSEG", required = true)
    protected String pesubseg;
    @XmlElement(name = "PESUBSEG2", required = true)
    protected String pesubseg2;
    @XmlElement(name = "PEVINSAN", required = true)
    protected String pevinsan;

    public String getPEVINSAN() {
        return this.pevinsan;
    }

    public void setPEVINSAN(String str) {
        this.pevinsan = str;
    }

    public String getPECODEMP() {
        return this.pecodemp;
    }

    public void setPECODEMP(String str) {
        this.pecodemp = str;
    }

    public String getPEINDREL() {
        return this.peindrel;
    }

    public void setPEINDREL(String str) {
        this.peindrel = str;
    }

    public String getPEINDCON() {
        return this.peindcon;
    }

    public void setPEINDCON(String str) {
        this.peindcon = str;
    }

    public String getPEINDGRU() {
        return this.peindgru;
    }

    public void setPEINDGRU(String str) {
        this.peindgru = str;
    }

    public String getPEINDAVI() {
        return this.peindavi;
    }

    public void setPEINDAVI(String str) {
        this.peindavi = str;
    }

    public String getPEINDNO1() {
        return this.peindno1;
    }

    public void setPEINDNO1(String str) {
        this.peindno1 = str;
    }

    public String getPEINDNO2() {
        return this.peindno2;
    }

    public void setPEINDNO2(String str) {
        this.peindno2 = str;
    }

    public String getPEINDNO3() {
        return this.peindno3;
    }

    public void setPEINDNO3(String str) {
        this.peindno3 = str;
    }

    public String getPEINDNO4() {
        return this.peindno4;
    }

    public void setPEINDNO4(String str) {
        this.peindno4 = str;
    }

    public String getPEINDNO5() {
        return this.peindno5;
    }

    public void setPEINDNO5(String str) {
        this.peindno5 = str;
    }

    public String getPEACTRIU() {
        return this.peactriu;
    }

    public void setPEACTRIU(String str) {
        this.peactriu = str;
    }

    public String getPESUBSEG() {
        return this.pesubseg;
    }

    public void setPESUBSEG(String str) {
        this.pesubseg = str;
    }

    public String getPESUBSEG2() {
        return this.pesubseg2;
    }

    public void setPESUBSEG2(String str) {
        this.pesubseg2 = str;
    }

    public String getPEIDIOMA() {
        return this.peidioma;
    }

    public void setPEIDIOMA(String str) {
        this.peidioma = str;
    }
}
