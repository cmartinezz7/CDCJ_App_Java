package es.santander.justicia.minisJusticia.models.requests.contratos;

import org.simpleframework.xml.Element;

public class ContratoEntradaDetail {
   @Element(
      name = "indListaRepos",
      required = false
   )
   private String indListaRepos;
   @Element(
      name = "aliasUsuConexion",
      required = false
   )
   private String aliasUsuConexion;
   @Element(
      name = "indApoderadoDelegado",
      required = false
   )
   private String indApoderadoDelegado;
   @Element(
      name = "datosRepos",
      required = false
   )
   private ContratoDatosRepo datosRepos;
   @Element(
      name = "token",
      required = false
   )
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

   public void setIndListaRepos(String indListaRepos) {
      this.indListaRepos = indListaRepos;
   }

   public void setAliasUsuConexion(String aliasUsuConexion) {
      this.aliasUsuConexion = aliasUsuConexion;
   }

   public void setIndApoderadoDelegado(String indApoderadoDelegado) {
      this.indApoderadoDelegado = indApoderadoDelegado;
   }

   public void setDatosRepos(ContratoDatosRepo datosRepos) {
      this.datosRepos = datosRepos;
   }

   public void setToken(String token) {
      this.token = token;
   }
}
