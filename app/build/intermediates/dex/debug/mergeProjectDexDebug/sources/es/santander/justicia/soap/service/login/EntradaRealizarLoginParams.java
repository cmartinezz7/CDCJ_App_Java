package es.santander.justicia.soap.service.login;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class EntradaRealizarLoginParams implements KvmSerializable {
    private String alias;
    private DocumentoPersonaRealizarLoginParams documentoPersona;
    private String password;
    private String servicioComerciable;

    public EntradaRealizarLoginParams() {
    }

    public EntradaRealizarLoginParams(String alias2, String password2, String servicioComerciable2, DocumentoPersonaRealizarLoginParams documentoPersona2) {
        this.alias = alias2;
        this.password = password2;
        this.servicioComerciable = servicioComerciable2;
        this.documentoPersona = documentoPersona2;
    }

    public void setAlias(String alias2) {
        this.alias = alias2;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public void setDocumentoPersona(DocumentoPersonaRealizarLoginParams documentoPersona2) {
        this.documentoPersona = documentoPersona2;
    }

    public String getAlias() {
        return this.alias;
    }

    public String getPassword() {
        return this.password;
    }

    public DocumentoPersonaRealizarLoginParams getDocumentoPersona() {
        return this.documentoPersona;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.alias;
        }
        if (index == 1) {
            return this.password;
        }
        if (index == 2) {
            return this.servicioComerciable;
        }
        if (index != 3) {
            return null;
        }
        return this.documentoPersona;
    }

    public int getPropertyCount() {
        return 4;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.alias = (String) value;
        } else if (index != 1) {
            if (index != 2) {
                if (index != 3) {
                    return;
                }
                this.documentoPersona = (DocumentoPersonaRealizarLoginParams) value;
            }
            this.servicioComerciable = (String) value;
            this.documentoPersona = (DocumentoPersonaRealizarLoginParams) value;
        }
        this.password = (String) value;
        this.servicioComerciable = (String) value;
        this.documentoPersona = (DocumentoPersonaRealizarLoginParams) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "alias";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "password";
        } else if (index == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "servicioComerciable";
        } else if (index == 3) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "documentoPersona";
        }
    }
}
