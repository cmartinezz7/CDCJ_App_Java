package es.santander.justicia.minisJusticia.controllers;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import es.santander.justicia.R;
import es.santander.justicia.http.WSClientUtility;
import es.santander.justicia.http.WSSoapClientUtility;
import es.santander.justicia.http.beans.HttpClientSettings;
import es.santander.justicia.http.beans.SoapClientSettings;
import es.santander.justicia.http.enums.SoapWebServicesEnum;
import es.santander.justicia.http.interfaces.WsResponse;
import es.santander.justicia.http.interfaces.WsSoapResponse;
import es.santander.justicia.minisJusticia.CustomIconRenderer;
import es.santander.justicia.minisJusticia.common.MainApplication;
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
    private MapsInterface callback;
    private Context context;
    /* access modifiers changed from: private */
    public Marker courtMarkerSelected;
    /* access modifiers changed from: private */
    public LayoutInflater inflater;
    /* access modifiers changed from: private */
    public ClusterManager<MarkerDTO> mClusterManager;
    /* access modifiers changed from: private */
    public GoogleMap mMap;
    /* access modifiers changed from: private */
    public MarkerDTO markerSelected;

    public MapsController(Context context2, GoogleMap mMap2, MapsInterface callback2, LayoutInflater inflater2) {
        this.context = context2;
        this.callback = callback2;
        this.mMap = mMap2;
        this.inflater = inflater2;
    }

    public void getOfficesLocations(double latitude, double longitude) {
        HttpClientSettings settings = new HttpClientSettings();
        URL url = null;
        try {
            url = new URL(MainApplication.getInfo(MainApplication.OFFICES_LOCATIONSe));
        } catch (MalformedURLException e) {
            Log.e("MapsController", MainApplication.getInfo(MainApplication.OFFICES_LOCATIONSe) + " - MalformedURLException", e);
        }
        ArrayList<Pair<String, String>> params = new ArrayList<>();
        params.add(new Pair("pagename", "BuscadorOficinas/Page/BOF_SearchInBounds"));
        params.add(new Pair("eid", "1237862939900"));
        params.add(new Pair("frame", "0.03628032031250024"));
        params.add(new Pair(KEY_LATITUDE, String.valueOf(latitude)));
        params.add(new Pair(KEY_LONGITUDE, String.valueOf(longitude)));
        params.add(new Pair("leng", "es_ES"));
        params.add(new Pair("range", "100000"));
        settings.setParams(params);
        settings.setUrl(url);
        settings.setRequestType("GET");
        new WSClientUtility(this.context, this).execute(new HttpClientSettings[]{settings});
    }

    public void setUpLocationClusters(ArrayList<MarkerDTO> markerList) {
        ClusterManager<MarkerDTO> clusterManager = new ClusterManager<>(this.context, this.mMap);
        this.mClusterManager = clusterManager;
        this.mMap.setInfoWindowAdapter(clusterManager.getMarkerManager());
        this.mClusterManager.setRenderer(new CustomIconRenderer(this.context, this.mMap, this.mClusterManager));
        final CameraPosition[] mPreviousCameraPosition = {null};
        this.mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            public void onCameraIdle() {
                CameraPosition position = MapsController.this.mMap.getCameraPosition();
                CameraPosition[] cameraPositionArr = mPreviousCameraPosition;
                if (cameraPositionArr[0] == null || cameraPositionArr[0].zoom != position.zoom) {
                    mPreviousCameraPosition[0] = MapsController.this.mMap.getCameraPosition();
                    MapsController.this.mClusterManager.cluster();
                }
            }
        });
        this.mMap.setOnMarkerClickListener(this.mClusterManager);
        addItems(markerList);
        this.mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(new CustomInfoWindowAdapterOffices());
        this.mMap.setOnMarkerClickListener(this.mClusterManager);
        this.mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MarkerDTO>() {
            public boolean onClusterItemClick(MarkerDTO markerDTO) {
                MarkerDTO unused = MapsController.this.markerSelected = markerDTO;
                return false;
            }
        });
        this.callback.onFinishSetMarkers();
    }

    private void addItems(ArrayList<MarkerDTO> markerList) {
        if (markerList == null || markerList.isEmpty()) {
            Toast.makeText(this.context, "No se pudo encontrar ninguna Oficina o cajero", 0).show();
            return;
        }
        Iterator<MarkerDTO> it = markerList.iterator();
        while (it.hasNext()) {
            this.mClusterManager.addItem(it.next());
        }
    }

    public void getCourtLocationByCode(String courtCode) {
        XmlBodyCourtDetailRequest xmlBody = new XmlBodyCourtDetailRequest(new CourtData(courtCode));
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
        NodeList nl = doc.getElementsByTagName(KEY_ITEM);
        ArrayList<MarkerDTO> markerList = new ArrayList<>();
        int i = 0;
        while (i < nl.getLength()) {
            Element element = (Element) nl.item(i);
            double latitude = Double.parseDouble(parser.getValue(element, KEY_LATITUDE));
            double longitude = Double.parseDouble(parser.getValue(element, KEY_LONGITUDE));
            String resume = parser.getValue(element, KEY_RESUME);
            MarkerDTO marker = new MarkerDTO(latitude, longitude);
            marker.setMarkerType(MarkerType.OFFICE);
            String[] resumeSplited = resume.trim().split(":");
            XMLParser parser2 = parser;
            String type = resumeSplited[0];
            String address = resumeSplited[1];
            String zipCode = resumeSplited[2];
            Document doc2 = doc;
            String address2 = address.trim().substring(0, address.length() - 3);
            marker.setTitle(type + " Santander");
            marker.setSnippet(address2 + ":" + zipCode);
            markerList.add(marker);
            i++;
            String str = wsResponse;
            parser = parser2;
            nl = nl;
            doc = doc2;
        }
        this.callback.onReceiveOfficesLocations(markerList);
    }

    public void onWsError(int responseStatus, String wsResponse) {
        Log.d("WsResponse", "wsResponse: " + wsResponse);
    }

    public void onWsSoapSuccess(SoapWebServicesEnum wsRequest, Object response) {
        SoapObject courtDataObject = (SoapObject) ((SoapObject) response).getProperty("datosJuzgado");
        String str = "";
        String address = (courtDataObject.hasProperty("tipoVia") ? courtDataObject.getProperty("tipoVia").toString() : str) + " " + (courtDataObject.hasProperty("nombreVia") ? courtDataObject.getProperty("nombreVia").toString() : str) + " " + (courtDataObject.hasProperty("numero") ? courtDataObject.getProperty("numero").toString() : str) + " " + (courtDataObject.hasProperty("provincia") ? courtDataObject.getProperty("provincia").toString() : str) + " " + (courtDataObject.hasProperty("codpost") ? courtDataObject.getProperty("codpost").toString() : str);
        CourtDataDto courtData = new CourtDataDto();
        courtData.setOrganismName(courtDataObject.hasProperty("nombreOrganismo") ? courtDataObject.getProperty("nombreOrganismo").toString().toUpperCase() : str);
        courtData.setJudicialEnvironment(courtDataObject.hasProperty("entornoJudicial") ? courtDataObject.getProperty("entornoJudicial").toString() : str);
        courtData.setStatus(courtDataObject.hasProperty("estado") ? courtDataObject.getProperty("estado").toString() : str);
        if (courtDataObject.hasProperty("telefono1")) {
            str = courtDataObject.getProperty("telefono1").toString();
        }
        courtData.setPhoneNumber(str);
        getLocationFromAddress(courtData, address);
    }

    public void getLocationFromAddress(CourtDataDto courtData, String strAddress) {
        try {
            List<Address> address = new Geocoder(this.context).getFromLocationName(strAddress, 5);
            if (address == null || address.isEmpty()) {
                this.callback.onFindAddress((CourtDataDto) null, (LatLng) null, false);
                return;
            }
            Address location = address.get(0);
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            setCourtMarker(courtData, latLng);
            this.callback.onFindAddress(courtData, latLng, true);
        } catch (IOException e) {
            Log.e("MapsController", "IOException", e);
            this.callback.onFindAddress((CourtDataDto) null, (LatLng) null, false);
        }
    }

    public void setCourtMarker(CourtDataDto courtData, LatLng latLng) {
        this.mMap.setInfoWindowAdapter(new CustomInfoWindowAdapterCourt());
        this.mMap.addMarker(new MarkerOptions().position(latLng).title(courtData.getOrganismName()).snippet(courtData.getJudicialEnvironment() + ":" + courtData.getStatus() + ":" + courtData.getPhoneNumber())).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.poi_juzgado));
        this.mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
        this.mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                Marker unused = MapsController.this.courtMarkerSelected = marker;
                return false;
            }
        });
    }

    public void onWsSoapError(SoapWebServicesEnum wsRequest, Object response) {
    }

    public class CustomInfoWindowAdapterOffices implements GoogleMap.InfoWindowAdapter {
        public CustomInfoWindowAdapterOffices() {
        }

        public View getInfoWindow(Marker marker) {
            return null;
        }

        public View getInfoContents(Marker marker) {
            View view = MapsController.this.inflater.inflate(R.layout.custom_marker_info_window_offices, (ViewGroup) null);
            String[] snippetSplited = MapsController.this.markerSelected.getSnippet().split(":");
            ((TextView) view.findViewById(R.id.tv_title)).setText(MapsController.this.markerSelected.getTitle());
            ((TextView) view.findViewById(R.id.tv_snippet_row1)).setText(snippetSplited[0].trim());
            ((TextView) view.findViewById(R.id.tv_snippet_row2)).setText(snippetSplited[1].trim());
            return view;
        }
    }

    public class CustomInfoWindowAdapterCourt implements GoogleMap.InfoWindowAdapter {
        public CustomInfoWindowAdapterCourt() {
        }

        public View getInfoWindow(Marker marker) {
            return null;
        }

        public View getInfoContents(Marker marker) {
            View view = MapsController.this.inflater.inflate(R.layout.custom_marker_info_window_courts, (ViewGroup) null);
            String[] snippetSplited = MapsController.this.courtMarkerSelected.getSnippet().split(":");
            ((TextView) view.findViewById(R.id.tv_title)).setText(MapsController.this.courtMarkerSelected.getTitle());
            ((TextView) view.findViewById(R.id.tv_snippet_environment)).setText(snippetSplited[0].trim());
            ((TextView) view.findViewById(R.id.tv_snippet_status)).setText(snippetSplited[1].trim());
            ((TextView) view.findViewById(R.id.tv_snippet_phone_number)).setText(snippetSplited[2].trim());
            return view;
        }
    }
}
