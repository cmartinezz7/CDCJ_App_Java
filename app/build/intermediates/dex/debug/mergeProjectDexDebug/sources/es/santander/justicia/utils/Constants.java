package es.santander.justicia.utils;

import es.santander.justicia.minisJusticia.common.dto.UserDTO;

public class Constants {
    public static final int ACCEPT = 0;
    public static final String ACCESS_REQUEST_FRAGMENT = "accessRequest";
    public static final int ACTIVE = 6;
    public static final int BAJA = 2;
    public static final int CANCEL = 5;
    public static final String COURT_CODE = "courtCode";
    public static final String CURRENCY_TYPE = "cointType";
    public static final String CURRENCY_VALUE = "currencyValue";
    public static final String DATE_FORMAT_AUTORIZATIONS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FROM = "dateFrom";
    public static final String DATE_TO = "dateTo";
    public static final String DEFAULT_PREFERENCES = "defaultPreferences";
    public static final int DENIE = 1;
    public static final int DURACION_SPLASH = 5000;
    public static final String EXPEDIENT_JANOAPEX = "janoapex";
    public static final String EXPEDIENT_JNUMEXP = "jnumexp";
    public static final String EXPEDIENT_JPROCED = "jproced";
    public static final String EXPEDIENT_JUZGA = "juzga";
    public static final String EXPEDIENT_JUZGORI = "juzgori";
    public static final String EXPEDIENT_NUMBER = "expedientNumber";
    public static final String EXP_STATE_ACCEPT = "AL";
    public static final String EXP_STATE_BAJA = "BA";
    public static final String EXP_STATE_CANCELLED = "CA";
    public static final String EXP_STATE_CONCLUDED = "CO";
    public static final String EXP_STATE_CREATED = "CR";
    public static final String EXP_STATE_DENIED = "DE";
    public static final String EXP_STATE_EJECUTED = "EJ";
    public static final String EXP_STATE_OPEN = "AB";
    public static final String EXP_STATE_OPERATIVE = "OP";
    public static final String EXP_STATE_PENDING = "PE";
    public static final String EXTRA_AUTORIZATION = "extra_autorization";
    public static final String EXTRA_COD_ENTORNO_JUDICIAL = "extra_cod_entorno_judicial";
    public static final String EXTRA_COD_PROVINCIA = "extra_cod_provincia";
    public static final String EXTRA_CONTRATCTS_LIST = "extra_contratcs_list";
    public static final String EXTRA_ESTADO_EMBARGO = "extra_estado_embargo";
    public static final String EXTRA_FECHA_DESDE = "extra_desde";
    public static final String EXTRA_FECHA_HASTA = "extra_hasta";
    public static final String EXTRA_FILTER = "extra_filter";
    public static final String EXTRA_IMPORTE_DESDE = "extra_importe_desde";
    public static final String EXTRA_IMPORTE_HASTA = "extra_importe_hasta";
    public static final String EXTRA_INDICADOR_APODERADO = "extra_indicador_apoderado";
    public static final String EXTRA_JANOAPEX = "extra_janoapex";
    public static final String EXTRA_JNUMEXP = "extra_jnumexp";
    public static final String EXTRA_JPROCED = "extra_jproced";
    public static final String EXTRA_JUZDESTIMNO = "extra_juzdestino";
    public static final String EXTRA_JUZGA = "extra_juzga";
    public static final String EXTRA_JUZGORI = "extra_juzgori";
    public static final String EXTRA_LISTADO_EXPEDIENTES = "extra_listado_expedientes";
    public static final String EXTRA_LISTA_REPOSICION = "extra_lista_reposicion";
    public static final String EXTRA_MONEDA = "extra_moneda";
    public static final String EXTRA_MOTIVE_ANULATION = "extra_motive_anulation";
    public static final String EXTRA_NUM_OPERACION = "extra_num_operacion";
    public static final String EXTRA_OPERACION = "extra_operacion";
    public static final String EXTRA_OPERACION_SELECCIONADA = "extra_operacion_seleccionada";
    public static final String EXTRA_ORGANISMO = "extra_organismo";
    public static final String EXTRA_SEARCH = "extra_search";
    public static final String EXTRA_SHOW_CONTRACTS = "extra_show_contracts";
    public static final String EXTRA_SPINNER_POSITION = "extra_spinner_position";
    public static final String EXTRA_STATE = "extra_state";
    public static final String EXTRA_TIPOS_SELECCION = "extra_tipo_seleccion";
    public static final String EXTRA_TIPO_EMBARGO = "extra_tipo_embargo";
    public static final String EXTRA_TIPO_MOVIMIENTO = "extra_tipo_movimiento";
    public static final String EXTRA_TOKEN_EMPRESAS = "extra_token_empresas";
    public static final String EXTRA_USER_RAF = "extra_user_raf";
    public static final String FIRASANS_MEDIUM = "FiraSans-Medium.ttf";
    public static final String FIRASANS_REGULAR = "FiraSans-Regular.ttf";
    public static final String IMPORT_FROM = "importFrom";
    public static final String IMPORT_TO = "importTo";
    public static final String INIT_CONFIGURATION_URL = "https://mobileconfig.cemobile.eu/init.json";
    public static final String JUDICIAL_ENVIRONMENT = "judicialEnvironment";
    public static final String KEY_AUTHENTICATION_TYPE_CODE = "authenticationTypeCode";
    public static final String KEY_CHECKBOX_REMEMBER_ME = "rememberMe";
    public static final String KEY_COMPANY_MODE = "companyMode";
    public static final String KEY_DOCUMENT_NUMBER = "documentNumber";
    public static final String KEY_DOCUMENT_TYPE = "documentType";
    public static final String KEY_LOGIN_CODE = "code";
    public static final String LATO_BOLD = "lato_bold.ttf";
    public static final int MODIFY = 3;
    public static final String MOTIVE_ANULATION = "motiveAnulation";
    public static final String MOVEMENT_TYPE = "movementType";
    public static final int OTHERS = 4;
    public static final String POPUP_NAME = "popupName";
    public static final String PREFERECENCE_COD_UO = "preference_cod_uo";
    public static final String PREFERECENCE_LOGIN_DOCUMENT = "preference_user_document";
    public static final String PREFERECENCE_LOGIN_PASS = "preference_user_pass";
    public static final String PREFERECENCE_LOGIN_TYPE_DOCUMENT = "preference_user_type_document";
    public static final String PREFERECENCE_LOGIN_USER = "preference_user_login";
    public static final String PREFERECENCE_LOGIN_USER_NAME = "preference_user_login_name";
    public static final String PREFERECENCE_ORGANISM = "preference_organism";
    public static final String PREFERECENCE_REMEMBER_DATA = "preference_remember_data";
    public static final String PREFERECENCE_TOKEN_LOGIN_UNICO = "preference_token_login_unico";
    public static final String PREFERECENCE_TOKEN_SSO = "preference_token_sso";
    public static final String PREFERECENCE_USER = "preference_user";
    public static final String PREFERENCE_ALIAS = "preference_alias";
    public static final String PREFERENCE_APODERADO = "preference_apoderado";
    public static final String PREFERENCE_ENVIRONMENT = "preference_environment";
    public static final String PREFERENCE_OLD_LOGIN = "preference_old_login";
    public static final String PROVINCE = "province";
    public static final String REGEX_ALPHANUMERIC = "^[a-zA-Z0-9]*$";
    public static final String REGEX_ALPHANUMERIC_CAPS = "^[A-Z0-9]*$";
    public static final String REGEX_DATE = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
    public static final String REGEX_NUMERIC = "^\\d+$";
    public static final String SCREEN_DESTINATION = "screenDestination";
    public static final String SEARCHER_COURT_SCREEN = "searcherCourtScreen";
    public static final int SEARCH_EXPEDIENT_REQUEST_CODE = 1002;
    public static final String SEARCH_FILES_SCREEN = "searchFilesScreen";
    public static final int SEARCH_MOVEMENTS_REQUEST_CODE = 1000;
    public static final int SEARCH_PETITIONS_REQUEST_CODE = 1001;
    public static final String SELECTION_VALUE = "selectionValue";
    public static final String SHARED_PREFERENCES_LOGIN = "loginPreferencesCrypt";
    public static final String SITUATION_VALUE = "situationValue";
    public static final String STATE_VALUE = "stateValue";
    public static final String TOKEN_TIMEOUT = "Error al validar el token, El token ha expirado";
    public static final String USER_DETAIL = "user_detail";
    public static final String USER_NAME = "userName";

    public enum ResultResponse {
        EXITO,
        ERROR,
        AVISO,
        CONFIRMACION
    }

    public enum ConstantesRealizarLogonLA {
        SERVICIO_COMERCIABLE_DEFAULT("AA"),
        CANAL_MARCO(UserDTO.USERTYPE_EMPRESAS),
        EMPRESA("0049"),
        NAMESPACE("http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1/"),
        NOMBRE_SERVICIO("realizarLogon_LA"),
        FACADE("ACEMPMOVContratos"),
        USUARIO("ANTICIPOS11");
        
        private String valor;

        private ConstantesRealizarLogonLA(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesLogin_TokenJZG {
        NAMESPACE("http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"),
        NOMBRE_SERVICIO("wss:obtenerTokenSSOProfesionales");
        
        private String valor;

        private ConstantesLogin_TokenJZG(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesBuscarExpediente_LS {
        NAMESPACE("http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"),
        NOMBRE_SERVICIO("sup:buscarExpedientes");
        
        private String valor;

        private ConstantesBuscarExpediente_LS(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesBuscarPeticion_LS {
        NAMESPACE("http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"),
        NOMBRE_SERVICIO("sup:buscarPeticionesAcceso");
        
        private String valor;

        private ConstantesBuscarPeticion_LS(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesBuscarDetalleExpediente_LS {
        NAMESPACE("http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"),
        NOMBRE_SERVICIO("sup:detalleExpediente");
        
        private String valor;

        private ConstantesBuscarDetalleExpediente_LS(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesSolicitudAcceso_LS {
        NAMESPACE("http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"),
        NOMBRE_SERVICIO("sup:solicitudAcceso");
        
        private String valor;

        private ConstantesSolicitudAcceso_LS(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesPeticionesAcceso {
        NAMESPACE("http://www.imcs.es/cdcj-wssupernet-mobile/WSSupernetMobile/"),
        NOMBRE_SERVICIO("sup:buscarPeticionesAcceso");
        
        private String valor;

        private ConstantesPeticionesAcceso(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesLoginAlias {
        NAMESPACE("http://www.isban.es/webservices/TECHNICAL_FACADES/Security/F_facseg_security/internet/loginServicesNSegSAN/v1"),
        NOMBRE_SERVICIO("v1:authenticateCredential"),
        FACADE("loginServicesNSegSAN");
        
        private String valor;

        private ConstantesLoginAlias(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ConstantesLoginDocumento {
        NAMESPACE("http://www.isban.es/webservices/TECHNICAL_FACADES/Security/F_facseg_security/internet/loginServicesNSegSAN/v1"),
        NOMBRE_SERVICIO("v1:authenticateCredential"),
        FACADE("loginServicesNSegSAN");
        
        private String valor;

        private ConstantesLoginDocumento(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }

    public enum ServiciosComerciales {
        DEFAULT("AA"),
        JUSTICIA("AJ");
        
        private String valor;

        private ServiciosComerciales(String valor2) {
            this.valor = valor2;
        }

        public String valor() {
            return this.valor;
        }
    }
}
