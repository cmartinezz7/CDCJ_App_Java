package com.santander.globile.uicomponents.tabs.data;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/santander/globile/uicomponents/tabs/data/GlobileTabsAdapterData;", "", "tabs", "Ljava/util/ArrayList;", "Lcom/santander/globile/uicomponents/tabs/data/GlobileTab;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getTabs", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTabsAdapterData.kt */
public final class GlobileTabsAdapterData {
    private final ArrayList<GlobileTab> tabs;

    public static /* synthetic */ GlobileTabsAdapterData copy$default(GlobileTabsAdapterData globileTabsAdapterData, ArrayList<GlobileTab> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = globileTabsAdapterData.tabs;
        }
        return globileTabsAdapterData.copy(arrayList);
    }

    public final ArrayList<GlobileTab> component1() {
        return this.tabs;
    }

    public final GlobileTabsAdapterData copy(ArrayList<GlobileTab> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "tabs");
        return new GlobileTabsAdapterData(arrayList);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof GlobileTabsAdapterData) && Intrinsics.areEqual((Object) this.tabs, (Object) ((GlobileTabsAdapterData) obj).tabs);
        }
        return true;
    }

    public int hashCode() {
        ArrayList<GlobileTab> arrayList = this.tabs;
        if (arrayList != null) {
            return arrayList.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "GlobileTabsAdapterData(tabs=" + this.tabs + ")";
    }

    public GlobileTabsAdapterData(ArrayList<GlobileTab> tabs2) {
        Intrinsics.checkParameterIsNotNull(tabs2, "tabs");
        this.tabs = tabs2;
    }

    public final ArrayList<GlobileTab> getTabs() {
        return this.tabs;
    }
}
