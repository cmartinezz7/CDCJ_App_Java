package es.santander.justicia.minisJusticia.models.responses.authjuzados;

import java.util.ArrayList;
import org.simpleframework.xml.ElementList;

public class AutorizacionesUsuarioReturn {
    @ElementList(name = "return")
    private ArrayList<AutorizacionesUsuario> autorizacionesUsuarios;

    public ArrayList<AutorizacionesUsuario> autorizacionesUsuarios() {
        return this.autorizacionesUsuarios;
    }
}
