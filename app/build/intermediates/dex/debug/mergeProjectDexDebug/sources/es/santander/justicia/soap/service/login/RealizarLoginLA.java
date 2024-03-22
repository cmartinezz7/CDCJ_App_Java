package es.santander.justicia.soap.service.login;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class RealizarLoginLA implements KvmSerializable {
    private EntradaRealizarLoginParams entrada;

    public RealizarLoginLA() {
    }

    public RealizarLoginLA(EntradaRealizarLoginParams entrada2) {
        this.entrada = entrada2;
    }

    public EntradaRealizarLoginParams getEntrada() {
        return this.entrada;
    }

    public void setEntrada(EntradaRealizarLoginParams entrada2) {
        this.entrada = entrada2;
    }

    public Object getProperty(int index) {
        if (index != 0) {
            return null;
        }
        return this.entrada;
    }

    public int getPropertyCount() {
        return 1;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.entrada = (EntradaRealizarLoginParams) value;
        }
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.OBJECT_CLASS;
            info.name = "entrada";
        }
    }
}
