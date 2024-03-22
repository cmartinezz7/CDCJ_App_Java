package com.santander.globile.uicomponents.common;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/santander/globile/uicomponents/common/GlobileDefaultColorComponents;", "", "color", "", "(Ljava/lang/String;II)V", "getColor", "()I", "RED", "TURQUOSE", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileEnums.kt */
public enum GlobileDefaultColorComponents {
    RED(0),
    TURQUOSE(1);
    
    private final int color;

    private GlobileDefaultColorComponents(int color2) {
        this.color = color2;
    }

    public final int getColor() {
        return this.color;
    }
}
