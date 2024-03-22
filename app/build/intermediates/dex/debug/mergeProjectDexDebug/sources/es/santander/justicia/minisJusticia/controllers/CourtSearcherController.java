package es.santander.justicia.minisJusticia.controllers;

import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.interfaces.CourtSearcherCallback;
import es.santander.justicia.soap.service.login.soap.service.commonParams.DatosPaginacion;
import es.santander.justicia.soap.service.login.soap.service.courtSearcher.XmlBodyCourtSearcherRequest;
import es.santander.justicia.soap.service.login.soap.service.courtSearcher.params.CourtData;
import es.santander.justicia.soap.service.login.soap.service.courtSearcher.params.PlaceData;
import es.santander.justicia.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

public class CourtSearcherController implements WsSoapResponse {
    private CourtSearcherCallback callback;

    public CourtSearcherController(CourtSearcherCallback callback2) {
        this.callback = callback2;
    }

    public void searchCourts(String codProvince, String codJudicialEnvironment) {
        XmlBodyCourtSearcherRequest xmlBody = new XmlBodyCourtSearcherRequest(new CourtData(codProvince, codJudicialEnvironment, "", new PlaceData("", "", codProvince)), new DatosPaginacion("1", "1000"));
        WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
        PropertyInfo body = new PropertyInfo();
        body.setName("arg0");
        body.setValue(xmlBody);
        body.setType(xmlBody.getClass());
        SoapClientSettings soapSettings = new SoapClientSettings();
        soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
        soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.SEARCH_COURTS);
        soapSettings.setBody(body);
        soapSettings.setInitConfigName("wsAccessRequestLS");
        wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
    }

    public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
        SoapObject requestResult = (SoapObject) response;
        ArrayList<SoapObject> courtObjectList = new ArrayList<>();
        int responseSize = requestResult.getPropertyCount() - 1;
        for (int i = 0; i < responseSize; i++) {
            courtObjectList.add((SoapObject) requestResult.getProperty(i));
        }
        ArrayList<CourtDataDto> courtDataList = new ArrayList<>();
        Iterator<SoapObject> it = courtObjectList.iterator();
        while (it.hasNext()) {
            SoapObject courtObject = it.next();
            CourtDataDto courtData = new CourtDataDto();
            courtData.setOrganismName(courtObject.getProperty("nombreOrganismo").toString());
            courtData.setJudicialEnvironment(courtObject.getProperty("entornoJudicial").toString());
            courtData.setStatus(courtObject.getProperty("estado").toString());
            courtData.setProvince(courtObject.getProperty("provincia").toString());
            courtData.setCourtCode(courtObject.getProperty(Constants.EXPEDIENT_JUZGA).toString());
            courtDataList.add(courtData);
        }
        this.callback.onFinishSearch(courtDataList, true);
    }

    public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
        this.callback.onFinishSearch((ArrayList<CourtDataDto>) null, false);
    }
}
