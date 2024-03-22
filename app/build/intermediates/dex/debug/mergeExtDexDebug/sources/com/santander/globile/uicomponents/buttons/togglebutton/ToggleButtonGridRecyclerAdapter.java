package com.santander.globile.uicomponents.buttons.togglebutton;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.buttons.togglebutton.data.GlobileToggleButtonData;
import com.santander.globile.uicomponents.list.common.adapter.GlobileGenericListAdapter;
import com.santander.globile.uicomponents.list.common.listener.GlobileListListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/togglebutton/ToggleButtonGridRecyclerAdapter;", "Lcom/santander/globile/uicomponents/list/common/adapter/GlobileGenericListAdapter;", "Lcom/santander/globile/uicomponents/buttons/togglebutton/data/GlobileToggleButtonData;", "data", "", "listener", "Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;", "(Ljava/util/List;Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getItemCount", "", "getLayoutId", "position", "obj", "getViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "viewType", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: ToggleButtonGridRecyclerAdapter.kt */
public final class ToggleButtonGridRecyclerAdapter extends GlobileGenericListAdapter<GlobileToggleButtonData> {
    private List<GlobileToggleButtonData> data;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ToggleButtonGridRecyclerAdapter(List<GlobileToggleButtonData> data2, GlobileListListener<GlobileToggleButtonData> listener) {
        super(data2, listener);
        Intrinsics.checkParameterIsNotNull(data2, "data");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.data = data2;
    }

    public final List<GlobileToggleButtonData> getData() {
        return this.data;
    }

    public final void setData(List<GlobileToggleButtonData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.data = list;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId(int position, GlobileToggleButtonData obj) {
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        return R.layout.globile_toggle_button_row;
    }

    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        return new GlobileToggleViewHolder(view);
    }

    public int getItemCount() {
        List<GlobileToggleButtonData> list = this.data;
        return (list != null ? Integer.valueOf(list.size()) : null).intValue();
    }
}
