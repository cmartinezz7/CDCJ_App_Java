package com.santander.globile.uicomponents.list.simple.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.list.common.adapter.GlobileGenericListAdapter;
import com.santander.globile.uicomponents.list.simple.data.SimpleData;
import com.santander.globile.uicomponents.list.simple.viewholder.GlobileSimpleViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/santander/globile/uicomponents/list/simple/adapter/GlobileSimpleRecyclerAdapter;", "Lcom/santander/globile/uicomponents/list/common/adapter/GlobileGenericListAdapter;", "Lcom/santander/globile/uicomponents/list/simple/data/SimpleData;", "data", "", "(Ljava/util/List;)V", "getLayoutId", "", "position", "obj", "getViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "viewType", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileSimpleRecyclerAdapter.kt */
public final class GlobileSimpleRecyclerAdapter extends GlobileGenericListAdapter<SimpleData> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileSimpleRecyclerAdapter(List<SimpleData> data) {
        super(data);
        Intrinsics.checkParameterIsNotNull(data, "data");
    }

    /* access modifiers changed from: protected */
    public int getLayoutId(int position, SimpleData obj) {
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        return R.layout.globile_simple_row;
    }

    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        return new GlobileSimpleViewHolder(view);
    }
}
