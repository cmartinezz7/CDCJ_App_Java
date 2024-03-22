package es.santander.justicia.minisJusticia.expedientes.manager;

import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import es.santander.justicia.minisJusticia.expedientes.services.DetalleExpedienteSoapService;
import es.santander.justicia.minisJusticia.expedientes.services.ExpedientesSoapService;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExpedientesManager {
    private static ExpedientesManager instance;

    public static synchronized ExpedientesManager getInstance() {
        ExpedientesManager expedientesManager;
        synchronized (ExpedientesManager.class) {
            if (instance == null) {
                instance = new ExpedientesManager();
            }
            expedientesManager = instance;
        }
        return expedientesManager;
    }

    public ArrayList<ExpedienteDTO> recuperarExpedientes() {
        ArrayList<ExpedienteDTO> misExpedientes = new ExpedientesSoapService().getExpedientes();
        if (misExpedientes != null) {
            getInstance().setExpedientes(misExpedientes);
        }
        return misExpedientes;
    }

    /* Debug info: failed to restart local var, previous not found, register: 2 */
    public synchronized ExpedienteDTO recuperarDetalleExpediente(ExpedienteDTO expedienteDTO) {
        if (expedienteDTO != null) {
            if (!expedienteDTO.isDetail()) {
                expedienteDTO = new DetalleExpedienteSoapService().getDetalleExpediente(expedienteDTO);
            }
        }
        return expedienteDTO;
    }

    public ExpedienteDTO findExpedienteByNumExp(String numExp) {
        Iterator<ExpedienteDTO> it = LoginManager.getInstance().getUser().getExpedientes().iterator();
        while (it.hasNext()) {
            ExpedienteDTO expedienteDTO = it.next();
            if (expedienteDTO.getCodExpediente().equals(numExp)) {
                return expedienteDTO;
            }
        }
        return null;
    }

    public List<ExpedienteDTO> getExpedientes() {
        if (LoginManager.getInstance().getUser() != null) {
            return LoginManager.getInstance().getUser().getExpedientes();
        }
        return null;
    }

    public void setExpedientes(ArrayList<ExpedienteDTO> expedientes) {
        if (LoginManager.getInstance().getUser() != null) {
            LoginManager.getInstance().getUser().setExpedientes(expedientes);
        }
    }
}
