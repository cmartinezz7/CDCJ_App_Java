package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import es.santander.justicia.minisJusticia.dto.TimeLineDetailDTO;
import java.util.ArrayList;

public class TimeLineAdapter extends ArrayAdapter<TimeLineDetailDTO> {
   private Context context;
   private ArrayList<TimeLineDetailDTO> timeLineList;
   private int lastItem;

   public TimeLineAdapter(Context context, ArrayList<TimeLineDetailDTO> timeLineList) {
      super(context, 0, timeLineList);
      this.context = context;
      this.timeLineList = timeLineList;
      this.lastItem = timeLineList.size() - 1;
   }

   public int getCount() {
      return this.timeLineList.size();
   }

   public TimeLineDetailDTO getItem(int position) {
      return (TimeLineDetailDTO)this.timeLineList.get(position);
   }

   @NonNull
   public View getView(int position, View convertView, ViewGroup parent) {
      TimeLineDetailDTO timeLineItem = (TimeLineDetailDTO)this.timeLineList.get(position);
      es.santander.justicia.minisJusticia.adapters.TimeLineAdapter.ViewHolder holder = new es.santander.justicia.minisJusticia.adapters.TimeLineAdapter.ViewHolder();
      if (convertView == null) {
         convertView = LayoutInflater.from(this.context).inflate(2131558738, parent, false);
         holder.llUserContainer = (LinearLayout)convertView.findViewById(2131362429);
         holder.statusName = (TextView)convertView.findViewById(2131363061);
         holder.statusImageIndicator = (ImageView)convertView.findViewById(2131362356);
         holder.date = (TextView)convertView.findViewById(2131363005);
         holder.userName = (TextView)convertView.findViewById(2131363083);
         holder.topLine = convertView.findViewById(2131363156);
         holder.bottomLine = convertView.findViewById(2131363153);
         convertView.setTag(holder);
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.TimeLineAdapter.ViewHolder)convertView.getTag();
      }

      holder.statusName.setText(timeLineItem.getStatusName());
      holder.date.setText(timeLineItem.getDate());
      String userName = timeLineItem.getUserName() != null ? timeLineItem.getUserName().trim() : "";
      if (!userName.isEmpty()) {
         holder.llUserContainer.setVisibility(0);
         holder.userName.setText(userName);
      } else {
         holder.llUserContainer.setVisibility(8);
      }

      if (position == 0) {
         holder.topLine.setVisibility(4);
      } else {
         holder.topLine.setVisibility(0);
      }

      if (position == this.lastItem) {
         holder.bottomLine.setVisibility(4);
      } else {
         holder.bottomLine.setVisibility(0);
      }

      String status = timeLineItem.getStatus();
      byte var11 = -1;
      switch(status.hashCode()) {
      case -1423461112:
         if (status.equals("accept")) {
            var11 = 0;
         }
         break;
      case -1309235419:
         if (status.equals("expired")) {
            var11 = 4;
         }
         break;
      case -466972329:
         if (status.equals("no_canceled")) {
            var11 = 3;
         }
         break;
      case -123173735:
         if (status.equals("canceled")) {
            var11 = 2;
         }
         break;
      case 211933510:
         if (status.equals("no_accept")) {
            var11 = 1;
         }
         break;
      case 2143357607:
         if (status.equals("no_expired")) {
            var11 = 5;
         }
      }

      int indicatorImage;
      int lineColor;
      switch(var11) {
      case 0:
         indicatorImage = 2131231007;
         lineColor = 2131100951;
         break;
      case 1:
         indicatorImage = 2131231008;
         lineColor = 2131100951;
         break;
      case 2:
         indicatorImage = 2131231010;
         lineColor = 2131100916;
         break;
      case 3:
         indicatorImage = 2131231011;
         lineColor = 2131100916;
         break;
      case 4:
         indicatorImage = 2131231050;
         lineColor = 2131100952;
         break;
      case 5:
         indicatorImage = 2131231051;
         lineColor = 2131100952;
         break;
      default:
         indicatorImage = 2131231051;
         lineColor = 2131100951;
      }

      holder.statusName.setTextColor(ContextCompat.getColor(this.context, lineColor));
      holder.statusImageIndicator.setImageResource(indicatorImage);
      holder.topLine.setBackgroundColor(ContextCompat.getColor(this.context, lineColor));
      holder.bottomLine.setBackgroundColor(ContextCompat.getColor(this.context, lineColor));
      return convertView;
   }
}
