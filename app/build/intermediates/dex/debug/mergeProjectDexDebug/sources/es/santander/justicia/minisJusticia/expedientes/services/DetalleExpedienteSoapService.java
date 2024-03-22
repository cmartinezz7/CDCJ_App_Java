package es.santander.justicia.minisJusticia.expedientes.services;

import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SaldoDTO;
import es.santander.justicia.minisJusticia.dto.WebServiceSettingsDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.minisJusticia.models.WebServiceModel;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.EntradaXmlDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ParamsRequestDetalleExpediente.DatosAccesoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ResponseDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
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

public class DetalleExpedienteSoapService {
    public ExpedienteDTO getDetalleExpediente(ExpedienteDTO expedienteDTO) {
        ExpedienteDTO expedienteDTO2 = expedienteDTO;
        String tokenServ = LoginManager.getInstance().getToken();
        String nameSpace = Constants.ConstantesBuscarDetalleExpediente_LS.NAMESPACE.valor();
        WebServiceSettingsDTO wsSettings = WebServiceModel.getWebServiceSettings("wsAccessRequestLS", MainApplication.getAppContext().getEnvironment());
        DatosExpediente datosExpediente = new DatosExpediente(expedienteDTO.getJuzga(), expedienteDTO.getJuzgori(), expedienteDTO.getJnumexp(), expedienteDTO.getJproced(), expedienteDTO.getJanoapex());
        EntradaXmlDetalleExpediente entradaXmlDetalleExpediente = new EntradaXmlDetalleExpediente(new DatosAccesoProfesionales(datosExpediente));
        SoapObject request = new SoapObject("", Constants.ConstantesBuscarDetalleExpediente_LS.NOMBRE_SERVICIO.valor());
        request.addAttribute("xmlns:sup", nameSpace);
        PropertyInfo arg = new PropertyInfo();
        arg.setName("arg0");
        arg.setValue(entradaXmlDetalleExpediente);
        arg.setType(entradaXmlDetalleExpediente.getClass());
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
        try {
            String str = tokenServ;
            try {
                String str2 = nameSpace;
                try {
                    NetworkUtils.callSoapService(wsSettings.getUrl(), wsSettings.getUrlCertificate(), nameSpace + Constants.ConstantesBuscarDetalleExpediente_LS.NOMBRE_SERVICIO.valor(), envelope, wsSettings.getConnectionTimeout());
                    SoapObject response = (SoapObject) envelope.getResponse();
                    ResponseDetalleExpediente responseDetalleExpediente = new ResponseDetalleExpediente(response);
                    SoapObject expedienteDetail = responseDetalleExpediente.getDatosExpediente();
                    List<SaldoDTO> saldos = new ArrayList<>();
                    ResponseDetalleExpediente responseDetalleExpediente2 = responseDetalleExpediente;
                    int i = 0;
                    while (true) {
                        SoapObject response2 = response;
                        if (i >= expedienteDetail.getPropertyCount()) {
                            break;
                        }
                        PropertyInfo saldoSoapProperty = expedienteDetail.getPropertyInfo(i);
                        SoapObject expedienteDetail2 = expedienteDetail;
                        DatosExpediente datosExpediente2 = datosExpediente;
                        try {
                            if (!"saldos".equals(saldoSoapProperty.getName()) || !(saldoSoapProperty.getValue() instanceof SoapObject)) {
                            } else {
                                SaldoDTO saldoDTO = new SaldoDTO();
                                SoapObject saldoSoapObject = (SoapObject) saldoSoapProperty.getValue();
                                PropertyInfo propertyInfo = saldoSoapProperty;
                                saldoDTO.setCodmon(saldoSoapObject.getProperty("codmon").toString());
                                saldoDTO.setIngpendconso(saldoSoapObject.getProperty("ingpendconso").toString());
                                saldoDTO.setMoneda(saldoSoapObject.getProperty("moneda").toString());
                                saldoDTO.setPagopendconf(saldoSoapObject.getProperty("pagopendconf").toString());
                                saldoDTO.setPagopendconso(saldoSoapObject.getProperty("pagopendconso").toString());
                                saldoDTO.setSaldoconso(saldoSoapObject.getProperty("saldoconso").toString());
                                saldoDTO.setSaldodia(saldoSoapObject.getProperty("saldodia").toString());
                                saldoDTO.setSaldodisp(saldoSoapObject.getProperty("saldodisp").toString());
                                saldoDTO.setSaldoingdeposito(saldoSoapObject.getProperty("saldoingdeposito").toString());
                                saldoDTO.setSaldoingerroneo(saldoSoapObject.getProperty("saldoingerroneo").toString());
                                saldoDTO.setPrincipal(saldoSoapObject.getProperty("principal").toString());
                                saldos.add(saldoDTO);
                            }
                            i++;
                            response = response2;
                            expedienteDetail = expedienteDetail2;
                            datosExpediente = datosExpediente2;
                        } catch (SoapFault e) {
                            Log.i("DetExpSoapService", "soapFault, return null");
                            return null;
                        } catch (XmlPullParserException e2) {
                            e = e2;
                            Log.e("DetExpSoapService", "XmlPullParserException", e);
                            return expedienteDTO2;
                        } catch (HttpResponseException e3) {
                            e = e3;
                            Log.e("DetExpSoapService", "HttpResponseException", e);
                            return expedienteDTO2;
                        } catch (IOException e4) {
                            e = e4;
                            Log.e("DetExpSoapService", "IOException", e);
                            return expedienteDTO2;
                        } catch (Exception e5) {
                            e = e5;
                            Log.e("DetExpSoapService", "Exception", e);
                            return expedienteDTO2;
                        }
                    }
                    DatosExpediente datosExpediente3 = datosExpediente;
                    expedienteDTO2.setSaldos(saldos);
                    expedienteDTO2.setDetail(true);
                } catch (SoapFault e6) {
                    WebServiceSettingsDTO webServiceSettingsDTO = wsSettings;
                    DatosExpediente datosExpediente4 = datosExpediente;
                    Log.i("DetExpSoapService", "soapFault, return null");
                    return null;
                } catch (XmlPullParserException e7) {
                    e = e7;
                    WebServiceSettingsDTO webServiceSettingsDTO2 = wsSettings;
                    DatosExpediente datosExpediente5 = datosExpediente;
                    Log.e("DetExpSoapService", "XmlPullParserException", e);
                    return expedienteDTO2;
                } catch (HttpResponseException e8) {
                    e = e8;
                    WebServiceSettingsDTO webServiceSettingsDTO3 = wsSettings;
                    DatosExpediente datosExpediente6 = datosExpediente;
                    Log.e("DetExpSoapService", "HttpResponseException", e);
                    return expedienteDTO2;
                } catch (IOException e9) {
                    e = e9;
                    WebServiceSettingsDTO webServiceSettingsDTO4 = wsSettings;
                    DatosExpediente datosExpediente7 = datosExpediente;
                    Log.e("DetExpSoapService", "IOException", e);
                    return expedienteDTO2;
                } catch (Exception e10) {
                    e = e10;
                    WebServiceSettingsDTO webServiceSettingsDTO5 = wsSettings;
                    DatosExpediente datosExpediente8 = datosExpediente;
                    Log.e("DetExpSoapService", "Exception", e);
                    return expedienteDTO2;
                }
                try {
                    LoginManager.getInstance().setToken((String) envelope.headerIn[0].getChild(0));
                    WebServiceSettingsDTO webServiceSettingsDTO6 = wsSettings;
                } catch (Exception e11) {
                    WebServiceSettingsDTO webServiceSettingsDTO7 = wsSettings;
                    try {
                        Log.e("DetalleExpSoapService", "Error al refrescar el token", e11);
                    } catch (SoapFault e12) {
                        DatosExpediente datosExpediente9 = datosExpediente;
                        Log.i("DetExpSoapService", "soapFault, return null");
                        return null;
                    } catch (XmlPullParserException e13) {
                        e = e13;
                        DatosExpediente datosExpediente10 = datosExpediente;
                        Log.e("DetExpSoapService", "XmlPullParserException", e);
                        return expedienteDTO2;
                    } catch (HttpResponseException e14) {
                        e = e14;
                        DatosExpediente datosExpediente11 = datosExpediente;
                        Log.e("DetExpSoapService", "HttpResponseException", e);
                        return expedienteDTO2;
                    } catch (IOException e15) {
                        e = e15;
                        DatosExpediente datosExpediente12 = datosExpediente;
                        Log.e("DetExpSoapService", "IOException", e);
                        return expedienteDTO2;
                    } catch (Exception e16) {
                        e = e16;
                        DatosExpediente datosExpediente13 = datosExpediente;
                        Log.e("DetExpSoapService", "Exception", e);
                        return expedienteDTO2;
                    }
                } catch (SoapFault e17) {
                    WebServiceSettingsDTO webServiceSettingsDTO8 = wsSettings;
                    DatosExpediente datosExpediente14 = datosExpediente;
                    Log.i("DetExpSoapService", "soapFault, return null");
                    return null;
                } catch (XmlPullParserException e18) {
                    e = e18;
                    WebServiceSettingsDTO webServiceSettingsDTO9 = wsSettings;
                    DatosExpediente datosExpediente15 = datosExpediente;
                    Log.e("DetExpSoapService", "XmlPullParserException", e);
                    return expedienteDTO2;
                } catch (HttpResponseException e19) {
                    e = e19;
                    WebServiceSettingsDTO webServiceSettingsDTO10 = wsSettings;
                    DatosExpediente datosExpediente16 = datosExpediente;
                    Log.e("DetExpSoapService", "HttpResponseException", e);
                    return expedienteDTO2;
                } catch (IOException e20) {
                    e = e20;
                    WebServiceSettingsDTO webServiceSettingsDTO11 = wsSettings;
                    DatosExpediente datosExpediente17 = datosExpediente;
                    Log.e("DetExpSoapService", "IOException", e);
                    return expedienteDTO2;
                }
            } catch (SoapFault e21) {
                String str3 = nameSpace;
                WebServiceSettingsDTO webServiceSettingsDTO12 = wsSettings;
                DatosExpediente datosExpediente18 = datosExpediente;
                Log.i("DetExpSoapService", "soapFault, return null");
                return null;
            } catch (XmlPullParserException e22) {
                e = e22;
                String str4 = nameSpace;
                WebServiceSettingsDTO webServiceSettingsDTO13 = wsSettings;
                DatosExpediente datosExpediente19 = datosExpediente;
                Log.e("DetExpSoapService", "XmlPullParserException", e);
                return expedienteDTO2;
            } catch (HttpResponseException e23) {
                e = e23;
                String str5 = nameSpace;
                WebServiceSettingsDTO webServiceSettingsDTO14 = wsSettings;
                DatosExpediente datosExpediente20 = datosExpediente;
                Log.e("DetExpSoapService", "HttpResponseException", e);
                return expedienteDTO2;
            } catch (IOException e24) {
                e = e24;
                String str6 = nameSpace;
                WebServiceSettingsDTO webServiceSettingsDTO15 = wsSettings;
                DatosExpediente datosExpediente21 = datosExpediente;
                Log.e("DetExpSoapService", "IOException", e);
                return expedienteDTO2;
            } catch (Exception e25) {
                e = e25;
                String str7 = nameSpace;
                WebServiceSettingsDTO webServiceSettingsDTO16 = wsSettings;
                DatosExpediente datosExpediente22 = datosExpediente;
                Log.e("DetExpSoapService", "Exception", e);
                return expedienteDTO2;
            }
        } catch (SoapFault e26) {
            String str8 = tokenServ;
            String str9 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO17 = wsSettings;
            DatosExpediente datosExpediente23 = datosExpediente;
            Log.i("DetExpSoapService", "soapFault, return null");
            return null;
        } catch (XmlPullParserException e27) {
            e = e27;
            String str10 = tokenServ;
            String str11 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO18 = wsSettings;
            DatosExpediente datosExpediente24 = datosExpediente;
            Log.e("DetExpSoapService", "XmlPullParserException", e);
            return expedienteDTO2;
        } catch (HttpResponseException e28) {
            e = e28;
            String str12 = tokenServ;
            String str13 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO19 = wsSettings;
            DatosExpediente datosExpediente25 = datosExpediente;
            Log.e("DetExpSoapService", "HttpResponseException", e);
            return expedienteDTO2;
        } catch (IOException e29) {
            e = e29;
            String str14 = tokenServ;
            String str15 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO20 = wsSettings;
            DatosExpediente datosExpediente26 = datosExpediente;
            Log.e("DetExpSoapService", "IOException", e);
            return expedienteDTO2;
        } catch (Exception e30) {
            e = e30;
            String str16 = tokenServ;
            String str17 = nameSpace;
            WebServiceSettingsDTO webServiceSettingsDTO21 = wsSettings;
            DatosExpediente datosExpediente27 = datosExpediente;
            Log.e("DetExpSoapService", "Exception", e);
            return expedienteDTO2;
        }
        return expedienteDTO2;
    }
}
