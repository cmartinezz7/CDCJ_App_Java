package com.santander.globile.uicomponents.buttons.togglebutton.data;

import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/togglebutton/data/GlobileToggleButtonData;", "", "toggleButtonTag", "", "title", "", "isSelect", "", "(ILjava/lang/String;Z)V", "()Z", "setSelect", "(Z)V", "getTitle", "()Ljava/lang/String;", "getToggleButtonTag", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileToggleButtonData.kt */
public final class GlobileToggleButtonData {
    private boolean isSelect;
    private final String title;
    private final int toggleButtonTag;

    public static /* synthetic */ GlobileToggleButtonData copy$default(GlobileToggleButtonData globileToggleButtonData, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = globileToggleButtonData.toggleButtonTag;
        }
        if ((i2 & 2) != 0) {
            str = globileToggleButtonData.title;
        }
        if ((i2 & 4) != 0) {
            z = globileToggleButtonData.isSelect;
        }
        return globileToggleButtonData.copy(i, str, z);
    }

    public final int component1() {
        return this.toggleButtonTag;
    }

    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.isSelect;
    }

    public final GlobileToggleButtonData copy(int i, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, ConstantsKt.TITLE_TEXT);
        return new GlobileToggleButtonData(i, str, z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof GlobileToggleButtonData) {
                GlobileToggleButtonData globileToggleButtonData = (GlobileToggleButtonData) obj;
                if ((this.toggleButtonTag == globileToggleButtonData.toggleButtonTag) && Intrinsics.areEqual((Object) this.title, (Object) globileToggleButtonData.title)) {
                    if (this.isSelect == globileToggleButtonData.isSelect) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.toggleButtonTag * 31;
        String str = this.title;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.isSelect;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "GlobileToggleButtonData(toggleButtonTag=" + this.toggleButtonTag + ", title=" + this.title + ", isSelect=" + this.isSelect + ")";
    }

    public GlobileToggleButtonData(int toggleButtonTag2, String title2, boolean isSelect2) {
        Intrinsics.checkParameterIsNotNull(title2, ConstantsKt.TITLE_TEXT);
        this.toggleButtonTag = toggleButtonTag2;
        this.title = title2;
        this.isSelect = isSelect2;
    }

    public final int getToggleButtonTag() {
        return this.toggleButtonTag;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileToggleButtonData(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? false : z);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
