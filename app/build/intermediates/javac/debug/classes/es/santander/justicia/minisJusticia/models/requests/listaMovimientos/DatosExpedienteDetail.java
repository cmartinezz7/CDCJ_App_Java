package es.santander.justicia.minisJusticia.models.requests.listaMovimientos;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import es.santander.justicia.minisJusticia.models.requests.listaMovimientos.DatosExpedienteDetail.1;
import es.santander.justicia.utils.CommonUtils;
import org.simpleframework.xml.Element;

public class DatosExpedienteDetail implements Parcelable {
   @Element(
      name = "janoapex",
      required = false
   )
   private String janoapex;
   @Element(
      name = "jnumexp",
      required = false
   )
   private String jnumexp;
   @Element(
      name = "jproced",
      required = false
   )
   private String jproced;
   @Element(
      name = "juzga",
      required = false
   )
   private String juzga;
   @Element(
      name = "juzgori",
      required = false
   )
   private String juzgori;
   private String primov;
   private String ultmov;
   private String numComplete;
   public static final Creator<DatosExpedienteDetail> CREATOR = new 1();

   public DatosExpedienteDetail(String janoapex, String jnumexp, String jproced, String juzga, String juzgori, String primov, String ultmov) {
      this.janoapex = janoapex;
      this.jnumexp = jnumexp;
      this.jproced = jproced;
      this.juzga = juzga;
      this.juzgori = juzgori;
      this.primov = primov;
      this.ultmov = ultmov;
      this.numComplete = CommonUtils.formatExpedient(juzga, juzgori, jproced, jnumexp, janoapex);
   }

   public DatosExpedienteDetail(String janoapex, String jnumexp, String jproced, String juzga, String juzgori) {
      this.janoapex = janoapex;
      this.jnumexp = jnumexp;
      this.jproced = jproced;
      this.juzga = juzga;
      this.juzgori = juzgori;
      this.numComplete = CommonUtils.formatExpedient(juzga, juzgori, jproced, jnumexp, janoapex);
   }

   protected DatosExpedienteDetail(Parcel in) {
      this.janoapex = in.readString();
      this.jnumexp = in.readString();
      this.jproced = in.readString();
      this.juzga = in.readString();
      this.juzgori = in.readString();
      this.primov = in.readString();
      this.ultmov = in.readString();
      this.numComplete = in.readString();
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.janoapex);
      dest.writeString(this.jnumexp);
      dest.writeString(this.jproced);
      dest.writeString(this.juzga);
      dest.writeString(this.juzgori);
      dest.writeString(this.primov);
      dest.writeString(this.ultmov);
      dest.writeString(this.numComplete);
   }

   public String getJanoapex() {
      return this.janoapex;
   }

   public String getJnumexp() {
      return this.jnumexp;
   }

   public String getJproced() {
      return this.jproced;
   }

   public String getJuzga() {
      return this.juzga;
   }

   public String getJuzgori() {
      return this.juzgori;
   }

   public String getNumComplete() {
      return this.numComplete;
   }

   public String getPriMov() {
      return this.primov;
   }

   public String getUltMov() {
      return this.ultmov;
   }
}
