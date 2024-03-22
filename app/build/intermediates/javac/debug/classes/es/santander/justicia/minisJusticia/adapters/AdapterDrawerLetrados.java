package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

public class AdapterDrawerLetrados extends BaseAdapter {
   private static final int JUDGES_POSITION = 7;
   private Context mContext;
   private TypedArray mArray;
   private TypedArray mArrayImages;
   private int mSelectedPosition;

   public AdapterDrawerLetrados(Context context) {
      this.mContext = context;
      this.mArray = this.mContext.getResources().obtainTypedArray(2130903041);
      this.mArrayImages = this.mContext.getResources().obtainTypedArray(2130903042);
   }

   public int getCount() {
      return this.mArray == null ? 0 : this.mArray.length();
   }

   public String getItem(int position) {
      return this.mArray.getString(position);
   }

   public long getItemId(int position) {
      return (long)this.mArray.getResourceId(position, -1);
   }

   public View getView(int position, View convertView, ViewGroup parent) {
      es.santander.justicia.minisJusticia.adapters.AdapterDrawerLetrados.Holder holder;
      if (convertView == null) {
         convertView = LayoutInflater.from(this.mContext).inflate(2131558608, parent, false);
         holder = new es.santander.justicia.minisJusticia.adapters.AdapterDrawerLetrados.Holder();
         holder.mTextItem = (TextView)convertView.findViewById(2131362800);
         convertView.setTag(holder);
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.AdapterDrawerLetrados.Holder)convertView.getTag();
      }

      holder.mTextItem.setText(this.getItem(position));
      Drawable drawable = this.mArrayImages.getDrawable(position);
      if (position == this.mSelectedPosition) {
         drawable.setColorFilter(ContextCompat.getColor(this.mContext, 2131100004), Mode.SRC_IN);
      } else if (position == 7) {
         drawable.setColorFilter(ContextCompat.getColor(this.mContext, 2131100450), Mode.SRC_IN);
      } else {
         drawable.setColorFilter(ContextCompat.getColor(this.mContext, 2131099837), Mode.SRC_IN);
      }

      holder.mTextItem.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable)null, (Drawable)null, (Drawable)null);
      holder.mTextItem.setSelected(position == this.mSelectedPosition);
      return convertView;
   }

   public void setmSelectedPosition(int selecPos) {
      this.mSelectedPosition = selecPos;
      this.notifyDataSetChanged();
   }
}
