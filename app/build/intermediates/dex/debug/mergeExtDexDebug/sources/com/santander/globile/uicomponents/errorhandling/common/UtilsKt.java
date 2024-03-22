package com.santander.globile.uicomponents.errorhandling.common;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"initSupportFragmentManager", "Landroidx/fragment/app/FragmentTransaction;", "supportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "dialogTag", "", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final FragmentTransaction initSupportFragmentManager(FragmentManager supportFragmentManager, String dialogTag) {
        Intrinsics.checkParameterIsNotNull(supportFragmentManager, "supportFragmentManager");
        Intrinsics.checkParameterIsNotNull(dialogTag, "dialogTag");
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        Intrinsics.checkExpressionValueIsNotNull(ft, "supportFragmentManager.beginTransaction()");
        Fragment prev = supportFragmentManager.findFragmentByTag(dialogTag);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack((String) null);
        return ft;
    }
}
