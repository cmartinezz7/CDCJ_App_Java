package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.DateUtils;
import java.util.ArrayList;
import java.util.Locale;

public class AdaptadorListPetitions extends ArrayAdapter<PeticionDTO> {
   private final Context context;
   private ArrayList<PeticionDTO> listaPeticiones;
   public String barra;
   public ContextCompat contextCompact;

   public AdaptadorListPetitions(Context context, ArrayList<PeticionDTO> listaPeticiones) {
      super(context, 0, listaPeticiones);
      this.context = context;
      this.listaPeticiones = listaPeticiones;
   }

   public View getView(int position, View convertView, ViewGroup parent) {
      LayoutInflater inflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
      es.santander.justicia.minisJusticia.adapters.AdaptadorListPetitions.ViewHolder holder;
      if (convertView == null) {
         convertView = inflater.inflate(2131558737, parent, false);
         holder = new es.santander.justicia.minisJusticia.adapters.AdaptadorListPetitions.ViewHolder();
         holder.tvnumPeticion = (TextView)convertView.findViewById(2131363029);
         holder.tvdatefecacept = (TextView)convertView.findViewById(2131363009);
         holder.tvdatefecpetic = (TextView)convertView.findViewById(2131363010);
         holder.tvsituacionPeticion = (TextView)convertView.findViewById(2131363054);
         holder.imicon = (ImageView)convertView.findViewById(2131362285);
         convertView.setTag(holder);
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.AdaptadorListPetitions.ViewHolder)convertView.getTag();
      }

      PeticionDTO peticionDTO = (PeticionDTO)this.listaPeticiones.get(position);
      holder.tvnumPeticion.setText(CommonUtils.getProceedingFormatted(peticionDTO.getCodExpediente()));
      holder.tvdatefecacept.setText(DateUtils.formatDate(peticionDTO.getFecacept()));
      holder.tvdatefecpetic.setText(DateUtils.formatDate(peticionDTO.getFecpetic()));
      holder.tvsituacionPeticion.setText(peticionDTO.getJestactu());
      ImageView imicon = (ImageView)convertView.findViewById(2131362285);
      this.barra = holder.tvsituacionPeticion.getText().toString();
      RelativeLayout RLbarra = (RelativeLayout)convertView.findViewById(2131362143);
      Drawable background = ContextCompat.getDrawable(this.context, 2131231324);
      int currentStateColor = false;
      if (this.barra.toUpperCase(Locale.ENGLISH).equals("AL")) {
         background.setColorFilter(ContextCompat.getColor(this.context, 2131099965), Mode.SRC_IN);
         imicon.setImageResource(2131231009);
         holder.tvsituacionPeticion.setText("ACEPTADA");
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("DE")) {
         background.setColorFilter(ContextCompat.getColor(this.context, 2131100022), Mode.SRC_IN);
         imicon.setImageResource(2131231013);
         holder.tvsituacionPeticion.setText("DENEGADA");
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("BA")) {
         background.setColorFilter(ContextCompat.getColor(this.context, 2131100947), Mode.SRC_IN);
         imicon.setImageResource(2131231013);
         holder.tvsituacionPeticion.setText("BAJA");
      } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("PE")) {
         background.setColorFilter(ContextCompat.getColor(this.context, 2131100019), Mode.SRC_IN);
         imicon.setImageResource(2131231141);
         holder.tvsituacionPeticion.setText("PENDIENTE");
      }

      imicon.setColorFilter(ContextCompat.getColor(this.context, 2131100979), Mode.SRC_IN);
      RLbarra.setBackground(background);
      RLbarra.invalidate();
      return convertView;
   }
}
