package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratoDatosRepo {
    @Element(name = "contrato_repos", required = false)
    private ContratoContratoRepo contratorepo;
    @Element(name = "usuarioRacf_repos", required = false)
    private String usuarioRacfRepos;

    public ContratoContratoRepo getContratorepo() {
        return this.contratorepo;
    }

    public String getUsuarioRacfRepos() {
        return this.usuarioRacfRepos;
    }

    public void setContratorepo(ContratoContratoRepo contratorepo2) {
        this.contratorepo = contratorepo2;
    }

    public void setUsuarioRacfRepos(String usuarioRacfRepos2) {
        this.usuarioRacfRepos = usuarioRacfRepos2;
    }
}
