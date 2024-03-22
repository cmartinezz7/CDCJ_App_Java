package com.santander.globile.uicomponents.list.common.listener;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/santander/globile/uicomponents/list/common/listener/GlobileListListener;", "T", "", "onClickListener", "", "data", "v", "Landroid/view/View;", "code", "", "(Ljava/lang/Object;Landroid/view/View;I)V", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileListListener.kt */
public interface GlobileListListener<T> {
    void onClickListener(T t, View view, int i);
}
