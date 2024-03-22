package es.santander.justicia.minisJusticia.models.requests.operativas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(
   strict = false
)
public class OperativasGlobalArg0Detail {
   @Element(
      name = "anioApertura",
      required = false
   )
   private int anioApertura;
   @Element(
      name = "apellido1",
      required = false
   )
   private String apellido1;
   @Element(
      name = "apellido2",
      required = false
   )
   private String apellido2;
   @Element(
      name = "codCompletoExpediente",
      required = false
   )
   private String codCompletoExpediente;
   @Element(
      name = "codDocumento",
      required = false
   )
   private String codDocumento;
   @Element(
      name = "codEstadoActualExp",
      required = false
   )
   private String codEstadoActualExp;
   @Element(
      name = "codEstadoPeticion",
      required = false
   )
   private String codEstadoPeticion;
   @Element(
      name = "codJuzDest",
      required = false
   )
   private String codJuzDest;
   @Element(
      name = "codJuzOri",
      required = false
   )
   private String codJuzOri;
   @Element(
      name = "codMotivoSolicitud",
      required = false
   )
   private String codMotivoSolicitud;
   @Element(
      name = "codProced",
      required = false
   )
   private String codProced;
   @Element(
      name = "codTipoDocumento",
      required = false
   )
   private String codTipoDocumento;
   @Element(
      name = "codUsuarioAutoriza",
      required = false
   )
   private String codUsuarioAutoriza;
   @Element(
      name = "comentariosSecretario",
      required = false
   )
   private String comentariosSecretario;
   @Element(
      name = "contadorDeAccesos",
      required = false
   )
   private int contadorDeAccesos;
   @Element(
      name = "desEstadoActualExp",
      required = false
   )
   private String desEstadoActualExp;
   @Element(
      name = "desEstadoPeticion",
      required = false
   )
   private String desEstadoPeticion;
   @Element(
      name = "desMotivoSolicitud",
      required = false
   )
   private String desMotivoSolicitud;
   @Element(
      name = "fecDeLaPeticion",
      required = false
   )
   private String fecDeLaPeticion;
   @Element(
      name = "fecDeAceptacion",
      required = false
   )
   private String fecDeAceptacion;
   @Element(
      name = "fecDeBaja",
      required = false
   )
   private String fecDeBaja;
   @Element(
      name = "fecDeDenegacion",
      required = false
   )
   private String fecDeDenegacion;
   @Element(
      name = "nombre",
      required = false
   )
   private String nombre;
   @Element(
      name = "numExpediente",
      required = false
   )
   private String numExpediente;
   @Element(
      name = "reactivarPeticion",
      required = false
   )
   private String reactivarPeticion;
   @Element(
      name = "firma",
      required = false
   )
   private String firma;

   public int getAnioApertura() {
      return this.anioApertura;
   }

   public String getApellido1() {
      return this.apellido1;
   }

   public String getApellido2() {
      return this.apellido2;
   }

   public String getCodCompletoExpediente() {
      return this.codCompletoExpediente;
   }

   public String getCodDocumento() {
      return this.codDocumento;
   }

   public String getCodEstadoActualExp() {
      return this.codEstadoActualExp;
   }

   public String getCodEstadoPeticion() {
      return this.codEstadoPeticion;
   }

   public String getCodJuzDest() {
      return this.codJuzDest;
   }

   public String getCodJuzOri() {
      return this.codJuzOri;
   }

   public String getCodMotivoSolicitud() {
      return this.codMotivoSolicitud;
   }

   public String getCodProced() {
      return this.codProced;
   }

   public String getCodTipoDocumento() {
      return this.codTipoDocumento;
   }

   public String getCodUsuarioAutoriza() {
      return this.codUsuarioAutoriza;
   }

   public String getComentariosSecretario() {
      return this.comentariosSecretario;
   }

   public int getContadorDeAccesos() {
      return this.contadorDeAccesos;
   }

   public String getDesEstadoActualExp() {
      return this.desEstadoActualExp;
   }

   public String getDesEstadoPeticion() {
      return this.desEstadoPeticion;
   }

   public String getDesMotivoSolicitud() {
      return this.desMotivoSolicitud;
   }

   public String getFecDeLaPeticion() {
      return this.fecDeLaPeticion;
   }

   public String getNombre() {
      return this.nombre;
   }

   public String getNumExpediente() {
      return this.numExpediente;
   }

   public String getReactivarPeticion() {
      return this.reactivarPeticion;
   }

   public String getFirma() {
      return this.firma;
   }

   public void setAnioApertura(int anioApertura) {
      this.anioApertura = anioApertura;
   }

   public void setApellido1(String apellido1) {
      this.apellido1 = apellido1;
   }

   public void setApellido2(String apellido2) {
      this.apellido2 = apellido2;
   }

   public void setCodCompletoExpediente(String codCompletoExpediente) {
      this.codCompletoExpediente = codCompletoExpediente;
   }

   public void setCodDocumento(String codDocumento) {
      this.codDocumento = codDocumento;
   }

   public void setCodEstadoActualExp(String codEstadoActualExp) {
      this.codEstadoActualExp = codEstadoActualExp;
   }

   public void setCodEstadoPeticion(String codEstadoPeticion) {
      this.codEstadoPeticion = codEstadoPeticion;
   }

   public void setCodJuzDest(String codJuzDest) {
      this.codJuzDest = codJuzDest;
   }

   public void setCodJuzOri(String codJuzOri) {
      this.codJuzOri = codJuzOri;
   }

   public void setCodMotivoSolicitud(String codMotivoSolicitud) {
      this.codMotivoSolicitud = codMotivoSolicitud;
   }

   public void setCodProced(String codProced) {
      this.codProced = codProced;
   }

   public void setCodTipoDocumento(String codTipoDocumento) {
      this.codTipoDocumento = codTipoDocumento;
   }

   public void setCodUsuarioAutoriza(String codUsuarioAutoriza) {
      this.codUsuarioAutoriza = codUsuarioAutoriza;
   }

   public void setComentariosSecretario(String comentariosSecretario) {
      this.comentariosSecretario = comentariosSecretario;
   }

   public void setContadorDeAccesos(int contadorDeAccesos) {
      this.contadorDeAccesos = contadorDeAccesos;
   }

   public void setDesEstadoActualExp(String desEstadoActualExp) {
      this.desEstadoActualExp = desEstadoActualExp;
   }

   public void setDesEstadoPeticion(String desEstadoPeticion) {
      this.desEstadoPeticion = desEstadoPeticion;
   }

   public void setDesMotivoSolicitud(String desMotivoSolicitud) {
      this.desMotivoSolicitud = desMotivoSolicitud;
   }

   public void setFecDeLaPeticion(String fecDeLaPeticion) {
      this.fecDeLaPeticion = fecDeLaPeticion;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setNumExpediente(String numExpediente) {
      this.numExpediente = numExpediente;
   }

   public void setReactivarPeticion(String reactivarPeticion) {
      this.reactivarPeticion = reactivarPeticion;
   }

   public void setFirma(String firma) {
      this.firma = firma;
   }

   public void setFecDeAceptacion(String fecDeAceptacion) {
      this.fecDeAceptacion = fecDeAceptacion;
   }

   public void setFecDeBaja(String fecDeBaja) {
      this.fecDeBaja = fecDeBaja;
   }

   public void setFecDeDenegacion(String fecDeDenegacion) {
      this.fecDeDenegacion = fecDeDenegacion;
   }
}
