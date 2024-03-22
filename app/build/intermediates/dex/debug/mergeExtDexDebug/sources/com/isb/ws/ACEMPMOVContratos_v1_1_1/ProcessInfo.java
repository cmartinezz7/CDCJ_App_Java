package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessInfo", namespace = "http://www.gruposantander.es/webservices/genericFault", propOrder = {"processIncomingMessage", "processID", "processName"})
public class ProcessInfo {
    @XmlElement(required = true)
    protected String processID;
    @XmlElement(required = true)
    protected String processIncomingMessage;
    @XmlElement(required = true)
    protected String processName;

    public String getProcessIncomingMessage() {
        return this.processIncomingMessage;
    }

    public void setProcessIncomingMessage(String str) {
        this.processIncomingMessage = str;
    }

    public String getProcessID() {
        return this.processID;
    }

    public void setProcessID(String str) {
        this.processID = str;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String str) {
        this.processName = str;
    }
}
