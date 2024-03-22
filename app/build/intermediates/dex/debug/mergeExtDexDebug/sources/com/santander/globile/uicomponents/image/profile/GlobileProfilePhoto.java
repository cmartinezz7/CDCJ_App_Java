package com.santander.globile.uicomponents.image.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.image.badgeview.BadgeFactory;
import com.santander.globile.uicomponents.image.badgeview.GlobileBadgeNumber;
import com.santander.globile.uicomponents.text.SantanderTextView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JV\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020!2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u0015H\u0002J\u001f\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u00152\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00101J\u001f\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u00152\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00101J\u001f\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u00106R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000e¨\u00067"}, d2 = {"Lcom/santander/globile/uicomponents/image/profile/GlobileProfilePhoto;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "badgeHeight", "", "getBadgeHeight", "()F", "setBadgeHeight", "(F)V", "badgeShape", "getBadgeShape", "()I", "setBadgeShape", "(I)V", "badgeText", "", "getBadgeText", "()Ljava/lang/String;", "setBadgeText", "(Ljava/lang/String;)V", "badgeWidth", "getBadgeWidth", "setBadgeWidth", "textSize", "getTextSize", "setTextSize", "addAccessibilityText", "", "createBadge", "textColor", "badgeBackgroundColor", "strokeColor", "width", "height", "shape", "badgeCount", "view", "Landroid/view/View;", "prepareBadge", "readMessageToAccessibility", "message", "setInitials", "initials", "(Ljava/lang/String;Ljava/lang/Integer;)V", "setInitialsWithName", "name", "setProfilePhoto", "photo", "(ILjava/lang/Integer;)V", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileProfilePhoto.kt */
public final class GlobileProfilePhoto extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private float badgeHeight;
    private int badgeShape;
    private String badgeText;
    private float badgeWidth;
    private float textSize;

    public GlobileProfilePhoto(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileProfilePhoto(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.santander.globile.uicomponents.image.profile.GlobileProfilePhoto, android.view.View] */
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
    public GlobileProfilePhoto(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.badgeText = "";
        this.badgeShape = 1;
        LayoutInflater.from(context).inflate(R.layout.profile_photo_globile, (ViewGroup) this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileProfilePhoto(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getBadgeText() {
        return this.badgeText;
    }

    public final void setBadgeText(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.badgeText = str;
    }

    public final int getBadgeShape() {
        return this.badgeShape;
    }

    public final void setBadgeShape(int i) {
        this.badgeShape = i;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f) {
        this.textSize = f;
    }

    public final float getBadgeWidth() {
        return this.badgeWidth;
    }

    public final void setBadgeWidth(float f) {
        this.badgeWidth = f;
    }

    public final float getBadgeHeight() {
        return this.badgeHeight;
    }

    public final void setBadgeHeight(float f) {
        this.badgeHeight = f;
    }

    public static /* synthetic */ void setProfilePhoto$default(GlobileProfilePhoto globileProfilePhoto, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        globileProfilePhoto.setProfilePhoto(i, num);
    }

    public final void setProfilePhoto(int photo, Integer badgeCount) {
        ((CircleImageView) _$_findCachedViewById(R.id.profile_image)).setImageResource(photo);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "profile_initials");
        santanderTextView.setVisibility(8);
        if (badgeCount != null) {
            int it = badgeCount.intValue();
            CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.profile_image);
            Intrinsics.checkExpressionValueIsNotNull(circleImageView, "profile_image");
            prepareBadge(it, circleImageView);
        }
    }

    private final void readMessageToAccessibility(String message) {
        Toast toast = Toast.makeText(getContext(), message, 0);
        Intrinsics.checkExpressionValueIsNotNull(toast, "toast");
        View view = toast.getView();
        Intrinsics.checkExpressionValueIsNotNull(view, "toast.view");
        view.setVisibility(8);
        toast.show();
    }

    public static /* synthetic */ void setInitials$default(GlobileProfilePhoto globileProfilePhoto, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        globileProfilePhoto.setInitials(str, num);
    }

    public final void setInitials(String initials, Integer badgeCount) {
        CharSequence charSequence;
        Intrinsics.checkParameterIsNotNull(initials, "initials");
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.profile_image);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "profile_image");
        circleImageView.setVisibility(8);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "profile_initials");
        if (initials.length() > 2) {
            String substring = initials.substring(0, 2);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            if (substring != null) {
                String upperCase = substring.toUpperCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                charSequence = upperCase;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.getDefault()");
            String upperCase2 = initials.toUpperCase(locale2);
            Intrinsics.checkExpressionValueIsNotNull(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
            charSequence = upperCase2;
        }
        santanderTextView.setText(charSequence);
        if (badgeCount != null) {
            int it = badgeCount.intValue();
            SantanderTextView santanderTextView2 = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "profile_initials");
            prepareBadge(it, (View) santanderTextView2);
        }
    }

    public static /* synthetic */ void setInitialsWithName$default(GlobileProfilePhoto globileProfilePhoto, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        globileProfilePhoto.setInitialsWithName(str, num);
    }

    public final void setInitialsWithName(String name, Integer badgeCount) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.profile_image);
        Intrinsics.checkExpressionValueIsNotNull(circleImageView, "profile_image");
        circleImageView.setVisibility(8);
        String obj = StringsKt.trimEnd((CharSequence) name).toString();
        if (obj != null) {
            List split = StringsKt.split$default((CharSequence) StringsKt.trimStart((CharSequence) obj).toString(), new String[]{" "}, false, 0, 6, (Object) null);
            if (!StringsKt.isBlank((CharSequence) split.get(0))) {
                String initials = "";
                if (split.size() == 1) {
                    initials = String.valueOf(StringsKt.first((CharSequence) split.get(0)));
                } else if (split.size() >= 2) {
                    initials = String.valueOf(StringsKt.first((CharSequence) split.get(0))) + StringsKt.first((CharSequence) split.get(split.size() - 1));
                }
                SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
                Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "profile_initials");
                Locale locale = Locale.getDefault();
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
                if (initials != null) {
                    String upperCase = initials.toUpperCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    santanderTextView.setText(upperCase);
                    if (badgeCount != null) {
                        int it = badgeCount.intValue();
                        SantanderTextView santanderTextView2 = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
                        Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "profile_initials");
                        prepareBadge(it, (View) santanderTextView2);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    private final void prepareBadge(int badgeCount, View view) {
        if (badgeCount <= 0) {
            this.badgeShape = 1;
            this.textSize = 0.0f;
            this.badgeWidth = getResources().getDimension(R.dimen.profile_badge_size_empty);
            this.badgeHeight = getResources().getDimension(R.dimen.profile_badge_size_empty);
        } else if (1 <= badgeCount && 9 >= badgeCount) {
            String valueOf = String.valueOf(badgeCount);
            this.badgeText = valueOf;
            addAccessibilityText(valueOf);
            this.badgeShape = 1;
            this.textSize = getResources().getDimension(R.dimen.profile_badge_text_size);
            this.badgeWidth = getResources().getDimension(R.dimen.profile_badge_height);
            this.badgeHeight = getResources().getDimension(R.dimen.profile_badge_height);
        } else if (10 <= badgeCount && 99 >= badgeCount) {
            String valueOf2 = String.valueOf(badgeCount);
            this.badgeText = valueOf2;
            addAccessibilityText(valueOf2);
            this.badgeShape = 4;
            this.textSize = getResources().getDimension(R.dimen.profile_badge_text_size);
            this.badgeWidth = getResources().getDimension(R.dimen.profile_badge_width);
            this.badgeHeight = getResources().getDimension(R.dimen.profile_badge_height);
        } else if (badgeCount > 99) {
            this.badgeText = "99+";
            addAccessibilityText("99+");
            this.badgeShape = 4;
            this.textSize = getResources().getDimension(R.dimen.profile_badge_text_size);
            this.badgeWidth = getResources().getDimension(R.dimen.profile_badge_width);
            this.badgeHeight = getResources().getDimension(R.dimen.profile_badge_height);
        }
        createBadge$default(this, 0, 0, 0, this.badgeWidth, this.badgeHeight, this.textSize, this.badgeShape, this.badgeText, view, 7, (Object) null);
    }

    private final void addAccessibilityText(String badgeText2) {
        String accessibilityMessage = "";
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "profile_initials");
        if (santanderTextView.getVisibility() != 8) {
            StringBuilder append = new StringBuilder().append(accessibilityMessage);
            SantanderTextView santanderTextView2 = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "profile_initials");
            accessibilityMessage = append.append(santanderTextView2.getText()).append(" for ").toString();
        }
        String accessibilityMessage2 = accessibilityMessage + getResources().getString(R.string.badge_number_description, new Object[]{badgeText2});
        setContentDescription(accessibilityMessage2);
        SantanderTextView santanderTextView3 = (SantanderTextView) _$_findCachedViewById(R.id.profile_initials);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView3, "profile_initials");
        santanderTextView3.setContentDescription(accessibilityMessage2);
    }

    static /* synthetic */ void createBadge$default(GlobileProfilePhoto globileProfilePhoto, int i, int i2, int i3, float f, float f2, float f3, int i4, String str, View view, int i5, Object obj) {
        int i6;
        int i7;
        int color = (i5 & 1) != 0 ? globileProfilePhoto.getResources().getColor(R.color.white) : i;
        if ((i5 & 2) != 0) {
            i6 = globileProfilePhoto.getResources().getColor(R.color.boston_red);
        } else {
            i6 = i2;
        }
        if ((i5 & 4) != 0) {
            i7 = globileProfilePhoto.getResources().getColor(R.color.boston_red);
        } else {
            i7 = i3;
        }
        globileProfilePhoto.createBadge(color, i6, i7, f, f2, f3, i4, str, view);
    }

    private final void createBadge(int textColor, int badgeBackgroundColor, int strokeColor, float width, float height, float textSize2, int shape, String badgeCount, View view) {
        BadgeFactory badgeFactory = BadgeFactory.INSTANCE;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        GlobileBadgeNumber textSize3 = badgeFactory.create(context).setTextColor(textColor).setBadgeBackground(badgeBackgroundColor).setBadgeStroke(strokeColor).setWidthAndHeight((int) width, (int) height).setTextSize((int) textSize2);
        int i = (int) 0.0f;
        textSize3.setSpace(i, i).setShape(shape).setBadgeGravity(8388661).setBadgeCount(badgeCount).bind(view);
    }
}
