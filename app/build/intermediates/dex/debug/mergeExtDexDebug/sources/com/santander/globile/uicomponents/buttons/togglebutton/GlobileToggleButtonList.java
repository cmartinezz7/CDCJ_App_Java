package com.santander.globile.uicomponents.buttons.togglebutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.buttons.togglebutton.data.GlobileToggleButtonData;
import com.santander.globile.uicomponents.list.common.listener.GlobileListListener;
import com.santander.globile.uicomponents.list.common.recycler.GlobileList;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u001e\u0010\u0011\u001a\u00020\f2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0013j\b\u0012\u0004\u0012\u00020\u0003`\u0014¨\u0006\u0015"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/togglebutton/GlobileToggleButtonList;", "Landroid/widget/LinearLayout;", "Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;", "Lcom/santander/globile/uicomponents/buttons/togglebutton/data/GlobileToggleButtonData;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onClickListener", "", "data", "v", "Landroid/view/View;", "code", "setList", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileToggleButtonList.kt */
public final class GlobileToggleButtonList extends LinearLayout implements GlobileListListener<GlobileToggleButtonData> {
    private HashMap _$_findViewCache;

    public GlobileToggleButtonList(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileToggleButtonList(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileToggleButtonList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        LayoutInflater.from(context).inflate(R.layout.globile_toggle_button_list, this, true);
        GlobileList globileList = (GlobileList) _$_findCachedViewById(R.id.recyclerViewToggleButtonList);
        Intrinsics.checkExpressionValueIsNotNull(globileList, "recyclerViewToggleButtonList");
        globileList.setLayoutManager(new GridLayoutManager(context, 3));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileToggleButtonList(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setList(ArrayList<GlobileToggleButtonData> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        GlobileList globileList = (GlobileList) _$_findCachedViewById(R.id.recyclerViewToggleButtonList);
        Intrinsics.checkExpressionValueIsNotNull(globileList, "recyclerViewToggleButtonList");
        globileList.setAdapter(new ToggleButtonGridRecyclerAdapter(list, this));
        ((GlobileList) _$_findCachedViewById(R.id.recyclerViewToggleButtonList)).removeDecoration();
        GlobileList globileList2 = (GlobileList) _$_findCachedViewById(R.id.recyclerViewToggleButtonList);
        Intrinsics.checkExpressionValueIsNotNull(globileList2, "recyclerViewToggleButtonList");
        ToggleButtonGridRecyclerAdapter adapter = globileList2.getAdapter();
        if (adapter != null) {
            adapter.getData();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.santander.globile.uicomponents.buttons.togglebutton.ToggleButtonGridRecyclerAdapter");
    }

    public void onClickListener(GlobileToggleButtonData data, View v, int code) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(v, "v");
        GlobileList globileList = (GlobileList) _$_findCachedViewById(R.id.recyclerViewToggleButtonList);
        Intrinsics.checkExpressionValueIsNotNull(globileList, "recyclerViewToggleButtonList");
        RecyclerView.Adapter adapter = globileList.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
