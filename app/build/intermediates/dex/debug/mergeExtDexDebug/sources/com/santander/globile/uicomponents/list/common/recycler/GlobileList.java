package com.santander.globile.uicomponents.list.common.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.list.common.decoration.GlobileSeparationDecorator;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/santander/globile/uicomponents/list/common/recycler/GlobileList;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addDecoration", "", "color", "removeDecoration", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileList.kt */
public final class GlobileList extends RecyclerView {
    private HashMap _$_findViewCache;

    public GlobileList(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileList(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.view.View, com.santander.globile.uicomponents.list.common.recycler.GlobileList] */
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
    public GlobileList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        addDecoration(R.color.light_grey);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileList(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void addDecoration(int color) {
        Resources resources;
        GlobileSeparationDecorator globileSeparationDecorator = null;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = getContext();
            if (context != null) {
                globileSeparationDecorator = new GlobileSeparationDecorator(getContext(), context.getColor(color), 1.0f);
            }
        } else {
            Context context2 = getContext();
            if (!(context2 == null || (resources = context2.getResources()) == null)) {
                globileSeparationDecorator = new GlobileSeparationDecorator(getContext(), resources.getColor(color), 1.0f);
            }
        }
        GlobileSeparationDecorator decorator = globileSeparationDecorator;
        if (decorator != null) {
            addItemDecoration((RecyclerView.ItemDecoration) decorator);
        }
    }

    public final void removeDecoration() {
        RecyclerView.ItemDecoration itemDecoration = getItemDecorationAt(0);
        while (getItemDecorationCount() > 0) {
            if (itemDecoration != null) {
                removeItemDecoration(itemDecoration);
            }
        }
    }
}
