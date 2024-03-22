package es.santander.justicia.minisJusticia.controllers;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import es.santander.justicia.http.WSClientUtility;
import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.HttpClientSettings;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsResponse;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.CustomIconRenderer;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.controllers.MapsController.1;
import es.santander.justicia.minisJusticia.controllers.MapsController.2;
import es.santander.justicia.minisJusticia.controllers.MapsController.3;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.dto.MarkerDTO;
import es.santander.justicia.minisJusticia.enums.MarkerType;
import es.santander.justicia.minisJusticia.interfaces.MapsInterface;
import es.santander.justicia.soap.service.login.soap.service.courtDetail.XmlBodyCourtDetailRequest;
import es.santander.justicia.soap.service.login.soap.service.courtDetail.params.CourtData;
import es.santander.justicia.utils.XMLParser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MapsController implements WsResponse, WsSoapResponse {
   public static final String KEY_ITEM = "row";
   public static final String KEY_LATITUDE = "lat";
   public static final String KEY_LONGITUDE = "lng";
   public static final String KEY_RESUME = "resumen";
   private Context context;
   private MapsInterface callback;
   private ClusterManager<MarkerDTO> mClusterManager;
   private GoogleMap mMap;
   private MarkerDTO markerSelected;
   private Marker courtMarkerSelected;
   private LayoutInflater inflater;

   public MapsController(Context context, GoogleMap mMap, MapsInterface callback, LayoutInflater inflater) {
      this.context = context;
      this.callback = callback;
      this.mMap = mMap;
      this.inflater = inflater;
   }

   public void getOfficesLocations(double latitude, double longitude) {
      HttpClientSettings settings = new HttpClientSettings();
      URL url = null;

      try {
         url = new URL(MainApplication.getInfo("aFgFbvJfV0XVJdD4uclHi438KQz8q//wK+naG9yAxj1oeVd0bZqQbe/84f/cqvwikvwZQ1xMyvp9mvQlQRrgow=="));
      } catch (MalformedURLException var9) {
         Log.e("MapsController", MainApplication.getInfo("aFgFbvJfV0XVJdD4uclHi438KQz8q//wK+naG9yAxj1oeVd0bZqQbe/84f/cqvwikvwZQ1xMyvp9mvQlQRrgow==") + " - MalformedURLException", var9);
      }

      ArrayList<Pair<String, String>> params = new ArrayList();
      params.add(new Pair("pagename", "BuscadorOficinas/Page/BOF_SearchInBounds"));
      params.add(new Pair("eid", "1237862939900"));
      params.add(new Pair("frame", "0.03628032031250024"));
      params.add(new Pair("lat", String.valueOf(latitude)));
      params.add(new Pair("lng", String.valueOf(longitude)));
      params.add(new Pair("leng", "es_ES"));
      params.add(new Pair("range", "100000"));
      settings.setParams(params);
      settings.setUrl(url);
      settings.setRequestType("GET");
      WSClientUtility wsClientUtility = new WSClientUtility(this.context, this);
      wsClientUtility.execute(new HttpClientSettings[]{settings});
   }

   public void setUpLocationClusters(ArrayList<MarkerDTO> markerList) {
      this.mClusterManager = new ClusterManager(this.context, this.mMap);
      this.mMap.setInfoWindowAdapter(this.mClusterManager.getMarkerManager());
      this.mClusterManager.setRenderer(new CustomIconRenderer(this.context, this.mMap, this.mClusterManager));
      CameraPosition[] mPreviousCameraPosition = new CameraPosition[]{null};
      this.mMap.setOnCameraIdleListener(new 1(this, mPreviousCameraPosition));
      this.mMap.setOnMarkerClickListener(this.mClusterManager);
      this.addItems(markerList);
      this.mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(new es.santander.justicia.minisJusticia.controllers.MapsController.CustomInfoWindowAdapterOffices(this));
      this.mMap.setOnMarkerClickListener(this.mClusterManager);
      this.mClusterManager.setOnClusterItemClickListener(new 2(this));
      this.callback.onFinishSetMarkers();
   }

   private void addItems(ArrayList<MarkerDTO> markerList) {
      if (markerList != null && !markerList.isEmpty()) {
         Iterator var2 = markerList.iterator();

         while(var2.hasNext()) {
            MarkerDTO marker = (MarkerDTO)var2.next();
            this.mClusterManager.addItem(marker);
         }
      } else {
         Toast.makeText(this.context, "No se pudo encontrar ninguna Oficina o cajero", 0).show();
      }

   }

   public void getCourtLocationByCode(String courtCode) {
      CourtData courtData = new CourtData(courtCode);
      XmlBodyCourtDetailRequest xmlBody = new XmlBodyCourtDetailRequest(courtData);
      WSSoapClientUtility wsSoapClientUtility = new WSSoapClientUtility(this);
      PropertyInfo body = new PropertyInfo();
      body.setName("arg0");
      body.setValue(xmlBody);
      body.setType(xmlBody.getClass());
      SoapClientSettings soapSettings = new SoapClientSettings();
      soapSettings.setEnvironment(MainApplication.getAppContext().getEnvironment());
      soapSettings.setSoapWebServicesEnum(SoapWebServicesEnum.COURT_DETAIL);
      soapSettings.setBody(body);
      soapSettings.setInitConfigName("wsAccessRequestLS");
      wsSoapClientUtility.execute(new SoapClientSettings[]{soapSettings});
   }

   public void onWsSuccess(int responseStatus, String wsResponse) {
      XMLParser parser = new XMLParser();
      Document doc = parser.getDomElement(wsResponse);
      NodeList nl = doc.getElementsByTagName("row");
      ArrayList<MarkerDTO> markerList = new ArrayList();

      for(int i = 0; i < nl.getLength(); ++i) {
         Element element = (Element)nl.item(i);
         double latitude = Double.parseDouble(parser.getValue(element, "lat"));
         double longitude = Double.parseDouble(parser.getValue(element, "lng"));
         String resume = parser.getValue(element, "resumen");
         MarkerDTO marker = new MarkerDTO(latitude, longitude);
         marker.setMarkerType(MarkerType.OFFICE);
         String[] resumeSplited = resume.trim().split(":");
         String type = resumeSplited[0];
         String address = resumeSplited[1];
         String zipCode = resumeSplited[2];
         address = address.trim().substring(0, address.length() - 3);
         marker.setTitle(type + " Santander");
         marker.setSnippet(address + ":" + zipCode);
         markerList.add(marker);
      }

      this.callback.onReceiveOfficesLocations(markerList);
   }

   public void onWsError(int responseStatus, String wsResponse) {
      Log.d("WsResponse", "wsResponse: " + wsResponse);
   }

   public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
      SoapObject requestResult = (SoapObject)response;
      SoapObject courtDataObject = (SoapObject)requestResult.getProperty("datosJuzgado");
      String viaType = courtDataObject.hasProperty("tipoVia") ? courtDataObject.getProperty("tipoVia").toString() : "";
      String viaName = courtDataObject.hasProperty("nombreVia") ? courtDataObject.getProperty("nombreVia").toString() : "";
      String number = courtDataObject.hasProperty("numero") ? courtDataObject.getProperty("numero").toString() : "";
      String province = courtDataObject.hasProperty("provincia") ? courtDataObject.getProperty("provincia").toString() : "";
      String zipCode = courtDataObject.hasProperty("codpost") ? courtDataObject.getProperty("codpost").toString() : "";
      String address = viaType + " " + viaName + " " + number + " " + province + " " + zipCode;
      CourtDataDto courtData = new CourtDataDto();
      courtData.setOrganismName(courtDataObject.hasProperty("nombreOrganismo") ? courtDataObject.getProperty("nombreOrganismo").toString().toUpperCase() : "");
      courtData.setJudicialEnvironment(courtDataObject.hasProperty("entornoJudicial") ? courtDataObject.getProperty("entornoJudicial").toString() : "");
      courtData.setStatus(courtDataObject.hasProperty("estado") ? courtDataObject.getProperty("estado").toString() : "");
      courtData.setPhoneNumber(courtDataObject.hasProperty("telefono1") ? courtDataObject.getProperty("telefono1").toString() : "");
      this.getLocationFromAddress(courtData, address);
   }

   public void getLocationFromAddress(CourtDataDto courtData, String strAddress) {
      Geocoder coder = new Geocoder(this.context);

      try {
         List<Address> address = coder.getFromLocationName(strAddress, 5);
         if (address != null && !address.isEmpty()) {
            Address location = (Address)address.get(0);
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            this.setCourtMarker(courtData, latLng);
            this.callback.onFindAddress(courtData, latLng, true);
         } else {
            this.callback.onFindAddress((CourtDataDto)null, (LatLng)null, false);
         }
      } catch (IOException var7) {
         Log.e("MapsController", "IOException", var7);
         this.callback.onFindAddress((CourtDataDto)null, (LatLng)null, false);
      }

   }

   public void setCourtMarker(CourtDataDto courtData, LatLng latLng) {
      this.mMap.setInfoWindowAdapter(new es.santander.justicia.minisJusticia.controllers.MapsController.CustomInfoWindowAdapterCourt(this));
      this.mMap.addMarker((new MarkerOptions()).position(latLng).title(courtData.getOrganismName()).snippet(courtData.getJudicialEnvironment() + ":" + courtData.getStatus() + ":" + courtData.getPhoneNumber())).setIcon(BitmapDescriptorFactory.fromResource(2131231264));
      this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0F));
      this.mMap.setOnMarkerClickListener(new 3(this));
   }

   public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
   }

   // $FF: synthetic method
   static GoogleMap access$000(MapsController x0) {
      return x0.mMap;
   }

   // $FF: synthetic method
   static ClusterManager access$100(MapsController x0) {
      return x0.mClusterManager;
   }

   // $FF: synthetic method
   static MarkerDTO access$202(MapsController x0, MarkerDTO x1) {
      return x0.markerSelected = x1;
   }

   // $FF: synthetic method
   static Marker access$302(MapsController x0, Marker x1) {
      return x0.courtMarkerSelected = x1;
   }

   // $FF: synthetic method
   static LayoutInflater access$400(MapsController x0) {
      return x0.inflater;
   }

   // $FF: synthetic method
   static MarkerDTO access$200(MapsController x0) {
      return x0.markerSelected;
   }

   // $FF: synthetic method
   static Marker access$300(MapsController x0) {
      return x0.courtMarkerSelected;
   }
}
