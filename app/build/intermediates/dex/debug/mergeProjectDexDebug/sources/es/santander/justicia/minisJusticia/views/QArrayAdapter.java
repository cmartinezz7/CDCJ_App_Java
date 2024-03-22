package es.santander.justicia.minisJusticia.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.widget.AppCompatImageView;
import es.santander.justicia.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0013B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Les/santander/justicia/minisJusticia/views/QArrayAdapter;", "T", "Landroid/widget/ArrayAdapter;", "context", "Landroid/content/Context;", "resource", "", "objects", "", "imgIcon", "(Landroid/content/Context;ILjava/util/List;I)V", "getResource", "()I", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "ItemRowHolder", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: QArrayAdapter.kt */
public final class QArrayAdapter<T> extends ArrayAdapter<T> {
    private final int imgIcon;
    private final int resource;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QArrayAdapter(Context context, int i, List list, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? R.layout.simple_qarray_adapter : i, list, i2);
    }

    public final int getResource() {
        return this.resource;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QArrayAdapter(Context context, int resource2, List<? extends T> objects, int imgIcon2) {
        super(context, resource2, objects);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(objects, "objects");
        this.resource = resource2;
        this.imgIcon = imgIcon2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.resource, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(resource, parent, false)");
            View view = inflate;
            view.setTag(new ItemRowHolder(view, this.imgIcon));
            return view;
        }
        View view2 = convertView;
        Object tag = view2.getTag();
        if (tag != null) {
            ItemRowHolder vh = (ItemRowHolder) tag;
            return view2;
        }
        throw new NullPointerException("null cannot be cast to non-null type es.santander.justicia.minisJusticia.views.QArrayAdapter.ItemRowHolder");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Les/santander/justicia/minisJusticia/views/QArrayAdapter$ItemRowHolder;", "", "row", "Landroid/view/View;", "imgIcon", "", "(Landroid/view/View;I)V", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: QArrayAdapter.kt */
    private static final class ItemRowHolder {
        public ItemRowHolder(View row, int imgIcon) {
            AppCompatImageView imgView = null;
            AppCompatImageView appCompatImageView = row == null ? null : (AppCompatImageView) row.findViewById(R.id.adapter_icon);
            imgView = appCompatImageView instanceof AppCompatImageView ? appCompatImageView : imgView;
            if (imgView != null) {
                imgView.setImageResource(imgIcon);
            }
        }
    }
}
