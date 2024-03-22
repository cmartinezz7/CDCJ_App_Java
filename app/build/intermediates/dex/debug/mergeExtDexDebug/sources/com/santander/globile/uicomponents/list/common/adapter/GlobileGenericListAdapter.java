package com.santander.globile.uicomponents.list.common.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.santander.globile.uicomponents.list.common.listener.GlobileListListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B#\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bB\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\tB\u0007\b\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u001d\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013H&J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0014\u0010#\u001a\u00020\u001e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\tR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/santander/globile/uicomponents/list/common/adapter/GlobileGenericListAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listItems", "", "listener", "Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;", "(Ljava/util/List;Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;)V", "(Ljava/util/List;)V", "()V", "getListItems", "()Ljava/util/List;", "setListItems", "getListener", "()Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;", "setListener", "(Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;)V", "getItemCount", "", "getItemViewType", "position", "getLayoutId", "obj", "(ILjava/lang/Object;)I", "getViewHolder", "view", "Landroid/view/View;", "viewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setItems", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileGenericListAdapter.kt */
public abstract class GlobileGenericListAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<? extends T> listItems;
    private GlobileListListener<T> listener;

    /* access modifiers changed from: protected */
    public abstract int getLayoutId(int i, T t);

    public abstract RecyclerView.ViewHolder getViewHolder(View view, int i);

    public final List<T> getListItems() {
        return this.listItems;
    }

    public final void setListItems(List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.listItems = list;
    }

    public final GlobileListListener<T> getListener() {
        return this.listener;
    }

    public final void setListener(GlobileListListener<T> globileListListener) {
        this.listener = globileListListener;
    }

    public GlobileGenericListAdapter(List<? extends T> listItems2, GlobileListListener<T> listener2) {
        Intrinsics.checkParameterIsNotNull(listItems2, "listItems");
        Intrinsics.checkParameterIsNotNull(listener2, "listener");
        this.listItems = listItems2;
        this.listener = listener2;
    }

    public GlobileGenericListAdapter(List<? extends T> listItems2) {
        Intrinsics.checkParameterIsNotNull(listItems2, "listItems");
        this.listItems = listItems2;
    }

    public GlobileGenericListAdapter() {
        this.listItems = CollectionsKt.emptyList();
    }

    public final void setItems(List<? extends T> listItems2) {
        Intrinsics.checkParameterIsNotNull(listItems2, "listItems");
        this.listItems = listItems2;
        notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(pare…(viewType, parent, false)");
        return getViewHolder(inflate, viewType);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        ((GlobileGenericBinder) holder).bind(this.listItems.get(position), this.listener);
    }

    public int getItemCount() {
        return this.listItems.size();
    }

    public int getItemViewType(int position) {
        return getLayoutId(position, this.listItems.get(position));
    }
}
