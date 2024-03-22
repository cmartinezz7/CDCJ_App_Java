package es.santander.justicia.soap.service.login.soap.service.DetalleExpedientes.ParamsRequestDetalleExpediente;

import es.santander.justicia.utils.Constants;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class DatosExpediente implements KvmSerializable {
    private String janoapex;
    private String jnumexp;
    private String jproced;
    private String juzga;
    private String juzgori;

    public DatosExpediente(String juzga2, String juzgori2, String jnumexp2, String jproced2, String janoapex2) {
        this.juzga = juzga2;
        this.juzgori = juzgori2;
        this.jnumexp = jnumexp2;
        this.jproced = jproced2;
        this.janoapex = janoapex2;
    }

    public DatosExpediente(String juzga2) {
        this.juzga = juzga2;
    }

    public Object getProperty(int index) {
        if (index == 0) {
            return this.juzga;
        }
        if (index == 1) {
            return this.juzgori;
        }
        if (index == 2) {
            return this.jnumexp;
        }
        if (index == 3) {
            return this.jproced;
        }
        if (index != 4) {
            return null;
        }
        return this.janoapex;
    }

    public int getPropertyCount() {
        return 5;
    }

    public void setProperty(int index, Object value) {
        if (index == 0) {
            this.juzga = (String) value;
        } else if (index != 1) {
            if (index != 2) {
                if (index != 3) {
                    if (index != 4) {
                        return;
                    }
                    this.janoapex = (String) value;
                }
                this.jproced = (String) value;
                this.janoapex = (String) value;
            }
            this.jnumexp = (String) value;
            this.jproced = (String) value;
            this.janoapex = (String) value;
        }
        this.juzgori = (String) value;
        this.jnumexp = (String) value;
        this.jproced = (String) value;
        this.janoapex = (String) value;
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        if (index == 0) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = Constants.EXPEDIENT_JUZGA;
        } else if (index == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = Constants.EXPEDIENT_JUZGORI;
        } else if (index == 2) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = Constants.EXPEDIENT_JNUMEXP;
        } else if (index == 3) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = Constants.EXPEDIENT_JPROCED;
        } else if (index == 4) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = Constants.EXPEDIENT_JANOAPEX;
        }
    }
}
