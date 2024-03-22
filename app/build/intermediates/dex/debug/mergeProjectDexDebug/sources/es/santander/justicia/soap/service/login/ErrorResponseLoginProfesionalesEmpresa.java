package es.santander.justicia.soap.service.login;

import org.ksoap2.SoapFault;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;

public class ErrorResponseLoginProfesionalesEmpresa {
    private String errorCode;
    private String errorDesc;

    public ErrorResponseLoginProfesionalesEmpresa(SoapFault soapFault) {
        parse(soapFault.detail);
    }

    public void parse(Node node) {
        for (int i = 0; i < node.getChildCount(); i++) {
            if (node.getChild(i) instanceof Element) {
                Element detail = (Element) node.getChild(i);
                for (int j = 0; j < detail.getChildCount(); j++) {
                    if (detail.getChild(j) instanceof Element) {
                        Element exception = (Element) detail.getChild(j);
                        for (int k = 0; k < exception.getChildCount(); k++) {
                            if (exception.getChild(k) instanceof Element) {
                                Element error = (Element) exception.getChild(k);
                                for (int l = 0; l < error.getChildCount(); l++) {
                                    if (error.getChild(l) instanceof Element) {
                                        Element message = (Element) error.getChild(l);
                                        String etiqueta = message.getName();
                                        for (int m = 0; m < message.getChildCount(); m++) {
                                            if (etiqueta.equalsIgnoreCase("errorDesc")) {
                                                this.errorDesc = (String) message.getChild(m);
                                            } else if (etiqueta.equalsIgnoreCase("errorCode")) {
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
