package es.santander.justicia.minisJusticia.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import java.util.List;

public class AdaptadorListaNoticias extends BaseAdapter {
   public List<NoticiaActualidadDTO> news;
   public Activity activity;

   public AdaptadorListaNoticias(List<NoticiaActualidadDTO> news, Activity activity) {
      this.news = news;
      this.activity = activity;
   }

   public int getCount() {
      return this.news.size();
   }

   public Object getItem(int position) {
      return this.news.get(position);
   }

   public long getItemId(int position) {
      return (long)position;
   }

   public void notifyDataSetChanged() {
   }

   public View getView(int position, View convertView, ViewGroup parent) {
      es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias.ViewHolder holder;
      if (convertView == null) {
         LayoutInflater inflater = (LayoutInflater)this.activity.getSystemService("layout_inflater");
         convertView = inflater.inflate(2131558736, parent, false);
         holder = new es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias.ViewHolder();
         holder.tvTitle = (TextView)convertView.findViewById(2131362988);
         holder.image = (ImageView)convertView.findViewById(2131362336);
         convertView.setTag(holder);
         if (position % 2 == 0) {
            convertView.setBackgroundResource(2131100979);
         } else {
            convertView.setBackgroundResource(2131099983);
         }
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.AdaptadorListaNoticias.ViewHolder)convertView.getTag();
      }

      holder.tvTitle.setText(((NoticiaActualidadDTO)this.news.get(position)).getTituloNoticia());
      Typeface tf = Typeface.createFromAsset(this.activity.getAssets(), "FiraSans-Medium.ttf");
      holder.tvTitle.setTypeface(tf);
      return convertView;
   }
}
