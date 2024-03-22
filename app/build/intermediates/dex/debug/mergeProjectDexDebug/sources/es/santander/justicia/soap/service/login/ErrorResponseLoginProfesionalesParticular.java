package es.santander.justicia.soap.service.login;

import org.ksoap2.SoapFault;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;

public class ErrorResponseLoginProfesionalesParticular {
    private String errorCode;
    private String errorDesc;

    public ErrorResponseLoginProfesionalesParticular(SoapFault soapFault) {
        parse(soapFault.detail);
    }

    public void parse(Node node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            if (node.getChild(i) instanceof Element) {
                Element detail = (Element) node.getChild(i);
                for (int k = 0; k < detail.getChildCount(); k++) {
                    if (detail.getChild(k) instanceof Element) {
                        Element error = (Element) detail.getChild(k);
                        for (int l = 0; l < error.getChildCount(); l++) {
                            if (error.getChild(l) instanceof Element) {
                                Element message = (Element) error.getChild(l);
                                String etiqueta = message.getName();
                                for (int m = 0; m < message.getChildCount(); m++) {
                                    if (etiqueta.equalsIgnoreCase("messageByDefault")) {
                                        this.errorDesc = (String) message.getChild(m);
                                    } else if (etiqueta.equalsIgnoreCase("codigoError")) {
                                        this.errorCode = (String) message.getChild(m);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode2) {
        this.errorCode = errorCode2;
    }

    public String getErrorDesc() {
        return this.errorDesc;
    }

    public void setErrorDesc(String errorDesc2) {
        this.errorDesc = errorDesc2;
    }
}
