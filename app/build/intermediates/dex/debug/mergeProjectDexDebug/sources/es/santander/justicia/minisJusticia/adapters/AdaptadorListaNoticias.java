package es.santander.justicia.minisJusticia.adapters;

import android.app.Activity;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import java.util.List;

public class AdaptadorListaNoticias extends BaseAdapter {
    public Activity activity;
    public List<NoticiaActualidadDTO> news;

    public AdaptadorListaNoticias(List<NoticiaActualidadDTO> news2, Activity activity2) {
        this.news = news2;
        this.activity = activity2;
    }

    public int getCount() {
        return this.news.size();
    }

    public Object getItem(int position) {
        return this.news.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public void notifyDataSetChanged() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias$ViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r4, android.view.View r5, android.view.ViewGroup r6) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0044
            android.app.Activity r0 = r3.activity
            java.lang.String r1 = "layout_inflater"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            r1 = 2131558736(0x7f0d0150, float:1.8742796E38)
            r2 = 0
            android.view.View r5 = r0.inflate(r1, r6, r2)
            es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias$ViewHolder r1 = new es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias$ViewHolder
            r1.<init>()
            r2 = 2131362988(0x7f0a04ac, float:1.8345772E38)
            android.view.View r2 = r5.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r1.tvTitle = r2
            r2 = 2131362336(0x7f0a0220, float:1.834445E38)
            android.view.View r2 = r5.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r1.image = r2
            r5.setTag(r1)
            int r2 = r4 % 2
            if (r2 != 0) goto L_0x003d
            r2 = 2131100979(0x7f060533, float:1.7814355E38)
            r5.setBackgroundResource(r2)
            goto L_0x0043
        L_0x003d:
            r2 = 2131099983(0x7f06014f, float:1.7812335E38)
            r5.setBackgroundResource(r2)
        L_0x0043:
            goto L_0x004b
        L_0x0044:
            java.lang.Object r0 = r5.getTag()
            r1 = r0
            es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias$ViewHolder r1 = (es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias.ViewHolder) r1
        L_0x004b:
            android.widget.TextView r0 = r1.tvTitle
            java.util.List<es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO> r2 = r3.news
            java.lang.Object r2 = r2.get(r4)
            es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO r2 = (es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO) r2
            java.lang.String r2 = r2.getTituloNoticia()
            r0.setText(r2)
            android.app.Activity r0 = r3.activity
            android.content.res.AssetManager r0 = r0.getAssets()
            java.lang.String r2 = "FiraSans-Medium.ttf"
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromAsset(r0, r2)
            android.widget.TextView r2 = r1.tvTitle
            r2.setTypeface(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    static class ViewHolder {
        public ImageView image;
        public TextView tvTitle;

        ViewHolder() {
        }
    }
}
