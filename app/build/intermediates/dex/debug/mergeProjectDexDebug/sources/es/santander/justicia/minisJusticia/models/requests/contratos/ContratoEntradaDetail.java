package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratoEntradaDetail {
    @Element(name = "aliasUsuConexion", required = false)
    private String aliasUsuConexion;
    @Element(name = "datosRepos", required = false)
    private ContratoDatosRepo datosRepos;
    @Element(name = "indApoderadoDelegado", required = false)
    private String indApoderadoDelegado;
    @Element(name = "indListaRepos", required = false)
    private String indListaRepos;
    @Element(name = "token", required = false)
    private String token;

    public String getIndListaRepos() {
        return this.indListaRepos;
    }

    public String getAliasUsuConexion() {
        return this.aliasUsuConexion;
    }

    public String getIndApoderadoDelegado() {
        return this.indApoderadoDelegado;
    }

    public ContratoDatosRepo getDatosRepos() {
        return this.datosRepos;
    }

    public String getToken() {
        return this.token;
    }

    public void setIndListaRepos(String indListaRepos2) {
        this.indListaRepos = indListaRepos2;
    }

    public void setAliasUsuConexion(String aliasUsuConexion2) {
        this.aliasUsuConexion = aliasUsuConexion2;
    }

    public void setIndApoderadoDelegado(String indApoderadoDelegado2) {
        this.indApoderadoDelegado = indApoderadoDelegado2;
    }

    public void setDatosRepos(ContratoDatosRepo datosRepos2) {
        this.datosRepos = datosRepos2;
    }

    public void setToken(String token2) {
        this.token = token2;
    }
}
