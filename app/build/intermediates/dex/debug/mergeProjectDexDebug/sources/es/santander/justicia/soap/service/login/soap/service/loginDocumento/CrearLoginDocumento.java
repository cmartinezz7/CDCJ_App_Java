package es.santander.justicia.soap.service.login.soap.service.loginDocumento;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class CrearLoginDocumento implements KvmSerializable {
    private DocumentoLogin documentoLogin;
    private String password;

    public CrearLoginDocumento() {
    }

    public CrearLoginDocumento(DocumentoLogin documentoLogin2, String password2) {
        this.documentoLogin = documentoLogin2;
        this.password = password2;
    }

    public void setDocumentoLogin(DocumentoLogin documentoLogin2) {
        this.documentoLogin = documentoLogin2;
    }

    public void setPassword(String password2) {
        this.password = password2;
    }

    public DocumentoLogin getDocumentoLogin() {
        return this.documentoLogin;
    }

    public String getPassword() {
        return this.password;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.documentoLogin;
        }
        if (index != 1) {
            return null;
        }
        return this.password;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.documentoLogin = (DocumentoLogin) value;
        } else if (index != 1) {
            return;
        }
        this.password = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "documento";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "password";
        }
    }
}
