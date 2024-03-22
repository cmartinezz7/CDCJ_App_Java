package es.santander.justicia.soap.service.login;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosCabeceraRealizarLogonParams implements KvmSerializable {
    private IdiomaRealizarLogonPrams idioma;

    public DatosCabeceraRealizarLogonParams() {
    }

    public DatosCabeceraRealizarLogonParams(IdiomaRealizarLogonPrams idioma2) {
        this.idioma = idioma2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.idioma;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.idioma = (IdiomaRealizarLogonPrams) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "idioma";
        }
    }
}
