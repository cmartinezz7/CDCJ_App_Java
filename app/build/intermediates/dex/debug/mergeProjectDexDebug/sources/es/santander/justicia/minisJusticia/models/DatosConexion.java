package es.santander.justicia.minisJusticia.models;

import es.santander.justicia.minisJusticia.common.dto.UserDTO;
import org.simpleframework.xml.Element;

public class DatosConexion {
    @Element(name = "canal", required = false)
    private String canal;
    @Element(name = "canalMarco", required = false)
    private String canalMarco = UserDTO.USERTYPE_EMPRESAS;
    @Element(name = "empresa", required = false)
    private String empresa = "0049";

    public String getCanalMarco() {
        return this.canalMarco;
    }

    public String getEmpresa() {
        return this.empresa;
    }
}
