package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class AdapterExpandableDrawerLetrados extends BaseExpandableListAdapter {
   private TypedArray mArrayGroup;
   private TypedArray mArrayChild;
   private TypedArray mArrayImages;
   private Context mContext;

   public AdapterExpandableDrawerLetrados(Context mContext) {
      this.mContext = mContext;
      this.mArrayGroup = mContext.getResources().obtainTypedArray(2130903041);
      this.mArrayChild = mContext.getResources().obtainTypedArray(2130903043);
      this.mArrayImages = mContext.getResources().obtainTypedArray(2130903042);
   }

   public int getGroupCount() {
      return this.mArrayGroup == null ? 0 : this.mArrayGroup.length();
   }

   public int getChildrenCount(int i) {
      return 0;
   }

   public String getGroup(int i) {
      return this.mArrayGroup.getString(i);
   }

   public Drawable getImageGroup(int i) {
      return this.mArrayImages.getDrawable(i);
   }

   public String getChild(int i, int i1) {
      return this.mArrayChild.getString(i1);
   }

   public long getGroupId(int i) {
      return (long)this.mArrayGroup.getResourceId(i, -1);
   }

   public long getChildId(int i, int i1) {
      return 0L;
   }

   public boolean hasStableIds() {
      return false;
   }

   public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
      es.santander.justicia.minisJusticia.adapters.AdapterExpandableDrawerLetrados.HolderGroup holder;
      if (view == null) {
         holder = new es.santander.justicia.minisJusticia.adapters.AdapterExpandableDrawerLetrados.HolderGroup();
         view = View.inflate(this.mContext, 2131558608, (ViewGroup)null);
         holder.text = (TextView)view.findViewById(2131362800);
         view.setTag(holder);
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.AdapterExpandableDrawerLetrados.HolderGroup)view.getTag();
      }

      holder.text.setText(this.getGroup(i));
      holder.text.setSelected(b);
      return view;
   }

   public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
      es.santander.justicia.minisJusticia.adapters.AdapterExpandableDrawerLetrados.HolderGroup holder;
      if (view == null) {
         holder = new es.santander.justicia.minisJusticia.adapters.AdapterExpandableDrawerLetrados.HolderGroup();
         view = View.inflate(this.mContext, 2131558607, (ViewGroup)null);
         holder.text = (TextView)view.findViewById(2131362800);
         view.setTag(holder);
      } else {
         holder = (es.santander.justicia.minisJusticia.adapters.AdapterExpandableDrawerLetrados.HolderGroup)view.getTag();
      }

      holder.text.setText(this.getChild(i, i1));
      return view;
   }

   public boolean isChildSelectable(int i, int i1) {
      return true;
   }
}
