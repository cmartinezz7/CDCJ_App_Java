package com.santander.globile.uicomponents.list.simple.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.list.common.adapter.GlobileGenericBinder;
import com.santander.globile.uicomponents.list.common.listener.GlobileListListener;
import com.santander.globile.uicomponents.list.simple.data.SimpleData;
import com.santander.globile.uicomponents.text.SantanderTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/santander/globile/uicomponents/list/simple/viewholder/GlobileSimpleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/santander/globile/uicomponents/list/common/adapter/GlobileGenericBinder;", "Lcom/santander/globile/uicomponents/list/simple/data/SimpleData;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "data", "listener", "Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileSimpleViewHolder.kt */
public final class GlobileSimpleViewHolder extends RecyclerView.ViewHolder implements GlobileGenericBinder<SimpleData> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileSimpleViewHolder(View itemView) {
        super(itemView);
        Intrinsics.checkParameterIsNotNull(itemView, "itemView");
    }

    public void bind(SimpleData data, GlobileListListener<SimpleData> listener) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        View view = this.itemView;
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        SantanderTextView santanderTextView = (SantanderTextView) view.findViewById(R.id.simple_row_key);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "view.simple_row_key");
        santanderTextView.setText(data.getKey());
        SantanderTextView santanderTextView2 = (SantanderTextView) view.findViewById(R.id.simple_row_value);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "view.simple_row_value");
        santanderTextView2.setText(data.getValue());
        view.setOnClickListener(new GlobileSimpleViewHolder$bind$$inlined$let$lambda$1(view, data, listener));
    }
}
