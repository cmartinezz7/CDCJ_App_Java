package es.santander.justicia.minisJusticia.models.responses.contratos;

import es.santander.justicia.minisJusticia.models.requests.contratos.ContratoDatosRepo;
import es.santander.justicia.minisJusticia.models.responses.InfoDetail;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ContratosMedhodResultDetail {
    @Element(name = "aliasUsuConexion", required = false)
    private String aliasUsuConexion;
    @ElementList(name = "listaContratos", required = false)
    private ArrayList<ContratoDetail> contratoDetails;
    @Element(name = "datosRepos", required = false)
    private ContratoDatosRepo datosRepo;
    @Element(name = "info", required = false)
    private InfoDetail infoDetail;
    @Element(name = "token", required = false)
    private String token;

    public InfoDetail getInfoDetail() {
        return this.infoDetail;
    }

    public String getAliasUsuConexion() {
        return this.aliasUsuConexion;
    }

    public ArrayList<ContratoDetail> getContratoDetails() {
        return this.contratoDetails;
    }

    public ContratoDatosRepo getDatosRepo() {
        return this.datosRepo;
    }

    public String getToken() {
        return this.token;
    }
}
