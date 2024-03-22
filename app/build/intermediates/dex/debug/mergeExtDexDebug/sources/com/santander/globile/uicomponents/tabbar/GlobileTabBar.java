package com.santander.globile.uicomponents.tabbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.tabbar.listeners.TabBarListener;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0016J\"\u0010%\u001a\u00020!2\b\u0010\u001d\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bH\u0002J\u000e\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u000bJ\u000e\u0010,\u001a\u00020!2\u0006\u0010)\u001a\u00020\bJ\u000e\u0010-\u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010.\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/santander/globile/uicomponents/tabbar/GlobileTabBar;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enableIndicator", "", "enableListener", "getEnableListener", "()Z", "setEnableListener", "(Z)V", "mBottomNavigationMenuView", "Lcom/google/android/material/bottomnavigation/BottomNavigationMenuView;", "position", "getPosition", "()I", "setPosition", "(I)V", "tabBarListener", "Lcom/santander/globile/uicomponents/tabbar/listeners/TabBarListener;", "addBadgeView", "Landroid/view/View;", "resId", "itemView", "Lcom/google/android/material/bottomnavigation/BottomNavigationItemView;", "getItemView", "initIndicator", "", "onNavigationItemSelected", "menuItem", "Landroid/view/MenuItem;", "setAccessibilityNotification", "Landroid/widget/TextView;", "quantityText", "", "id", "setIndicatorEnabled", "enabled", "setItemSelect", "setListener", "setNotificationBadge", "quantity", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTabBar.kt */
public final class GlobileTabBar extends BottomNavigationView implements BottomNavigationView.OnNavigationItemSelectedListener {
    private HashMap _$_findViewCache;
    private boolean enableIndicator;
    private boolean enableListener;
    private BottomNavigationMenuView mBottomNavigationMenuView;
    private int position;
    private TabBarListener tabBarListener;

    public GlobileTabBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileTabBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileTabBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Drawable drawable;
        int i;
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.enableListener = true;
        this.enableIndicator = true;
        setItemTextAppearanceActive(R.style.SantanderTextViewAppearance);
        if (Build.VERSION.SDK_INT >= 21) {
            drawable = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.top_tabbar_background_disable, (Resources.Theme) null));
        } else {
            drawable = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.top_tabbar_background_disable));
        }
        setBackground(drawable);
        if (getMenu().size() >= 5) {
            i = 2;
        } else {
            i = 1;
        }
        setLabelVisibilityMode(i);
        int[] colors = Build.VERSION.SDK_INT >= 23 ? new int[]{getResources().getColor(R.color.medium_grey, (Resources.Theme) null), getResources().getColor(R.color.santander_red, (Resources.Theme) null)} : new int[]{getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.santander_red)};
        int[][] states = {new int[]{16842910, -16842912}, new int[]{16842910, 16842912}};
        setItemTextColor(new ColorStateList(states, colors));
        setItemIconTintList(new ColorStateList(states, colors));
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.GlobileTabBar, 0, 0);
        this.enableIndicator = attributes.getBoolean(R.styleable.GlobileTabBar_enableIndicator, true);
        setOnNavigationItemSelectedListener(this);
        if (this.enableIndicator) {
            initIndicator();
        }
        attributes.recycle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileTabBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final boolean getEnableListener() {
        return this.enableListener;
    }

    public final void setEnableListener(boolean z) {
        this.enableListener = z;
    }

    private final void initIndicator() {
        BottomNavigationItemView itemView = getItemView(0);
        if (!itemView.isSelected()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            itemView.setBackground(getResources().getDrawable(R.drawable.top_tabbar_background_enable, (Resources.Theme) null));
        } else {
            itemView.setBackground(getResources().getDrawable(R.drawable.top_tabbar_background_enable));
        }
    }

    private final BottomNavigationItemView getItemView(int position2) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) childAt;
            this.mBottomNavigationMenuView = bottomNavigationMenuView;
            View v = bottomNavigationMenuView.getChildAt(position2);
            if (v != null) {
                return (BottomNavigationItemView) v;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationItemView");
        }
        throw new TypeCastException("null cannot be cast to non-null type com.google.android.material.bottomnavigation.BottomNavigationMenuView");
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        TabBarListener tabBarListener2;
        Drawable drawable;
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        int idMenuItem = menuItem.getItemId();
        if (this.enableIndicator) {
            BottomNavigationMenuView bottomNavigationMenuView = this.mBottomNavigationMenuView;
            if (bottomNavigationMenuView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBottomNavigationMenuView");
            }
            int childCount = bottomNavigationMenuView.getChildCount();
            for (int id = 0; id < childCount; id++) {
                BottomNavigationMenuView bottomNavigationMenuView2 = this.mBottomNavigationMenuView;
                if (bottomNavigationMenuView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomNavigationMenuView");
                }
                View childAt = bottomNavigationMenuView2.getChildAt(id);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "mBottomNavigationMenuView.getChildAt(id)");
                BottomNavigationMenuView bottomNavigationMenuView3 = this.mBottomNavigationMenuView;
                if (bottomNavigationMenuView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomNavigationMenuView");
                }
                View childAt2 = bottomNavigationMenuView3.getChildAt(id);
                Intrinsics.checkExpressionValueIsNotNull(childAt2, "mBottomNavigationMenuView.getChildAt(id)");
                if (childAt2.getId() == idMenuItem) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable = getResources().getDrawable(R.drawable.top_tabbar_background_enable, (Resources.Theme) null);
                    } else {
                        drawable = getResources().getDrawable(R.drawable.top_tabbar_background_enable);
                    }
                } else if (Build.VERSION.SDK_INT >= 21) {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    drawable = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.top_tabbar_background_disable, (Resources.Theme) null));
                } else {
                    Context context2 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                    drawable = DrawableCompat.wrap(context2.getResources().getDrawable(R.drawable.top_tabbar_background_disable));
                }
                childAt.setBackground(drawable);
            }
        }
        if (this.enableListener && (tabBarListener2 = this.tabBarListener) != null) {
            tabBarListener2.onTabBarSelectedItem(menuItem);
        }
        this.enableListener = true;
        return true;
    }

    public final void setIndicatorEnabled(boolean enabled) {
        Drawable drawable;
        this.enableIndicator = enabled;
        if (!enabled) {
            if (Build.VERSION.SDK_INT >= 21) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                drawable = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.top_tabbar_background_disable, (Resources.Theme) null));
            } else {
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                drawable = DrawableCompat.wrap(context2.getResources().getDrawable(R.drawable.top_tabbar_background_disable));
            }
            setItemBackground(drawable);
        }
    }

    public final void setNotificationBadge(int position2, int quantity) {
        BottomNavigationItemView itemView = getItemView(position2);
        if (quantity == 1) {
            addBadgeView(R.layout.notification_badge_empty, itemView);
        } else if (2 <= quantity && 9 >= quantity) {
            String quantityText = String.valueOf(quantity);
            addBadgeView(R.layout.notification_badge, itemView);
            setAccessibilityNotification((TextView) itemView.findViewById(R.id.badge_item), quantityText, itemView.getId());
        } else if (10 <= quantity && 99 >= quantity) {
            String quantityText2 = String.valueOf(quantity);
            addBadgeView(R.layout.notification_badge_long, itemView);
            setAccessibilityNotification((TextView) itemView.findViewById(R.id.badge_item_long), quantityText2, itemView.getId());
        } else {
            addBadgeView(R.layout.notification_badge_long, itemView);
            setAccessibilityNotification((TextView) itemView.findViewById(R.id.badge_item_long), "99+", itemView.getId());
        }
    }

    public final void setItemSelect(int id) {
        this.enableListener = false;
        setSelectedItemId(id);
    }

    private final View addBadgeView(int resId, BottomNavigationItemView itemView) {
        View inflate = LayoutInflater.from(getContext()).inflate(resId, itemView, true);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…te(resId, itemView, true)");
        return inflate;
    }

    private final void setAccessibilityNotification(TextView itemView, String quantityText, int id) {
        if (itemView != null) {
            itemView.setText(quantityText);
        }
        if (itemView != null) {
            itemView.setContentDescription(getResources().getString(R.string.badge_number_description, new Object[]{quantityText}));
        }
        if (itemView != null) {
            itemView.setLabelFor(id);
        }
    }

    public final void setListener(TabBarListener tabBarListener2) {
        Intrinsics.checkParameterIsNotNull(tabBarListener2, "tabBarListener");
        this.tabBarListener = tabBarListener2;
    }
}
