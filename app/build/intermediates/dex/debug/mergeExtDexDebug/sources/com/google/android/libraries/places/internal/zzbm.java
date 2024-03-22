package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.libraries.places.internal.zzcq;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
abstract class zzbm<TypeT, RequestT extends zzcq> extends zzak<TypeT, RequestT> {
    private final Locale zza;
    private final String zzb;
    private final boolean zzc;
    private final zzcu zzd;

    protected zzbm(RequestT requestt, Locale locale, String str, boolean z, zzcu zzcu) {
        super(requestt);
        this.zza = locale;
        this.zzb = str;
        this.zzc = z;
        this.zzd = zzcu;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> zze();

    /* access modifiers changed from: protected */
    public abstract String zzf();

    protected static void zza(Map<String, String> map, String str, Object obj, Object obj2) {
        String str2;
        if (obj != null) {
            str2 = obj.toString();
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> zzc() {
        HashMap hashMap = new HashMap();
        hashMap.put("X-Android-Package", this.zzd.zzb());
        hashMap.put("X-Android-Cert", this.zzd.zza());
        String valueOf = String.valueOf("2.0.0");
        String valueOf2 = String.valueOf(this.zzc ? ".compat" : "");
        hashMap.put("X-Places-Android-Sdk", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public final String zzd() {
        String str;
        Uri.Builder buildUpon = Uri.parse("https://maps.googleapis.com/").buildUpon();
        buildUpon.appendEncodedPath("maps/api/place/");
        buildUpon.appendEncodedPath(zzf());
        buildUpon.appendQueryParameter("key", this.zzb);
        Locale locale = this.zza;
        if (locale != null) {
            if (Build.VERSION.SDK_INT < 21) {
                StringBuilder sb = new StringBuilder();
                String language = locale.getLanguage();
                if (!TextUtils.isEmpty(language)) {
                    sb.append(language);
                    String country = locale.getCountry();
                    if (!TextUtils.isEmpty(country)) {
                        sb.append("-").append(country);
                    }
                }
                str = sb.toString();
            } else {
                str = locale.toLanguageTag();
            }
            if (!TextUtils.isEmpty(str)) {
                buildUpon.appendQueryParameter("language", str);
            }
        }
        for (Map.Entry next : zze().entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return buildUpon.build().toString();
    }
}
