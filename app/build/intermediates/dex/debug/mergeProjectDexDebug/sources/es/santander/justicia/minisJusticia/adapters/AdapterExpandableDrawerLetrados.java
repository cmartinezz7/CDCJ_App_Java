package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import es.santander.justicia.R;

public class AdapterExpandableDrawerLetrados extends BaseExpandableListAdapter {
    private TypedArray mArrayChild;
    private TypedArray mArrayGroup;
    private TypedArray mArrayImages;
    private Context mContext;

    public static class HolderGroup {
        public TextView text;
    }

    public AdapterExpandableDrawerLetrados(Context mContext2) {
        this.mContext = mContext2;
        this.mArrayGroup = mContext2.getResources().obtainTypedArray(R.array.drawer_letrados);
        this.mArrayChild = mContext2.getResources().obtainTypedArray(R.array.drawer_sub_letrados);
        this.mArrayImages = mContext2.getResources().obtainTypedArray(R.array.drawer_letrados_images);
    }

    public int getGroupCount() {
        TypedArray typedArray = this.mArrayGroup;
        if (typedArray == null) {
            return 0;
        }
        return typedArray.length();
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
        return (long) this.mArrayGroup.getResourceId(i, -1);
    }

    public long getChildId(int i, int i1) {
        return 0;
    }

    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        HolderGroup holder;
        if (view == null) {
            holder = new HolderGroup();
            view = View.inflate(this.mContext, R.layout.item_group_drawer_letrados, (ViewGroup) null);
            holder.text = (TextView) view.findViewById(2131362800);
            view.setTag(holder);
        } else {
            holder = (HolderGroup) view.getTag();
        }
        holder.text.setText(getGroup(i));
        holder.text.setSelected(b);
        return view;
    }

    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        HolderGroup holder;
        if (view == null) {
            holder = new HolderGroup();
            view = View.inflate(this.mContext, R.layout.item_child_drawer_letrados, (ViewGroup) null);
            holder.text = (TextView) view.findViewById(2131362800);
            view.setTag(holder);
        } else {
            holder = (HolderGroup) view.getTag();
        }
        holder.text.setText(getChild(i, i1));
        return view;
    }

    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
