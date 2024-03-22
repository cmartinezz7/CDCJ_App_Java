package es.santander.justicia.sharedService;

import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import java.util.List;

public class petitionService {
    private static petitionService instance;
    private List<PeticionDTO> peticionDTO;

    private petitionService() {
    }

    public void setPeticionDTO(List<PeticionDTO> peticionDTO2) {
        this.peticionDTO = peticionDTO2;
    }

    public List<PeticionDTO> getPeticionDTO() {
        return this.peticionDTO;
    }

    public static synchronized petitionService getInstance() {
        petitionService petitionservice;
        synchronized (petitionService.class) {
            if (instance == null) {
                instance = new petitionService();
            }
            petitionservice = instance;
        }
        return petitionservice;
    }
}
