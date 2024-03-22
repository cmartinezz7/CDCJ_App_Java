package com.isb.ws.WSSupernetMobile_1;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "WSSupernetMobileImplService", targetNamespace = "http://impl.supernetmobile.cdcj.imcs.es/", wsdlLocation = "META-INF/wsdl/WSSupernetMobile_1.wsdl")
public class WSSupernetMobileImplService extends Service {
    private static final WebServiceException WSSUPERNETMOBILEIMPLSERVICE_EXCEPTION;
    private static final QName WSSUPERNETMOBILEIMPLSERVICE_QNAME = new QName("http://impl.supernetmobile.cdcj.imcs.es/", "WSSupernetMobileImplService");
    private static final URL WSSUPERNETMOBILEIMPLSERVICE_WSDL_LOCATION;

    static {
        WebServiceException webServiceException;
        URL resource = WSSupernetMobileImplService.class.getClassLoader().getResource("META-INF/wsdl/WSSupernetMobile_1.wsdl");
        WSSUPERNETMOBILEIMPLSERVICE_WSDL_LOCATION = resource;
        if (resource == null) {
            webServiceException = new WebServiceException("Cannot find 'META-INF/wsdl/WSSupernetMobile_1.wsdl' wsdl. Place the resource correctly in the classpath.");
        } else {
            webServiceException = null;
        }
        WSSUPERNETMOBILEIMPLSERVICE_EXCEPTION = webServiceException;
    }

    public WSSupernetMobileImplService() {
        super(__getWsdlLocation(), WSSUPERNETMOBILEIMPLSERVICE_QNAME);
    }

    public WSSupernetMobileImplService(URL url, QName qName) {
        super(url, qName);
    }

    @WebEndpoint(name = "WSSupernetMobileImplPort")
    public WSSupernetMobile getWSSupernetMobileImplPort() {
        return (WSSupernetMobile) WSSupernetMobileImplService.super.getPort(new QName("http://impl.supernetmobile.cdcj.imcs.es/", "WSSupernetMobileImplPort"), WSSupernetMobile.class);
    }

    @WebEndpoint(name = "WSSupernetMobileImplPort")
    public WSSupernetMobile getWSSupernetMobileImplPort(WebServiceFeature... webServiceFeatureArr) {
        return (WSSupernetMobile) WSSupernetMobileImplService.super.getPort(new QName("http://impl.supernetmobile.cdcj.imcs.es/", "WSSupernetMobileImplPort"), WSSupernetMobile.class, webServiceFeatureArr);
    }

    private static URL __getWsdlLocation() {
        WebServiceException webServiceException = WSSUPERNETMOBILEIMPLSERVICE_EXCEPTION;
        if (webServiceException == null) {
            return WSSUPERNETMOBILEIMPLSERVICE_WSDL_LOCATION;
        }
        throw webServiceException;
    }
}
