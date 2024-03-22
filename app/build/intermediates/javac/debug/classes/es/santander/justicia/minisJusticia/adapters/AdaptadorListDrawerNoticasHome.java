package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.dto.NoticiaDTO;
import java.util.List;

public class AdaptadorListDrawerNoticasHome extends ArrayAdapter<NoticiaDTO> {
   private final Context context;
   private final List<NoticiaDTO> values;

   public AdaptadorListDrawerNoticasHome(Context context, List<NoticiaDTO> values) {
      super(context, 0, values);
      this.context = context;
      this.values = values;
   }

   public View getView(int position, View convertView, ViewGroup parent) {
      LayoutInflater inflater = (LayoutInflater)this.context.getSystemService("layout_inflater");
      View rowView = inflater.inflate(2131558735, parent, false);
      TextView tvTituloNoticia = (TextView)rowView.findViewById(2131363081);
      tvTituloNoticia.setText(((NoticiaDTO)this.values.get(position)).getTituloNoticia());
      TextView tvSubtituloNoticia = (TextView)rowView.findViewById(2131363062);
      tvSubtituloNoticia.setText(((NoticiaDTO)this.values.get(position)).getAsunto());
      TextView tvNoticia = (TextView)rowView.findViewById(2131363027);
      tvNoticia.setText(((NoticiaDTO)this.values.get(position)).getNoticia());
      return rowView;
   }
}
