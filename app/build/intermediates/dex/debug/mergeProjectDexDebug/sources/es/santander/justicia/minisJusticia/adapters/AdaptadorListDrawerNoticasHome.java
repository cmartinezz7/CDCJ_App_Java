package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.dto.NoticiaDTO;
import java.util.List;

public class AdaptadorListDrawerNoticasHome extends ArrayAdapter<NoticiaDTO> {
    private final Context context;
    private final List<NoticiaDTO> values;

    public AdaptadorListDrawerNoticasHome(Context context2, List<NoticiaDTO> values2) {
        super(context2, 0, values2);
        this.context = context2;
        this.values = values2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.row_noticias_home, parent, false);
        ((TextView) rowView.findViewById(R.id.tv_titulo_noticia)).setText(this.values.get(position).getTituloNoticia());
        ((TextView) rowView.findViewById(R.id.tv_subtitulo_noticia)).setText(this.values.get(position).getAsunto());
        ((TextView) rowView.findViewById(R.id.tv_noticia)).setText(this.values.get(position).getNoticia());
        return rowView;
    }
}
