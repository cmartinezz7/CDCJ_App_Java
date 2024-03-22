package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;

public class CourtListAdapter extends ArrayAdapter<CourtDataDto> {
   private Context context;
   private ArrayList<CourtDataDto> courtList;

   public CourtListAdapter(Context context, ArrayList<CourtDataDto> courtList) {
      super(context, 0, courtList);
      this.context = context;
      this.courtList = courtList;
   }

   public int getCount() {
      return this.courtList.size();
   }

   public CourtDataDto getItem(int position) {
      return (CourtDataDto)this.courtList.get(position);
   }

   @NonNull
   public View getView(int position, View convertView, ViewGroup parent) {
      CourtDataDto courtData = (CourtDataDto)this.courtList.get(position);
      es.santander.justicia.minisJusticia.adapters.CourtListAdapter.ViewHolder holder = new es.santander.justicia.minisJusticia.adapters.CourtListAdapter.ViewHolder();
      if (convertView == null) {
         convertView = LayoutInflater.from(this.context).inflate(2131558726, parent, false);
         holder.organismName = (TextView)convertView.findViewById(2131363030);
         holder.judicialEnvironment = (TextView)convertView.findViewById(2131363024);
         holder.status = (TextView)convertView.findViewById(2131363060);
         holder.province = (TextView)convertView.findViewById(2131363037);
         convertView.setTag(holder);
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.CourtListAdapter.ViewHolder)convertView.getTag();
      }

      holder.organismName.setText(CommonUtils.wordCapitalize(courtData.getOrganismName()));
      holder.judicialEnvironment.setText(CommonUtils.wordCapitalize(courtData.getJudicialEnvironment()));
      holder.status.setText(courtData.getStatus());
      holder.province.setText(CommonUtils.wordCapitalize(courtData.getProvince()));
      return convertView;
   }
}
