package com.google.android.libraries.places.internal;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import java.util.ArrayList;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
public final class zzew extends DefaultItemAnimator {
    final ArrayList<RecyclerView.ViewHolder> zza = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> zzb = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> zzc = new ArrayList<>();
    private final int zzd;

    public zzew(Resources resources) {
        this.zzd = resources.getDimensionPixelSize(R.dimen.places_autocomplete_vertical_dropdown);
    }

    public final boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        try {
            endAnimation(viewHolder);
            ViewCompat.setAlpha(viewHolder.itemView, 0.0f);
            if (!(viewHolder instanceof zzex) || !((zzex) viewHolder).zzb()) {
                this.zzc.add(viewHolder);
                return true;
            }
            this.zzb.add(viewHolder);
            return true;
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void endAnimation(RecyclerView.ViewHolder viewHolder) {
        try {
            zzew.super.endAnimation(viewHolder);
            View view = viewHolder.itemView;
            if (this.zzb.remove(viewHolder)) {
                zza(view);
                dispatchAddFinished(viewHolder);
            }
            zza();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final boolean isRunning() {
        try {
            return zzew.super.isRunning() || !this.zzb.isEmpty() || !this.zza.isEmpty();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void endAnimations() {
        try {
            for (int size = this.zzb.size() - 1; size >= 0; size--) {
                RecyclerView.ViewHolder viewHolder = this.zzb.get(size);
                zza(viewHolder.itemView);
                dispatchAddFinished(viewHolder);
                this.zzb.remove(size);
            }
            ArrayList<RecyclerView.ViewHolder> arrayList = this.zza;
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                arrayList.get(size2).itemView.animate().cancel();
            }
            zzew.super.endAnimations();
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    public final void runPendingAnimations() {
        try {
            ArrayList arrayList = this.zzc;
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                zzew.super.animateAdd((RecyclerView.ViewHolder) obj);
            }
            this.zzc.clear();
            zzew.super.runPendingAnimations();
            if (!this.zzb.isEmpty()) {
                ArrayList arrayList2 = new ArrayList(this.zzb);
                this.zzb.clear();
                ArrayList arrayList3 = arrayList2;
                int size2 = arrayList3.size();
                while (i < size2) {
                    Object obj2 = arrayList3.get(i);
                    i++;
                    zzex zzex = (RecyclerView.ViewHolder) obj2;
                    View view = zzex.itemView;
                    this.zza.add(zzex);
                    long moveDuration = getMoveDuration();
                    if (zzex instanceof zzex) {
                        moveDuration += (long) (zzex.zza() * 67);
                    }
                    view.setTranslationY((float) (-this.zzd));
                    view.setAlpha(0.0f);
                    ViewPropertyAnimator animate = view.animate();
                    animate.cancel();
                    animate.translationY(0.0f).alpha(1.0f).setDuration(133).setInterpolator(new FastOutSlowInInterpolator()).setStartDelay(moveDuration);
                    animate.setListener(new zzev(this, view, zzex, animate)).start();
                }
            }
        } catch (Error | RuntimeException e) {
            zzdc.zza(e);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    public final void zza() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    /* access modifiers changed from: private */
    public static void zza(View view) {
        view.setAlpha(1.0f);
        view.setTranslationY(0.0f);
    }
}
