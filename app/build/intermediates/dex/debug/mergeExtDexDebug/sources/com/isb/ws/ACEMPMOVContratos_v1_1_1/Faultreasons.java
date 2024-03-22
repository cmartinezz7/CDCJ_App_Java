package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faultreasons", namespace = "http://www.gruposantander.es/webservices/genericFault", propOrder = {"reason"})
public class Faultreasons {
    protected List<Faultreason> reason;

    public List<Faultreason> getReason() {
        if (this.reason == null) {
            this.reason = new ArrayList();
        }
        return this.reason;
    }
}
