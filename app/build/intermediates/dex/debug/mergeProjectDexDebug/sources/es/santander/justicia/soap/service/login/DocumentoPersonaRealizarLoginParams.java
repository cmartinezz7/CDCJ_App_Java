package es.santander.justicia.soap.service.login;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DocumentoPersonaRealizarLoginParams implements KvmSerializable {
    private String CODIGO_DE_DOCUMENTO;
    private String TIPO_DOCUMENTO_OFIC;

    public DocumentoPersonaRealizarLoginParams() {
    }

    public DocumentoPersonaRealizarLoginParams(String TIPO_DOCUMENTO_OFIC2, String CODIGO_DE_DOCUMENTO2) {
        this.TIPO_DOCUMENTO_OFIC = TIPO_DOCUMENTO_OFIC2;
        this.CODIGO_DE_DOCUMENTO = CODIGO_DE_DOCUMENTO2;
    }

    public void setTIPO_DOCUMENTO_OFIC(String TIPO_DOCUMENTO_OFIC2) {
        this.TIPO_DOCUMENTO_OFIC = TIPO_DOCUMENTO_OFIC2;
    }

    public void setCODIGO_DE_DOCUMENTO(String CODIGO_DE_DOCUMENTO2) {
        this.CODIGO_DE_DOCUMENTO = CODIGO_DE_DOCUMENTO2;
    }

    public String getTIPO_DOCUMENTO_OFIC() {
        return this.TIPO_DOCUMENTO_OFIC;
    }

    public String getCODIGO_DE_DOCUMENTO() {
        return this.CODIGO_DE_DOCUMENTO;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.TIPO_DOCUMENTO_OFIC;
        }
        if (index != 1) {
            return null;
        }
        return this.CODIGO_DE_DOCUMENTO;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.TIPO_DOCUMENTO_OFIC = (String) value;
        } else if (index != 1) {
            return;
        }
        this.CODIGO_DE_DOCUMENTO = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "TIPO_DOCUMENTO_OFIC";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "CODIGO_DE_DOCUMENTO";
        }
    }
}
