package es.santander.justicia.minisJusticia.controllers;

import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.dto.totalMovementsDTO;
import es.santander.justicia.minisJusticia.enums.MovementStatusEnum;
import es.santander.justicia.minisJusticia.interfaces.MovementQueryCallback;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosExpediente;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.movementsQuery.XmlBodyMovementsQuery;
import es.santander.justicia.soap.service.login.soap.service.movementsQuery.params.FilterData;
import es.santander.justicia.soap.service.login.soap.service.movementsQuery.params.ProfessionalOperationData;
import es.santander.justicia.utils.DateUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class MovementsController implements WsSoapResponse {
    private MovementQueryCallback callback;

    public MovementsController(MovementQueryCallback callback2) {
        this.callback = callback2;
    }

    public void getMovements(String juzga, String juzgori, String jnumexp, String jproced, String janoapex, String dateFrom, String dateTo, String importFrom, String importTo, String movementCode, String currencyType) {
        String dateFrom2;
        String dateTo2;
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
        XmlBodyMovementsQuery xmlBody = new XmlBodyMovementsQuery(new FilterData(dateFrom2, dateTo2, importFrom, importTo), new ProfessionalOperationData(new DatosExpediente(juzga, juzgori, jnumexp, jproced, janoapex), currencyType, movementCode), new DatosPaginacion("1", "1000"));
        WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
        PropertyInfo body = new PropertyInfo();
        body.setName("arg0");
        body.setValue(xmlBody);
        body.setType(xmlBody.getClass());
        SoapClientSettings soapSettings = new SoapClientSettings();
        soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
        soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.MOVEMENT_QUERY);
        soapSettings.setBody(body);
        soapSettings.setInitConfigName("wsAccessRequestLS");
        wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
    }

    public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
        SoapObject requestResult = (SoapObject) response;
        ArrayList<SoapObject> movementsObjectList = new ArrayList<>();
        ArrayList<SoapObject> totalsObjectList = new ArrayList<>();
        int responseSize = requestResult.getPropertyCount();
        for (int i = 0; i < responseSize; i++) {
            SoapObject item = (SoapObject) requestResult.getProperty(i);
            if (item.hasProperty("serieYMandamiento")) {
                movementsObjectList.add(item);
            } else if (item.hasProperty("jimpabono") && item.hasProperty("jimpcargo") && item.hasProperty("jimppend")) {
                totalsObjectList.add(item);
            }
        }
        ArrayList<MovementItemDTO> movementList = new ArrayList<>();
        Iterator<SoapObject> it = movementsObjectList.iterator();
        while (it.hasNext()) {
            SoapObject movementObject = it.next();
            MovementItemDTO movement = new MovementItemDTO();
            if (movementObject.hasProperty("codmon")) {
                movement.setCodmon(movementObject.getPropertyAsString("codmon"));
            }
            if (movementObject.hasProperty("desctipomod")) {
                movement.setDesctipomod(movementObject.getPropertyAsString("desctipomod"));
            }
            if (movementObject.hasProperty("jimpnomi")) {
                movement.setImporte(movementObject.getPropertyAsString("jimpnomi"));
                movement.setMovementStatus(MovementStatusEnum.EXECUTED);
            } else if (movementObject.hasProperty("jimppend")) {
                movement.setImporte(movementObject.getPropertyAsString("jimppend"));
                movement.setMovementStatus(MovementStatusEnum.PENDING);
            } else if (movementObject.hasProperty("jimpcaduca")) {
                movement.setImporte(movementObject.getPropertyAsString("jimpcaduca"));
                movement.setMovementStatus(MovementStatusEnum.EXPIRED);
            }
            if (movementObject.hasProperty("jnors")) {
                movement.setJnors(movementObject.getPropertyAsString("jnors"));
            }
            if (movementObject.hasProperty("jnuoper")) {
                movement.setJnuoper(movementObject.getPropertyAsString("jnuoper"));
            }
            if (movementObject.hasProperty("jtipomod")) {
                movement.setJtipomod(movementObject.getPropertyAsString("jtipomod"));
            }
            if (movementObject.hasProperty("moneda")) {
                movement.setMoneda(movementObject.getPropertyAsString("moneda"));
            }
            if (movementObject.hasProperty("numerosr")) {
                movement.setNumerosr(movementObject.getPropertyAsString("numerosr"));
            }
            if (movementObject.hasProperty("seralfab")) {
                movement.setSeralfab(movementObject.getPropertyAsString("seralfab"));
            }
            if (movementObject.hasProperty("serieYMandamiento")) {
                movement.setSerieYMandamiento(movementObject.getPropertyAsString("serieYMandamiento"));
            }
            if (movementObject.hasProperty("jusrhare")) {
                movement.setjResponsableAlta(movementObject.getPropertyAsString("jusrhare"));
            }
            if (movementObject.hasProperty("jusrfirma")) {
                movement.setjResponsableFirma(movementObject.getPropertyAsString("jusrfirma"));
            }
            if (movementObject.hasProperty("jusrfirmeza")) {
                movement.setjResponsableFirmeza(movementObject.getPropertyAsString("jusrfirmeza"));
            }
            if (movementObject.hasProperty("jusrautoriza")) {
                movement.setjResponsableAutorizacion(movementObject.getPropertyAsString("jusrautoriza"));
            }
            if (movementObject.hasProperty("jusrconf")) {
                movement.setjResponsableConfirmacion(movementObject.getPropertyAsString("jfecconf"));
            }
            if (movementObject.hasProperty("jfechare")) {
                movement.setJfechare(DateUtils.formatDate(movementObject.getPropertyAsString("jfechare")));
            }
            if (movementObject.hasProperty("jfecfirma")) {
                movement.setjFechaFirma(DateUtils.formatDate(movementObject.getPropertyAsString("jfecfirma")));
            }
            if (movementObject.hasProperty("jfecfirmeza")) {
                movement.setjFechaFirmeza(DateUtils.formatDate(movementObject.getPropertyAsString("jfecfirmeza")));
            }
            if (movementObject.hasProperty("jfecautoriza")) {
                movement.setjFechaAutorizacion(DateUtils.formatDate(movementObject.getPropertyAsString("jfecautoriza")));
            }
            if (movementObject.hasProperty("jfecconf")) {
                movement.setjFechaConfirmacion(DateUtils.formatDate(movementObject.getPropertyAsString("jfecconf")));
            }
            if (movementObject.hasProperty("jfeccaduc")) {
                movement.setjFechaCaducidad(DateUtils.formatDate(movementObject.getPropertyAsString("jfeccaduc")));
            }
            movementList.add(movement);
        }
        ArrayList<totalMovementsDTO> totalsList = new ArrayList<>();
        Iterator<SoapObject> it2 = totalsObjectList.iterator();
        while (it2.hasNext()) {
            SoapObject totalObject = it2.next();
            totalMovementsDTO total = new totalMovementsDTO();
            if (totalObject.hasProperty("jimpabono")) {
                total.setImportPayment(totalObject.getPropertyAsString("jimpabono"));
            }
            if (totalObject.hasProperty("jimpcargo")) {
                total.setImportCharge(totalObject.getPropertyAsString("jimpcargo"));
            }
            if (totalObject.hasProperty("jimppend")) {
                total.setImportPending(totalObject.getPropertyAsString("jimppend"));
            }
            if (totalObject.hasProperty("codmon")) {
                total.setCodmod(totalObject.getPropertyAsString("codmon"));
            }
            if (totalObject.hasProperty("moneda")) {
                total.setCurrency(totalObject.getPropertyAsString("moneda"));
            }
            totalsList.add(total);
        }
        this.callback.onFinishGetMovements(movementList, totalsList, true, "");
    }

    public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
        SoapFault error = (SoapFault) response;
        this.callback.onFinishGetMovements((ArrayList<MovementItemDTO>) null, (ArrayList<totalMovementsDTO>) null, false, error != null ? error.faultstring : "Error al invocar al servicio, vuelva a intentarlo");
    }
}
