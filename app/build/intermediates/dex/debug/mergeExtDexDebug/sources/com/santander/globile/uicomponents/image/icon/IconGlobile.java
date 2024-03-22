package com.santander.globile.uicomponents.image.icon;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.ImageViewCompat;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.image.badgeview.BadgeFactory;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJT\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001b¨\u0006 "}, d2 = {"Lcom/santander/globile/uicomponents/image/icon/IconGlobile;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "createBadge", "", "textColor", "badgeBackgroundColor", "strokeColor", "width", "", "height", "textSize", "space", "shape", "badgeCount", "", "setBadge", "num", "theme", "Lcom/santander/globile/uicomponents/image/icon/BadgeType;", "size", "Lcom/santander/globile/uicomponents/image/icon/IconSize;", "setIcon", "icon", "iconColor", "Lcom/santander/globile/uicomponents/image/icon/IconColor;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: IconGlobile.kt */
public class IconGlobile extends ConstraintLayout {
    private HashMap _$_findViewCache;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[BadgeType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[BadgeType.PRIMARY.ordinal()] = 1;
            iArr[BadgeType.SECONDARY.ordinal()] = 2;
            iArr[BadgeType.DISABLED.ordinal()] = 3;
            int[] iArr2 = new int[IconSize.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[IconSize.SMALL.ordinal()] = 1;
            iArr2[IconSize.MEDIUM.ordinal()] = 2;
            iArr2[IconSize.BIG.ordinal()] = 3;
            int[] iArr3 = new int[IconColor.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[IconColor.BOSTON_RED.ordinal()] = 1;
            iArr3[IconColor.GREY.ordinal()] = 2;
            iArr3[IconColor.WHITE.ordinal()] = 3;
            int[] iArr4 = new int[IconSize.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[IconSize.SMALL.ordinal()] = 1;
            iArr4[IconSize.MEDIUM.ordinal()] = 2;
            iArr4[IconSize.BIG.ordinal()] = 3;
        }
    }

    public IconGlobile(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public IconGlobile(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.view.View, com.santander.globile.uicomponents.image.icon.IconGlobile] */
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
    public IconGlobile(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        LayoutInflater.from(context).inflate(R.layout.icon_globile, (ViewGroup) this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IconGlobile(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setBadge(int num, BadgeType theme, IconSize size) {
        int i = num;
        Intrinsics.checkParameterIsNotNull(theme, "theme");
        Intrinsics.checkParameterIsNotNull(size, "size");
        int backgroundBadgeColor = 0;
        int strokeColor = 0;
        int textBadgeColor = 0;
        float textSize = getResources().getDimension(R.dimen.badge_textsize_small);
        float width = getResources().getDimension(R.dimen.badge_width_small);
        float height = getResources().getDimension(R.dimen.badge_height_small);
        float space = getResources().getDimension(R.dimen.badge_space_small);
        float emptySize = getResources().getDimension(R.dimen.badge_empty_size_small);
        float emptySpace = getResources().getDimension(R.dimen.badge_empty_space_small);
        int i2 = WhenMappings.$EnumSwitchMapping$0[theme.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        backgroundBadgeColor = getResources().getColor(R.color.boston_red, (Resources.Theme) null);
                        strokeColor = getResources().getColor(R.color.white, (Resources.Theme) null);
                        textBadgeColor = getResources().getColor(R.color.white, (Resources.Theme) null);
                    } else {
                        backgroundBadgeColor = getResources().getColor(R.color.boston_red);
                        strokeColor = getResources().getColor(R.color.white);
                        textBadgeColor = getResources().getColor(R.color.white);
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 23) {
                backgroundBadgeColor = getResources().getColor(R.color.white, (Resources.Theme) null);
                strokeColor = getResources().getColor(R.color.boston_red, (Resources.Theme) null);
                textBadgeColor = getResources().getColor(R.color.boston_red, (Resources.Theme) null);
            } else {
                backgroundBadgeColor = getResources().getColor(R.color.white);
                strokeColor = getResources().getColor(R.color.boston_red);
                textBadgeColor = getResources().getColor(R.color.boston_red);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            backgroundBadgeColor = getResources().getColor(R.color.boston_red, (Resources.Theme) null);
            strokeColor = getResources().getColor(R.color.white, (Resources.Theme) null);
            textBadgeColor = getResources().getColor(R.color.white, (Resources.Theme) null);
        } else {
            backgroundBadgeColor = getResources().getColor(R.color.boston_red);
            strokeColor = getResources().getColor(R.color.white);
            textBadgeColor = getResources().getColor(R.color.white);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[size.ordinal()];
        if (i3 == 1) {
            textSize = getResources().getDimension(R.dimen.badge_textsize_small);
            width = getResources().getDimension(R.dimen.badge_width_small);
            height = getResources().getDimension(R.dimen.badge_height_small);
            space = getResources().getDimension(R.dimen.badge_space_small);
            emptySize = getResources().getDimension(R.dimen.badge_empty_size_small);
            emptySpace = getResources().getDimension(R.dimen.badge_empty_space_small);
        } else if (i3 == 2) {
            textSize = getResources().getDimension(R.dimen.badge_textsize_medium);
            width = getResources().getDimension(R.dimen.badge_width_medium);
            height = getResources().getDimension(R.dimen.badge_height_medium);
            space = getResources().getDimension(R.dimen.badge_space_medium);
            emptySize = getResources().getDimension(R.dimen.badge_empty_size_medium);
            emptySpace = getResources().getDimension(R.dimen.badge_empty_space_medium);
        } else if (i3 == 3) {
            textSize = getResources().getDimension(R.dimen.badge_textsize_big);
            width = getResources().getDimension(R.dimen.badge_width_big);
            height = getResources().getDimension(R.dimen.badge_height_big);
            space = getResources().getDimension(R.dimen.badge_space_big);
            emptySize = getResources().getDimension(R.dimen.badge_empty_size_big);
            emptySpace = getResources().getDimension(R.dimen.badge_empty_space_big);
        }
        if (i <= 0) {
            createBadge$default(this, textBadgeColor, backgroundBadgeColor, strokeColor, emptySize, emptySize, 0.0f, emptySpace, 0, (String) null, 384, (Object) null);
        } else if (1 <= i && 9 >= i) {
            createBadge$default(this, textBadgeColor, backgroundBadgeColor, strokeColor, height, height, textSize, space, 0, String.valueOf(num), 128, (Object) null);
        } else if (10 <= i && 99 >= i) {
            createBadge(textBadgeColor, backgroundBadgeColor, strokeColor, width, height, textSize, space, 4, String.valueOf(num));
        } else if (i > 99) {
            createBadge(textBadgeColor, backgroundBadgeColor, strokeColor, width, height, textSize, space, 4, "99+");
        }
    }

    static /* synthetic */ void createBadge$default(IconGlobile iconGlobile, int i, int i2, int i3, float f, float f2, float f3, float f4, int i4, String str, int i5, Object obj) {
        String str2;
        int i6 = i5;
        if (obj == null) {
            int i7 = (i6 & 128) != 0 ? 1 : i4;
            if ((i6 & 256) != 0) {
                str2 = "0";
            } else {
                str2 = str;
            }
            iconGlobile.createBadge(i, i2, i3, f, f2, f3, f4, i7, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBadge");
    }

    private final void createBadge(int textColor, int badgeBackgroundColor, int strokeColor, float width, float height, float textSize, float space, int shape, String badgeCount) {
        BadgeFactory badgeFactory = BadgeFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        badgeFactory.create(context).setTextColor(textColor).setBadgeBackground(badgeBackgroundColor).setBadgeStroke(strokeColor).setWidthAndHeight((int) width, (int) height).setTextSize((int) textSize).setSpace((int) space, (int) space).setShape(shape).setBadgeGravity(8388661).setBadgeCount(badgeCount).bind((ImageView) _$_findCachedViewById(R.id.icon_image));
    }

    public final void setIcon(int icon, IconColor iconColor, IconSize size) {
        int color;
        int dimensionInDp;
        Intrinsics.checkParameterIsNotNull(iconColor, "iconColor");
        Intrinsics.checkParameterIsNotNull(size, "size");
        int i = WhenMappings.$EnumSwitchMapping$2[iconColor.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (Build.VERSION.SDK_INT >= 23) {
                    color = getResources().getColor(R.color.white, (Resources.Theme) null);
                } else {
                    color = getResources().getColor(R.color.white);
                }
            } else if (Build.VERSION.SDK_INT >= 23) {
                color = getResources().getColor(R.color.grey, (Resources.Theme) null);
            } else {
                color = getResources().getColor(R.color.grey);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            color = getResources().getColor(R.color.boston_red, (Resources.Theme) null);
        } else {
            color = getResources().getColor(R.color.boston_red);
        }
        ((ImageView) _$_findCachedViewById(R.id.icon_image)).setImageResource(icon);
        ImageViewCompat.setImageTintList((ImageView) _$_findCachedViewById(R.id.icon_image), ColorStateList.valueOf(color));
        int i2 = WhenMappings.$EnumSwitchMapping$3[size.ordinal()];
        if (i2 == 1) {
            dimensionInDp = (int) getResources().getDimension(R.dimen.icon_size_small);
        } else if (i2 == 2) {
            dimensionInDp = (int) getResources().getDimension(R.dimen.icon_size_medium);
        } else if (i2 == 3) {
            dimensionInDp = (int) getResources().getDimension(R.dimen.icon_size_big);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.icon_image);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "icon_image");
        imageView.getLayoutParams().height = dimensionInDp;
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.icon_image);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "icon_image");
        imageView2.getLayoutParams().width = dimensionInDp;
        ((ImageView) _$_findCachedViewById(R.id.icon_image)).requestLayout();
    }
}
