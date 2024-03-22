package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import es.santander.justicia.R;

public class AdapterDrawerLetrados extends BaseAdapter {
    private static final int JUDGES_POSITION = 7;
    private TypedArray mArray;
    private TypedArray mArrayImages = this.mContext.getResources().obtainTypedArray(R.array.drawer_letrados_images);
    private Context mContext;
    private int mSelectedPosition;

    public static class Holder {
        public TextView mTextItem;
    }

    public AdapterDrawerLetrados(Context context) {
        this.mContext = context;
        this.mArray = context.getResources().obtainTypedArray(R.array.drawer_letrados);
    }

    public int getCount() {
        TypedArray typedArray = this.mArray;
        if (typedArray == null) {
            return 0;
        }
        return typedArray.length();
    }

    public String getItem(int position) {
        return this.mArray.getString(position);
    }

    public long getItemId(int position) {
        return (long) this.mArray.getResourceId(position, -1);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        boolean z = false;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.item_group_drawer_letrados, parent, false);
            holder = new Holder();
            holder.mTextItem = (TextView) convertView.findViewById(2131362800);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.mTextItem.setText(getItem(position));
        Drawable drawable = this.mArrayImages.getDrawable(position);
        if (position == this.mSelectedPosition) {
            drawable.setColorFilter(ContextCompat.getColor(this.mContext, R.color.labelDateExpediente), PorterDuff.Mode.SRC_IN);
        } else if (position == 7) {
            drawable.setColorFilter(ContextCompat.getColor(this.mContext, R.color.menuItemsTextColor), PorterDuff.Mode.SRC_IN);
        } else {
            drawable.setColorFilter(ContextCompat.getColor(this.mContext, R.color.bancoSantander), PorterDuff.Mode.SRC_IN);
        }
        holder.mTextItem.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView = holder.mTextItem;
        if (position == this.mSelectedPosition) {
            z = true;
        }
        textView.setSelected(z);
        return convertView;
    }

    public void setmSelectedPosition(int selecPos) {
        this.mSelectedPosition = selecPos;
        notifyDataSetChanged();
    }
}
