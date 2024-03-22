package com.santander.globile.uicomponents.list.simple.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/santander/globile/uicomponents/list/simple/data/SimpleData;", "", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getValue", "setValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: SimpleData.kt */
public final class SimpleData {
    private String key;
    private String value;

    public static /* synthetic */ SimpleData copy$default(SimpleData simpleData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = simpleData.key;
        }
        if ((i & 2) != 0) {
            str2 = simpleData.value;
        }
        return simpleData.copy(str, str2);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final SimpleData copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        return new SimpleData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleData)) {
            return false;
        }
        SimpleData simpleData = (SimpleData) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) simpleData.key) && Intrinsics.areEqual((Object) this.value, (Object) simpleData.value);
    }

    public int hashCode() {
        String str = this.key;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SimpleData(key=" + this.key + ", value=" + this.value + ")";
    }

    public SimpleData(String key2, String value2) {
        Intrinsics.checkParameterIsNotNull(key2, "key");
        Intrinsics.checkParameterIsNotNull(value2, "value");
        this.key = key2;
        this.value = value2;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.key = str;
    }

    public final void setValue(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.value = str;
    }
}
