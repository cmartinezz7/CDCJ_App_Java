package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "ACEMPMOVContratos_Service", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1", wsdlLocation = "META-INF/wsdl/ACEMPMOVContratos_v1_1_1.wsdl")
public class ACEMPMOVContratosService extends Service {
    private static final WebServiceException ACEMPMOVCONTRATOSSERVICE_EXCEPTION;
    private static final QName ACEMPMOVCONTRATOSSERVICE_QNAME = new QName("http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1", "ACEMPMOVContratos_Service");
    private static final URL ACEMPMOVCONTRATOSSERVICE_WSDL_LOCATION;

    static {
        WebServiceException webServiceException;
        URL resource = ACEMPMOVContratosService.class.getClassLoader().getResource("META-INF/wsdl/ACEMPMOVContratos_v1_1_1.wsdl");
        ACEMPMOVCONTRATOSSERVICE_WSDL_LOCATION = resource;
        if (resource == null) {
            webServiceException = new WebServiceException("Cannot find 'META-INF/wsdl/ACEMPMOVContratos_v1_1_1.wsdl' wsdl. Place the resource correctly in the classpath.");
        } else {
            webServiceException = null;
        }
        ACEMPMOVCONTRATOSSERVICE_EXCEPTION = webServiceException;
    }

    public ACEMPMOVContratosService() {
        super(__getWsdlLocation(), ACEMPMOVCONTRATOSSERVICE_QNAME);
    }

    public ACEMPMOVContratosService(URL url, QName qName) {
        super(url, qName);
    }

    @WebEndpoint(name = "ACEMPMOVContratosPortHTTP")
    public ACEMPMOVContratosPortTypeHTTP getACEMPMOVContratosPortHTTP() {
        return (ACEMPMOVContratosPortTypeHTTP) ACEMPMOVContratosService.super.getPort(new QName("http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1", "ACEMPMOVContratosPortHTTP"), ACEMPMOVContratosPortTypeHTTP.class);
    }

    @WebEndpoint(name = "ACEMPMOVContratosPortHTTP")
    public ACEMPMOVContratosPortTypeHTTP getACEMPMOVContratosPortHTTP(WebServiceFeature... webServiceFeatureArr) {
        return (ACEMPMOVContratosPortTypeHTTP) ACEMPMOVContratosService.super.getPort(new QName("http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1", "ACEMPMOVContratosPortHTTP"), ACEMPMOVContratosPortTypeHTTP.class, webServiceFeatureArr);
    }

    private static URL __getWsdlLocation() {
        WebServiceException webServiceException = ACEMPMOVCONTRATOSSERVICE_EXCEPTION;
        if (webServiceException == null) {
            return ACEMPMOVCONTRATOSSERVICE_WSDL_LOCATION;
        }
        throw webServiceException;
    }
}
