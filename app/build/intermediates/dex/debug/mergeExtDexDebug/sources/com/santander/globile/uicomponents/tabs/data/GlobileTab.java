package com.santander.globile.uicomponents.tabs.data;

import androidx.fragment.app.Fragment;
import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/santander/globile/uicomponents/tabs/data/GlobileTab;", "", "title", "", "iconId", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Ljava/lang/String;Ljava/lang/Integer;Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "getIconId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Landroidx/fragment/app/Fragment;)Lcom/santander/globile/uicomponents/tabs/data/GlobileTab;", "equals", "", "other", "hashCode", "toString", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTab.kt */
public final class GlobileTab {
    private Fragment fragment;
    private final Integer iconId;
    private final String title;

    public static /* synthetic */ GlobileTab copy$default(GlobileTab globileTab, String str, Integer num, Fragment fragment2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = globileTab.title;
        }
        if ((i & 2) != 0) {
            num = globileTab.iconId;
        }
        if ((i & 4) != 0) {
            fragment2 = globileTab.fragment;
        }
        return globileTab.copy(str, num, fragment2);
    }

    public final String component1() {
        return this.title;
    }

    public final Integer component2() {
        return this.iconId;
    }

    public final Fragment component3() {
        return this.fragment;
    }

    public final GlobileTab copy(String str, Integer num, Fragment fragment2) {
        Intrinsics.checkParameterIsNotNull(str, ConstantsKt.TITLE_TEXT);
        Intrinsics.checkParameterIsNotNull(fragment2, "fragment");
        return new GlobileTab(str, num, fragment2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlobileTab)) {
            return false;
        }
        GlobileTab globileTab = (GlobileTab) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) globileTab.title) && Intrinsics.areEqual((Object) this.iconId, (Object) globileTab.iconId) && Intrinsics.areEqual((Object) this.fragment, (Object) globileTab.fragment);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.iconId;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Fragment fragment2 = this.fragment;
        if (fragment2 != null) {
            i = fragment2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GlobileTab(title=" + this.title + ", iconId=" + this.iconId + ", fragment=" + this.fragment + ")";
    }

    public GlobileTab(String title2, Integer iconId2, Fragment fragment2) {
        Intrinsics.checkParameterIsNotNull(title2, ConstantsKt.TITLE_TEXT);
        Intrinsics.checkParameterIsNotNull(fragment2, "fragment");
        this.title = title2;
        this.iconId = iconId2;
        this.fragment = fragment2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileTab(String str, Integer num, Fragment fragment2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num, fragment2);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final Integer getIconId() {
        return this.iconId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setFragment(Fragment fragment2) {
        Intrinsics.checkParameterIsNotNull(fragment2, "<set-?>");
        this.fragment = fragment2;
    }
}
