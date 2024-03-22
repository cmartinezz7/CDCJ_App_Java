package com.santander.globile.uicomponents.optionselection.dropdown.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/dropdown/data/DropDownData;", "T", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/santander/globile/uicomponents/optionselection/dropdown/data/DropDownData;", "equals", "", "other", "hashCode", "", "toString", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: DropDownData.kt */
public final class DropDownData<T> {
    private final String key;
    private final T value;

    public static /* synthetic */ DropDownData copy$default(DropDownData dropDownData, String str, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dropDownData.key;
        }
        if ((i & 2) != 0) {
            t = dropDownData.value;
        }
        return dropDownData.copy(str, t);
    }

    public final String component1() {
        return this.key;
    }

    public final T component2() {
        return this.value;
    }

    public final DropDownData<T> copy(String str, T t) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        return new DropDownData<>(str, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropDownData)) {
            return false;
        }
        DropDownData dropDownData = (DropDownData) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) dropDownData.key) && Intrinsics.areEqual((Object) this.value, (Object) dropDownData.value);
    }

    public int hashCode() {
        String str = this.key;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        T t = this.value;
        if (t != null) {
            i = t.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "DropDownData(key=" + this.key + ", value=" + this.value + ")";
    }

    public DropDownData(String key2, T value2) {
        Intrinsics.checkParameterIsNotNull(key2, "key");
        this.key = key2;
        this.value = value2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DropDownData(String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj);
    }

    public final String getKey() {
        return this.key;
    }

    public final T getValue() {
        return this.value;
    }
}
