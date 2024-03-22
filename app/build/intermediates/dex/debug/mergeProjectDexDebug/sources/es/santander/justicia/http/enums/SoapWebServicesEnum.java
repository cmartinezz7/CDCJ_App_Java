package es.santander.justicia.http.enums;

import androidx.core.util.Pair;
import es.santander.justicia.utils.Constants;
import java.util.ArrayList;

public enum SoapWebServicesEnum {
    USER_DETAIL("detallesUsuario", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detallesUsuario", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    }),
    DETAIL_MOVEMENTS("detalleMovimiento", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detalleMovimiento", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    }),
    SEARCH_COURTS("searchCourt", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:consultaJuzgados", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
            add(new Pair("facade", "WSOficinas"));
            add(new Pair("xmlns:new", "http://www.imcs.es/cdcj/oficinas/"));
        }
    }),
    COURT_DETAIL("courtDetail", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detalleJuzgado", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    }),
    ACCESS_REQUEST(Constants.ACCESS_REQUEST_FRAGMENT, "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:solicitudAcceso", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    }),
    MOVEMENT_QUERY(Constants.ACCESS_REQUEST_FRAGMENT, "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "wss:consultaMovimientos", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:wss", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    }),
    PETITIONS_LIST(Constants.ACCESS_REQUEST_FRAGMENT, "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:buscarPeticionesAcceso", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    }),
    EXPEDIENTS_LIST(Constants.ACCESS_REQUEST_FRAGMENT, "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:buscarExpedientes", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    }),
    EXPEDIENTS_DETAIL(Constants.ACCESS_REQUEST_FRAGMENT, "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/", "sup:detalleExpediente", new ArrayList<Pair<String, String>>() {
        {
            add(new Pair("xmlns:soapenv", "http://schemas.xmlsoap.org/soap/envelope/"));
            add(new Pair("xmlns:sup", "http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"));
        }
    });
    
    private ArrayList<Pair<String, String>> attributes;
    private String methodName;
    private String nameSpace;
    private String wsName;

    private SoapWebServicesEnum(String wsName2, String nameSpace2, String metodeName, ArrayList<Pair<String, String>> attributes2) {
        this.wsName = wsName2;
        this.nameSpace = nameSpace2;
        this.methodName = metodeName;
        this.attributes = attributes2;
    }

    public String getWsName() {
        return this.wsName;
    }

    public String getNameSpace() {
        return this.nameSpace;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public ArrayList<Pair<String, String>> getAttributes() {
        return this.attributes;
    }

    public String getSoapAction() {
        return this.nameSpace + this.methodName;
    }
}
