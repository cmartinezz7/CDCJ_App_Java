package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.DateUtils;
import java.util.ArrayList;
import java.util.Locale;

public class AdaptadorListPetitions extends ArrayAdapter<PeticionDTO> {
    public String barra;
    private final Context context;
    public ContextCompat contextCompact;
    private ArrayList<PeticionDTO> listaPeticiones;

    public AdaptadorListPetitions(Context context2, ArrayList<PeticionDTO> listaPeticiones2) {
        super(context2, 0, listaPeticiones2);
        this.context = context2;
        this.listaPeticiones = listaPeticiones2;
    }

    static class ViewHolder {
        public ImageView imicon;
        public TextView tvdatefecacept;
        public TextView tvdatefecpetic;
        public TextView tvnumPeticion;
        public TextView tvsituacionPeticion;

        ViewHolder() {
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_peticion, parent, false);
            holder = new ViewHolder();
            holder.tvnumPeticion = (TextView) convertView.findViewById(R.id.tv_numPeticion);
            holder.tvdatefecacept = (TextView) convertView.findViewById(R.id.tv_datefecacept);
            holder.tvdatefecpetic = (TextView) convertView.findViewById(R.id.tv_datefecpetic);
            holder.tvsituacionPeticion = (TextView) convertView.findViewById(R.id.tv_situacionPeticion);
            holder.imicon = (ImageView) convertView.findViewById(R.id.imPetIcon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        PeticionDTO peticionDTO = this.listaPeticiones.get(position);
        holder.tvnumPeticion.setText(CommonUtils.getProceedingFormatted(peticionDTO.getCodExpediente()));
        holder.tvdatefecacept.setText(DateUtils.formatDate(peticionDTO.getFecacept()));
        holder.tvdatefecpetic.setText(DateUtils.formatDate(peticionDTO.getFecpetic()));
        holder.tvsituacionPeticion.setText(peticionDTO.getJestactu());
        ImageView imicon = (ImageView) convertView.findViewById(R.id.imPetIcon);
        this.barra = holder.tvsituacionPeticion.getText().toString();
        RelativeLayout RLbarra = (RelativeLayout) convertView.findViewById(R.id.estadoBar);
        Drawable background = ContextCompat.getDrawable(this.context, R.drawable.white_bc_top_bottom_left_rounded);
        if (this.barra.toUpperCase(Locale.ENGLISH).equals(Constants.EXP_STATE_ACCEPT)) {
            background.setColorFilter(ContextCompat.getColor(this.context, R.color.expOperativo), PorterDuff.Mode.SRC_IN);
            imicon.setImageResource(R.drawable.ic_alta_v2);
            holder.tvsituacionPeticion.setText("ACEPTADA");
        } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("DE")) {
            background.setColorFilter(ContextCompat.getColor(this.context, R.color.lista_movimientos_rojo), PorterDuff.Mode.SRC_IN);
            imicon.setImageResource(R.drawable.ic_anulacion_v2);
            holder.tvsituacionPeticion.setText("DENEGADA");
        } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("BA")) {
            background.setColorFilter(ContextCompat.getColor(this.context, R.color.text_color), PorterDuff.Mode.SRC_IN);
            imicon.setImageResource(R.drawable.ic_anulacion_v2);
            holder.tvsituacionPeticion.setText("BAJA");
        } else if (this.barra.toUpperCase(Locale.ENGLISH).equals("PE")) {
            background.setColorFilter(ContextCompat.getColor(this.context, R.color.lista_movimientos_amarillo), PorterDuff.Mode.SRC_IN);
            imicon.setImageResource(R.drawable.ic_pendiente_v2);
            holder.tvsituacionPeticion.setText("PENDIENTE");
        }
        imicon.setColorFilter(ContextCompat.getColor(this.context, 2131100979), PorterDuff.Mode.SRC_IN);
        RLbarra.setBackground(background);
        RLbarra.invalidate();
        return convertView;
    }
}
