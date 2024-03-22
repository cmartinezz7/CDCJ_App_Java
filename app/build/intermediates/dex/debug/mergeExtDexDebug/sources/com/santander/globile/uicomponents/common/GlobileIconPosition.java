package com.santander.globile.uicomponents.common;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/santander/globile/uicomponents/common/GlobileIconPosition;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "LEFT", "TOP", "RIGHT", "BOTTOM", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileEnums.kt */
public enum GlobileIconPosition {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3);
    
    private final int position;

    private GlobileIconPosition(int position2) {
        this.position = position2;
    }

    public final int getPosition() {
        return this.position;
    }
}
