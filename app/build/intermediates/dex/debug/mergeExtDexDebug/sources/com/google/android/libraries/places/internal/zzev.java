package com.google.android.libraries.places.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzev extends AnimatorListenerAdapter {
    private final /* synthetic */ View zza;
    private final /* synthetic */ RecyclerView.ViewHolder zzb;
    private final /* synthetic */ ViewPropertyAnimator zzc;
    private final /* synthetic */ zzew zzd;

    zzev(zzew zzew, View view, RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator) {
        this.zzd = zzew;
        this.zza = view;
        this.zzb = viewHolder;
        this.zzc = viewPropertyAnimator;
    }

    public final void onAnimationStart(Animator animator) {
        try {
            this.zza.setAlpha(0.0f);
            this.zzd.dispatchAddStarting(this.zzb);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void onAnimationCancel(Animator animator) {
        try {
            zzew.zza(this.zza);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void onAnimationEnd(Animator animator) {
        try {
            this.zzc.setListener((Animator.AnimatorListener) null);
            this.zzd.dispatchAddFinished(this.zzb);
            this.zzd.zza.remove(this.zzb);
            this.zzd.zza();
            this.zzc.setStartDelay(0);
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }
}
