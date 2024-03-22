package com.santander.globile.uicomponents.slider;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004"}, d2 = {"com/santander/globile/uicomponents/slider/GlobileSeparatorSlider$getIntervals$1", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileSeparatorSlider.kt */
public final class GlobileSeparatorSlider$getIntervals$1 extends ArrayList<Integer> {
    final /* synthetic */ int $interval;
    final /* synthetic */ int $max;
    final /* synthetic */ int $min;

    GlobileSeparatorSlider$getIntervals$1(int $captured_local_variable$0, int $captured_local_variable$1, int $captured_local_variable$2) {
        this.$min = $captured_local_variable$0;
        this.$max = $captured_local_variable$1;
        this.$interval = $captured_local_variable$2;
        int minAux = $captured_local_variable$0;
        while (minAux <= $captured_local_variable$1) {
            add(Integer.valueOf(minAux));
            minAux += $captured_local_variable$2;
        }
    }

    public /* bridge */ boolean contains(Integer num) {
        return super.contains(num);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return contains((Integer) obj);
        }
        return false;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(Integer num) {
        return super.indexOf(num);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Integer) {
            return indexOf((Integer) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(Integer num) {
        return super.lastIndexOf(num);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            return lastIndexOf((Integer) obj);
        }
        return -1;
    }

    public final /* bridge */ Integer remove(int i) {
        return removeAt(i);
    }

    public /* bridge */ boolean remove(Integer num) {
        return super.remove(num);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Integer) {
            return remove((Integer) obj);
        }
        return false;
    }

    public /* bridge */ Integer removeAt(int i) {
        return (Integer) super.remove(i);
    }

    public final /* bridge */ int size() {
        return getSize();
    }
}
