package com.santander.globile.uicomponents.slider;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/santander/globile/uicomponents/slider/SliderData;", "", "data", "", "", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: SliderData.kt */
public final class SliderData {
    private final Map<Integer, Integer> data;

    public static /* synthetic */ SliderData copy$default(SliderData sliderData, Map<Integer, Integer> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = sliderData.data;
        }
        return sliderData.copy(map);
    }

    public final Map<Integer, Integer> component1() {
        return this.data;
    }

    public final SliderData copy(Map<Integer, Integer> map) {
        Intrinsics.checkParameterIsNotNull(map, "data");
        return new SliderData(map);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SliderData) && Intrinsics.areEqual((Object) this.data, (Object) ((SliderData) obj).data);
        }
        return true;
    }

    public int hashCode() {
        Map<Integer, Integer> map = this.data;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SliderData(data=" + this.data + ")";
    }

    public SliderData(Map<Integer, Integer> data2) {
        Intrinsics.checkParameterIsNotNull(data2, "data");
        this.data = data2;
    }

    public final Map<Integer, Integer> getData() {
        return this.data;
    }
}
