package com.santander.globile.uicomponents.actionbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.utils.ViewExtensionKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\nH\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0017\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u0018H&J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/santander/globile/uicomponents/actionbar/GlobileActionBarActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "toolbarStyle", "Lcom/santander/globile/uicomponents/actionbar/ToolbarStyle;", "(Lcom/santander/globile/uicomponents/actionbar/ToolbarStyle;)V", "customToolbar", "Landroidx/appcompat/widget/Toolbar;", "navigationDrawer", "Landroidx/drawerlayout/widget/DrawerLayout;", "addOnClickListenerActionIcon", "", "onClickListener", "Landroid/view/View$OnClickListener;", "enableGlobileLogo", "enabled", "", "enableTitle", "hideActionIcon", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setActionIcon", "resIconId", "", "(Ljava/lang/Integer;)V", "setActionIconResource", "()Ljava/lang/Integer;", "setDrawerEnabled", "setLayoutId", "setNavigationDrawerEnabled", "setStyle", "setTitle", "title", "", "stringId", "toggleNavigationDrawer", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileActionBarActivity.kt */
public abstract class GlobileActionBarActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private Toolbar customToolbar;
    private DrawerLayout navigationDrawer;
    private final ToolbarStyle toolbarStyle;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public abstract Integer setActionIconResource();

    public abstract int setLayoutId();

    public GlobileActionBarActivity(ToolbarStyle toolbarStyle2) {
        Intrinsics.checkParameterIsNotNull(toolbarStyle2, "toolbarStyle");
        this.toolbarStyle = toolbarStyle2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        setStyle(this.toolbarStyle);
        GlobileActionBarActivity.super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        Toolbar _$_findCachedViewById = _$_findCachedViewById(R.id.globile_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "globile_toolbar");
        this.customToolbar = _$_findCachedViewById;
        DrawerLayout _$_findCachedViewById2 = _$_findCachedViewById(R.id.globile_navigation_drawer);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "globile_navigation_drawer");
        this.navigationDrawer = _$_findCachedViewById2;
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        setActionIcon(setActionIconResource());
        ((ImageButton) _$_findCachedViewById(R.id.globile_drawer_icon)).setOnClickListener(new GlobileActionBarActivity$onCreate$1(this));
    }

    private final void setStyle(ToolbarStyle toolbarStyle2) {
        int styleId = toolbarStyle2.getStyleId();
        if (styleId == 1) {
            setTheme(R.style.GlobileTheme_Red);
        } else if (styleId != 2) {
            setTheme(R.style.GlobileTheme_Red);
        } else {
            setTheme(R.style.GlobileTheme_White);
        }
    }

    public void setTitle(int stringId) {
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        TextView it = (TextView) toolbar.findViewById(R.id.globile_toolbar_title);
        if (it != null) {
            it.setText(getString(stringId));
            ViewExtensionKt.enable(it, true);
            enableGlobileLogo(false);
        }
    }

    public void setTitle(CharSequence title) {
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        TextView it = (TextView) toolbar.findViewById(R.id.globile_toolbar_title);
        if (it != null) {
            it.setText(title);
            ViewExtensionKt.enable(it, true);
            enableGlobileLogo(false);
        }
    }

    public final void enableTitle(boolean enabled) {
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        TextView textView = (TextView) toolbar.findViewById(R.id.globile_toolbar_title);
        if (textView != null) {
            ViewExtensionKt.enable(textView, enabled);
        }
        enableGlobileLogo(!enabled);
    }

    public final void enableGlobileLogo(boolean enabled) {
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        ImageView it = (ImageView) toolbar.findViewById(R.id.globile_toolbar_logo);
        if (it != null) {
            ImageView imageView = it;
            ViewExtensionKt.enable(it, enabled);
        }
    }

    public final void addOnClickListenerActionIcon(View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(onClickListener, "onClickListener");
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        ImageButton imageButton = (ImageButton) toolbar.findViewById(R.id.globile_action_icon);
        if (imageButton != null) {
            imageButton.setOnClickListener(onClickListener);
        }
    }

    public final void hideActionIcon() {
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        ImageButton it = (ImageButton) toolbar.findViewById(R.id.globile_action_icon);
        if (it != null) {
            ImageButton imageButton = it;
            ViewExtensionKt.enable(it, false);
        }
    }

    public final void setDrawerEnabled(boolean enabled) {
        int lockMode;
        if (enabled) {
            lockMode = 0;
        } else {
            lockMode = 1;
        }
        setNavigationDrawerEnabled(enabled);
        DrawerLayout drawerLayout = this.navigationDrawer;
        if (drawerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
        }
        drawerLayout.setDrawerLockMode(lockMode);
    }

    private final void setActionIcon(Integer resIconId) {
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        ImageButton it = (ImageButton) toolbar.findViewById(R.id.globile_action_icon);
        if (it != null) {
            ImageButton $this$apply = it;
            if (resIconId != null) {
                it.setVisibility(0);
                $this$apply.setImageResource(resIconId.intValue());
                return;
            }
            it.setVisibility(8);
        }
    }

    private final void setNavigationDrawerEnabled(boolean enabled) {
        Toolbar toolbar = this.customToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("customToolbar");
        }
        ImageButton it = (ImageButton) toolbar.findViewById(R.id.globile_drawer_icon);
        if (it != null) {
            ImageButton imageButton = it;
            ViewExtensionKt.enable(it, enabled);
        }
    }

    /* access modifiers changed from: private */
    public final void toggleNavigationDrawer() {
        if (this.navigationDrawer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
        }
        DrawerLayout drawerLayout = this.navigationDrawer;
        if (drawerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
        }
        if (drawerLayout.isDrawerOpen(8388613)) {
            DrawerLayout drawerLayout2 = this.navigationDrawer;
            if (drawerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
            }
            if (drawerLayout2 == null) {
                Intrinsics.throwNpe();
            }
            drawerLayout2.closeDrawer(8388613);
            return;
        }
        DrawerLayout drawerLayout3 = this.navigationDrawer;
        if (drawerLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
        }
        if (drawerLayout3 == null) {
            Intrinsics.throwNpe();
        }
        drawerLayout3.openDrawer(8388613);
    }

    public void onBackPressed() {
        DrawerLayout drawerLayout = this.navigationDrawer;
        if (drawerLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
        }
        if (drawerLayout != null) {
            DrawerLayout drawerLayout2 = this.navigationDrawer;
            if (drawerLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
            }
            if (drawerLayout2 == null) {
                Intrinsics.throwNpe();
            }
            if (drawerLayout2.isDrawerOpen(8388613)) {
                DrawerLayout drawerLayout3 = this.navigationDrawer;
                if (drawerLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationDrawer");
                }
                if (drawerLayout3 == null) {
                    Intrinsics.throwNpe();
                }
                drawerLayout3.closeDrawer(8388613);
                return;
            }
            GlobileActionBarActivity.super.onBackPressed();
            return;
        }
        GlobileActionBarActivity.super.onBackPressed();
    }
}
