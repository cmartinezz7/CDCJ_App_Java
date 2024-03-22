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
      if (instance == null) {
         instance = new ExpedientesManager();
      }

      return instance;
   }

   public ArrayList<ExpedienteDTO> recuperarExpedientes() {
      ExpedientesSoapService expedientesSoapService = new ExpedientesSoapService();
      ArrayList<ExpedienteDTO> misExpedientes = expedientesSoapService.getExpedientes();
      if (misExpedientes != null) {
         getInstance().setExpedientes(misExpedientes);
      }

      return misExpedientes;
   }

   public synchronized ExpedienteDTO recuperarDetalleExpediente(ExpedienteDTO expedienteDTO) {
      if (expedienteDTO != null && !expedienteDTO.isDetail()) {
         DetalleExpedienteSoapService expedientesSoapService = new DetalleExpedienteSoapService();
         expedienteDTO = expedientesSoapService.getDetalleExpediente(expedienteDTO);
      }

      return expedienteDTO;
   }

   public ExpedienteDTO findExpedienteByNumExp(String numExp) {
      ArrayList<ExpedienteDTO> expedientes = LoginManager.getInstance().getUser().getExpedientes();
      Iterator var3 = expedientes.iterator();

      ExpedienteDTO expedienteDTO;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         expedienteDTO = (ExpedienteDTO)var3.next();
      } while(!expedienteDTO.getCodExpediente().equals(numExp));

      return expedienteDTO;
   }

   public List<ExpedienteDTO> getExpedientes() {
      return LoginManager.getInstance().getUser() != null ? LoginManager.getInstance().getUser().getExpedientes() : null;
   }

   public void setExpedientes(ArrayList<ExpedienteDTO> expedientes) {
      if (LoginManager.getInstance().getUser() != null) {
         LoginManager.getInstance().getUser().setExpedientes(expedientes);
      }

   }
}
