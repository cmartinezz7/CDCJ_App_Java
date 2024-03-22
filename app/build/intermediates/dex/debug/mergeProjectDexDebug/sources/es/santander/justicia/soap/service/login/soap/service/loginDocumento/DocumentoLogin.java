package es.santander.justicia.soap.service.login.soap.service.loginDocumento;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DocumentoLogin implements KvmSerializable {
    private String codigo;
    private String tipo;

    public DocumentoLogin() {
    }

    public DocumentoLogin(String codigo2, String tipo2) {
        this.codigo = codigo2;
        this.tipo = tipo2;
    }

    public void setCodigo(String codigo2) {
        this.codigo = codigo2;
    }

    public void setTipo(String tipo2) {
        this.tipo = tipo2;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.codigo;
        }
        if (index != 1) {
            return null;
        }
        return this.tipo;
    }

    public int getPropertyCount() {
        return 2;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.codigo = (String) value;
        } else if (index != 1) {
            return;
        }
        this.tipo = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "CODIGO_DOCUM_PERSONA_CORP";
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "TIPO_DOCUM_PERSONA_CORP";
        }
    }
}
