package es.santander.justicia.minisJusticia.expedientes.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.EntradaXmlBuscarExpediente;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosAcessoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ResponseBuscarExpediente;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.NetworkUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParserException;

public class ExpedientesSoapService {
    public ArrayList<ExpedienteDTO> getExpedientes() {
        String tokenServ = LoginManager.getInstance().getToken();
        String nameSpace = Constants.ConstantesBuscarExpediente_LS.NAMESPACE.valor();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsAccessRequestLS", MainApplication.getAppContext().getEnvironment());
        DatosAcessoProfesionales datosAcessoProfesionales = new DatosAcessoProfesionales("");
        EntradaXmlBuscarExpediente entradaXmlBuscarExpediente = new EntradaXmlBuscarExpediente(datosAcessoProfesionales, "", new DatosPaginacion("1", "1000"));
        SoapObject request = new SoapObject("", Constants.ConstantesBuscarExpediente_LS.NOMBRE_SERVICIO.valor());
        request.addAttribute("xmlns:sup", nameSpace);
        PropertyInfo arg = new PropertyInfo();
        arg.setName("arg0");
        arg.setValue(entradaXmlBuscarExpediente);
        arg.setType(entradaXmlBuscarExpediente.getClass());
        request.addProperty(arg);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        Element[] header = {new Element().createElement("", "wsse:Security")};
        header[0].setAttribute("", "xmlns:wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
        Element pass = new Element().createElement("", "BinarySecurityToken");
        pass.addChild(4, tokenServ);
        header[0].addChild(2, pass);
        envelope.headerOut = header;
        envelope.setOutputSoapObject(request);
        new MarshalFloat().register(envelope);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        String str = tokenServ;
        String soapAction = nameSpace + Constants.ConstantesBuscarExpediente_LS.NOMBRE_SERVICIO.valor();
        try {
            String str2 = nameSpace;
            try {
                DatosAcessoProfesionales datosAcessoProfesionales2 = datosAcessoProfesionales;
            } catch (SoapFault e) {
                String str3 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO = wsSettings;
                DatosAcessoProfesionales datosAcessoProfesionales3 = datosAcessoProfesionales;
                return null;
            } catch (XmlPullParserException e2) {
                e = e2;
                String str4 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO2 = wsSettings;
                DatosAcessoProfesionales datosAcessoProfesionales4 = datosAcessoProfesionales;
                Log.e("ExpedientesSoapService", "XmlPullParserException", e);
                return null;
            } catch (HttpResponseException e3) {
                e = e3;
                String str5 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO3 = wsSettings;
                DatosAcessoProfesionales datosAcessoProfesionales5 = datosAcessoProfesionales;
                Log.e("ExpedientesSoapService", "HttpResponseException", e);
                return null;
            } catch (IOException e4) {
                e = e4;
                String str6 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO4 = wsSettings;
                DatosAcessoProfesionales datosAcessoProfesionales6 = datosAcessoProfesionales;
                Log.e("ExpedientesSoapService", "IOException", e);
                return null;
            }
            try {
                NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), soapAction, envelope, wsSettings.getConnectionTimeout());
                SoapObject response = (SoapObject) envelope.getResponse();
                ResponseBuscarExpediente responseBuscarExpediente = new ResponseBuscarExpediente(response);
                List<SoapObject> expedientes = responseBuscarExpediente.getListaDatosExpediente();
                ArrayList<ExpedienteDTO> misExpedientes = new ArrayList<>();
                for (SoapObject so : expedientes) {
                    ResponseBuscarExpediente responseBuscarExpediente2 = responseBuscarExpediente;
                    String soapAction2 = soapAction;
                    try {
                        SoapObject query = (SoapObject) so.getProperty("saldos");
                        SoapObject response2 = response;
                        String saldo = query.getProperty("impsaldo").toString();
                        SoapObject soapObject = query;
                        WebServiceSettingsDTO wsSettings2 = wsSettings;
                        ExpedienteDTO miEsp = new ExpedienteDTO();
                        try {
                            miEsp.setCodExpediente(so.getProperty("codExpediente").toString());
                            miEsp.setJanoapex(so.getProperty(Constants.EXPEDIENT_JANOAPEX).toString());
                            miEsp.setJnumexp(so.getProperty(Constants.EXPEDIENT_JNUMEXP).toString());
                            miEsp.setJproced(so.getProperty(Constants.EXPEDIENT_JPROCED).toString());
                            miEsp.setJuzga(so.getProperty(Constants.EXPEDIENT_JUZGA).toString());
                            miEsp.setJuzgori(so.getProperty(Constants.EXPEDIENT_JUZGORI).toString());
                            miEsp.setCodmon(so.getProperty("codmon").toString());
                            miEsp.setMoneda(so.getProperty("moneda").toString());
                            miEsp.setSaldo(saldo);
                            miEsp.setPrimov(so.getProperty("primov").toString());
                            miEsp.setSituacion(so.getProperty("situacion").toString());
                            miEsp.setUltmov(so.getProperty("ultmov").toString());
                            if (!"".equals(so.getProperty("impInterCostas").toString())) {
                                String str7 = saldo;
                                if (!" ".equals(so.getProperty("impInterCostas").toString())) {
                                    miEsp.setIntCostas(so.getProperty("impInterCostas").toString());
                                    ArrayList<ExpedienteDTO> misExpedientes2 = misExpedientes;
                                    misExpedientes2.add(miEsp);
                                    misExpedientes = misExpedientes2;
                                    responseBuscarExpediente = responseBuscarExpediente2;
                                    response = response2;
                                    soapAction = soapAction2;
                                    wsSettings = wsSettings2;
                                }
                            }
                            miEsp.setIntCostas("0");
                            ArrayList<ExpedienteDTO> misExpedientes22 = misExpedientes;
                            misExpedientes22.add(miEsp);
                            misExpedientes = misExpedientes22;
                            responseBuscarExpediente = responseBuscarExpediente2;
                            response = response2;
                            soapAction = soapAction2;
                            wsSettings = wsSettings2;
                        } catch (SoapFault e5) {
                            return null;
                        } catch (XmlPullParserException e6) {
                            e = e6;
                            Log.e("ExpedientesSoapService", "XmlPullParserException", e);
                            return null;
                        } catch (HttpResponseException e7) {
                            e = e7;
                            Log.e("ExpedientesSoapService", "HttpResponseException", e);
                            return null;
                        } catch (IOException e8) {
                            e = e8;
                            Log.e("ExpedientesSoapService", "IOException", e);
                            return null;
                        }
                    } catch (SoapFault e9) {
                        WebServiceSettingsDTO webServiceSettingsDTO5 = wsSettings;
                        return null;
                    } catch (XmlPullParserException e10) {
                        e = e10;
                        WebServiceSettingsDTO webServiceSettingsDTO6 = wsSettings;
                        Log.e("ExpedientesSoapService", "XmlPullParserException", e);
                        return null;
                    } catch (HttpResponseException e11) {
                        e = e11;
                        WebServiceSettingsDTO webServiceSettingsDTO7 = wsSettings;
                        Log.e("ExpedientesSoapService", "HttpResponseException", e);
                        return null;
                    } catch (IOException e12) {
                        e = e12;
                        WebServiceSettingsDTO webServiceSettingsDTO8 = wsSettings;
                        Log.e("ExpedientesSoapService", "IOException", e);
                        return null;
                    }
                }
                ResponseBuscarExpediente responseBuscarExpediente3 = responseBuscarExpediente;
                return misExpedientes;
            } catch (SoapFault e13) {
                String str8 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO9 = wsSettings;
                return null;
            } catch (XmlPullParserException e14) {
                e = e14;
                String str9 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO10 = wsSettings;
                Log.e("ExpedientesSoapService", "XmlPullParserException", e);
                return null;
            } catch (HttpResponseException e15) {
                e = e15;
                String str10 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO11 = wsSettings;
                Log.e("ExpedientesSoapService", "HttpResponseException", e);
                return null;
            } catch (IOException e16) {
                e = e16;
                String str11 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO12 = wsSettings;
                Log.e("ExpedientesSoapService", "IOException", e);
                return null;
            }
            try {
                LoginManager.getInstance().setToken((String) envelope.headerIn[0].getChild(0));
            } catch (Exception e17) {
                Log.e("ExpedientesSoapService", "Error al refrescar el token", e17);
            } catch (SoapFault e18) {
                String str12 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO13 = wsSettings;
                return null;
            } catch (XmlPullParserException e19) {
                e = e19;
                String str13 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO14 = wsSettings;
                Log.e("ExpedientesSoapService", "XmlPullParserException", e);
                return null;
            } catch (HttpResponseException e20) {
                e = e20;
                String str14 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO15 = wsSettings;
                Log.e("ExpedientesSoapService", "HttpResponseException", e);
                return null;
            } catch (IOException e21) {
                e = e21;
                String str15 = soapAction;
                WebServiceSettingsDTO webServiceSettingsDTO16 = wsSettings;
                Log.e("ExpedientesSoapService", "IOException", e);
                return null;
            }
        } catch (SoapFault e22) {
            String str16 = soapAction;
            String str17 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO17 = wsSettings;
            DatosAcessoProfesionales datosAcessoProfesionales7 = datosAcessoProfesionales;
            return null;
        } catch (XmlPullParserException e23) {
            e = e23;
            String str18 = soapAction;
            String str19 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO18 = wsSettings;
            DatosAcessoProfesionales datosAcessoProfesionales8 = datosAcessoProfesionales;
            Log.e("ExpedientesSoapService", "XmlPullParserException", e);
            return null;
        } catch (HttpResponseException e24) {
            e = e24;
            String str20 = soapAction;
            String str21 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO19 = wsSettings;
            DatosAcessoProfesionales datosAcessoProfesionales9 = datosAcessoProfesionales;
            Log.e("ExpedientesSoapService", "HttpResponseException", e);
            return null;
        } catch (IOException e25) {
            e = e25;
            String str22 = soapAction;
            String str23 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO20 = wsSettings;
            DatosAcessoProfesionales datosAcessoProfesionales10 = datosAcessoProfesionales;
            Log.e("ExpedientesSoapService", "IOException", e);
            return null;
        }
    }
}
