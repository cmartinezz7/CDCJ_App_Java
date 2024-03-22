package es.santander.justicia.minisJusticia.controllers;

import android.util.Log;
import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.dto.SaldoDTO;
import es.santander.justicia.minisJusticia.interfaces.ExpedientsCallBack;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.EntradaXmlDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ParamsRequestDetalleExpediente.DatosAccesoProfesionales;
import es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ResponseDetalleExpediente;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.ParamsRequestBuscarExpediente.DatosAcesooProfesionalesBuscar;
import es.santander.justicia.soap.service.login.soap.service.buscarExpedientes.XmlBodyExpedientsRequest;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpedienteBuscar;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.petitions.params.FilterData;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class ExpedientsController implements WsSoapResponse {
    private ExpedientsCallBack callback;
    private ExpedienteDTO expedient;

    public ExpedientsController(ExpedientsCallBack callback2) {
        this.callback = callback2;
    }

    public void getExpedients(ExpedienteDTO expedient2, String dateFrom, String dateTo, String selectionType, String situationType, String currencyType) {
        String dateFrom2;
        String dateTo2;
        DatosExpedienteBuscar expedientData;
        if (dateFrom == null || dateFrom.length() < 5) {
            dateFrom2 = "1970-01-01";
        } else {
            dateFrom2 = DateUtils.formatDateToRequest(dateFrom);
        }
        if (dateTo == null || dateTo.length() < 5) {
            dateTo2 = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        } else {
            dateTo2 = DateUtils.formatDateToRequest(dateTo);
        }
        if (expedient2 != null) {
            expedientData = new DatosExpedienteBuscar(expedient2.getJuzga(), expedient2.getJuzgori(), expedient2.getJnumexp(), expedient2.getJproced(), expedient2.getJanoapex(), situationType, currencyType);
        } else {
            expedientData = new DatosExpedienteBuscar("", "", "", "", "", situationType, currencyType);
        }
        XmlBodyExpedientsRequest xmlBody = new XmlBodyExpedientsRequest(new DatosAcesooProfesionalesBuscar(expedientData), new FilterData(dateFrom2, dateTo2, selectionType), new DatosPaginacion("1", "1000"));
        WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
        PropertyInfo body = new PropertyInfo();
        body.setName("arg0");
        body.setValue(xmlBody);
        body.setType(xmlBody.getClass());
        SoapClientSettings soapSettings = new SoapClientSettings();
        soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
        soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.EXPEDIENTS_LIST);
        soapSettings.setBody(body);
        soapSettings.setInitConfigName("wsAccessRequestLS");
        wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
    }

    public void getExpedientDetail(ExpedienteDTO expedient2) {
        this.expedient = expedient2;
        DatosAccesoProfesionales professionalDataAccess = new DatosAccesoProfesionales(new DatosExpediente(expedient2.getJuzga(), expedient2.getJuzgori(), expedient2.getJnumexp(), expedient2.getJproced(), expedient2.getJanoapex()));
        new DatosPaginacion("1", "1000");
        EntradaXmlDetalleExpediente xmlBody = new EntradaXmlDetalleExpediente(professionalDataAccess);
        WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
        PropertyInfo body = new PropertyInfo();
        body.setName("arg0");
        body.setValue(xmlBody);
        body.setType(xmlBody.getClass());
        SoapClientSettings soapSettings = new SoapClientSettings();
        soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
        soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.EXPEDIENTS_DETAIL);
        soapSettings.setBody(body);
        soapSettings.setInitConfigName("wsAccessRequestLS");
        wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
    }

    /* renamed from: es.santander.justicia.minisJusticia.controllers.ExpedientsController$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$es$santander$justicia$http$enums$SoapWebServicesEnum;

        static {
            int[] iArr = new int[SoapWebServicesEnum.values().length];
            $SwitchMap$es$santander$justicia$http$enums$SoapWebServicesEnum = iArr;
            try {
                iArr[SoapWebServicesEnum.EXPEDIENTS_LIST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$es$santander$justicia$http$enums$SoapWebServicesEnum[SoapWebServicesEnum.EXPEDIENTS_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
        int i = AnonymousClass1.$SwitchMap$es$santander$justicia$http$enums$SoapWebServicesEnum[wsRequest.ordinal()];
        if (i == 1) {
            SoapObject requestResult = (SoapObject) response;
            ArrayList<SoapObject> petitionObjectList = new ArrayList<>();
            int responseSize = requestResult.getPropertyCount() - 1;
            for (int i2 = 0; i2 < responseSize; i2++) {
                petitionObjectList.add((SoapObject) requestResult.getProperty(i2));
            }
            ArrayList<ExpedienteDTO> expedientList = new ArrayList<>();
            Iterator<SoapObject> it = petitionObjectList.iterator();
            while (it.hasNext()) {
                SoapObject expedientItem = it.next();
                ExpedienteDTO expediente = new ExpedienteDTO();
                if (expedientItem.hasProperty(Constants.EXPEDIENT_JUZGA)) {
                    expediente.setJuzga(expedientItem.getPropertyAsString(Constants.EXPEDIENT_JUZGA));
                }
                if (expedientItem.hasProperty(Constants.EXPEDIENT_JUZGORI)) {
                    expediente.setJuzgori(expedientItem.getPropertyAsString(Constants.EXPEDIENT_JUZGORI));
                }
                if (expedientItem.hasProperty(Constants.EXPEDIENT_JPROCED)) {
                    expediente.setJproced(expedientItem.getPropertyAsString(Constants.EXPEDIENT_JPROCED));
                }
                if (expedientItem.hasProperty(Constants.EXPEDIENT_JNUMEXP)) {
                    expediente.setJnumexp(expedientItem.getPropertyAsString(Constants.EXPEDIENT_JNUMEXP));
                }
                if (expedientItem.hasProperty(Constants.EXPEDIENT_JANOAPEX)) {
                    expediente.setJanoapex(expedientItem.getPropertyAsString(Constants.EXPEDIENT_JANOAPEX));
                }
                if (expedientItem.hasProperty("codExpediente")) {
                    expediente.setCodExpediente(expedientItem.getPropertyAsString("codExpediente"));
                }
                if (expedientItem.hasProperty("primov")) {
                    expediente.setPrimov(expedientItem.getPropertyAsString("primov"));
                }
                if (expedientItem.hasProperty("ultmov")) {
                    expediente.setUltmov(expedientItem.getPropertyAsString("ultmov"));
                }
                if (expedientItem.hasProperty("situacion")) {
                    expediente.setSituacion(expedientItem.getPropertyAsString("situacion"));
                }
                if (expedientItem.hasProperty("sitexp")) {
                    expediente.setSitexp(expedientItem.getPropertyAsString("sitexp"));
                }
                if (expedientItem.hasProperty("saldos")) {
                    SoapObject saldosObject = (SoapObject) expedientItem.getProperty("saldos");
                    if (saldosObject.hasProperty("codmon")) {
                        expediente.setCodmon(saldosObject.getPropertyAsString("codmon"));
                    }
                    if (saldosObject.hasProperty("impsaldo")) {
                        expediente.setSaldo(saldosObject.getPropertyAsString("impsaldo"));
                    }
                    if (saldosObject.hasProperty("moneda")) {
                        expediente.setMoneda(saldosObject.getPropertyAsString("moneda"));
                    }
                }
                expedientList.add(expediente);
            }
            this.callback.onFinishGetExpedients(expedientList, true, "");
        } else if (i == 2) {
            SoapObject expedienteDetail = new ResponseDetalleExpediente((SoapObject) response).getDatosExpediente();
            List<SaldoDTO> saldos = new ArrayList<>();
            for (int i3 = 0; i3 < expedienteDetail.getPropertyCount(); i3++) {
                PropertyInfo saldoSoapProperty = expedienteDetail.getPropertyInfo(i3);
                if ("saldos".equals(saldoSoapProperty.getName()) && (saldoSoapProperty.getValue() instanceof SoapObject)) {
                    SaldoDTO saldoDTO = new SaldoDTO();
                    SoapObject saldoSoapObject = (SoapObject) saldoSoapProperty.getValue();
                    try {
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
                        this.expedient.setIntCostas(expedienteDetail.getPropertyAsString("impInterCostas"));
                    } catch (Exception e) {
                        Log.e("ExpedientsController", "Error parseo datos", e);
                    }
                    saldos.add(saldoDTO);
                }
            }
            this.expedient.setSaldos(saldos);
            this.expedient.setDetail(true);
            this.callback.onFinishGetExpedientDetail(this.expedient, true, "");
        }
    }

    public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
        SoapFault error = (SoapFault) response;
        String errorMessage = error != null ? error.faultstring : "Error al invocar al servicio, vuelva a intentarlo";
        int i = AnonymousClass1.$SwitchMap$es$santander$justicia$http$enums$SoapWebServicesEnum[wsRequest.ordinal()];
        if (i == 1) {
            this.callback.onFinishGetExpedients((ArrayList<ExpedienteDTO>) null, false, errorMessage);
        } else if (i == 2) {
            this.callback.onFinishGetExpedientDetail((ExpedienteDTO) null, false, errorMessage);
        }
    }
}
