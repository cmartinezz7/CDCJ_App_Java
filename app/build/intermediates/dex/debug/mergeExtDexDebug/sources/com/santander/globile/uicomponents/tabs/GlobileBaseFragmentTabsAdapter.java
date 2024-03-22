package com.santander.globile.uicomponents.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.santander.globile.uicomponents.tabs.data.GlobileTabsAdapterData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0012J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u0012H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/santander/globile/uicomponents/tabs/GlobileBaseFragmentTabsAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "context", "Landroid/content/Context;", "globileTabsAdapterData", "Lcom/santander/globile/uicomponents/tabs/data/GlobileTabsAdapterData;", "(Landroidx/fragment/app/FragmentManager;Landroid/content/Context;Lcom/santander/globile/uicomponents/tabs/data/GlobileTabsAdapterData;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getGlobileTabsAdapterData", "()Lcom/santander/globile/uicomponents/tabs/data/GlobileTabsAdapterData;", "setGlobileTabsAdapterData", "(Lcom/santander/globile/uicomponents/tabs/data/GlobileTabsAdapterData;)V", "getCount", "", "getFragment", "Landroidx/fragment/app/Fragment;", "key", "getItem", "position", "getPageIcon", "Landroid/graphics/drawable/Drawable;", "getPageTitle", "", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileBaseFragmentTabsAdapter.kt */
public class GlobileBaseFragmentTabsAdapter extends FragmentPagerAdapter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = GlobileBaseFragmentTabsAdapter.class.getSimpleName();
    private Context context;
    private GlobileTabsAdapterData globileTabsAdapterData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileBaseFragmentTabsAdapter(FragmentManager fm, Context context2, GlobileTabsAdapterData globileTabsAdapterData2) {
        super(fm, 1);
        Intrinsics.checkParameterIsNotNull(fm, "fm");
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(globileTabsAdapterData2, "globileTabsAdapterData");
        this.context = context2;
        this.globileTabsAdapterData = globileTabsAdapterData2;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final void setContext(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "<set-?>");
        this.context = context2;
    }

    public final GlobileTabsAdapterData getGlobileTabsAdapterData() {
        return this.globileTabsAdapterData;
    }

    public final void setGlobileTabsAdapterData(GlobileTabsAdapterData globileTabsAdapterData2) {
        Intrinsics.checkParameterIsNotNull(globileTabsAdapterData2, "<set-?>");
        this.globileTabsAdapterData = globileTabsAdapterData2;
    }

    public Fragment getItem(int position) {
        if (this.globileTabsAdapterData.getTabs().size() > position) {
            return this.globileTabsAdapterData.getTabs().get(position).getFragment();
        }
        return new Fragment();
    }

    public int getCount() {
        return this.globileTabsAdapterData.getTabs().size();
    }

    public CharSequence getPageTitle(int position) {
        return this.globileTabsAdapterData.getTabs().get(position).getTitle();
    }

    public final Drawable getPageIcon(Context context2, int position) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Integer iconId = this.globileTabsAdapterData.getTabs().get(position).getIconId();
        if (iconId != null) {
            return ContextCompat.getDrawable(context2, iconId.intValue());
        }
        return null;
    }

    public final Fragment getFragment(int key) {
        return this.globileTabsAdapterData.getTabs().get(key).getFragment();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/santander/globile/uicomponents/tabs/GlobileBaseFragmentTabsAdapter$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "TAG$annotations", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileBaseFragmentTabsAdapter.kt */
    public static final class Companion {
        private static /* synthetic */ void TAG$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
