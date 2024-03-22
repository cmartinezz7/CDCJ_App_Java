package com.tealium.internal.c;

import android.app.Activity;
import com.tealium.internal.listeners.ActivityResumeListener;

public class b extends j<ActivityResumeListener> {
    private final Activity a;

    public b(Activity activity) {
        super(ActivityResumeListener.class);
        this.a = activity;
    }

    public void a(ActivityResumeListener activityResumeListener) {
        activityResumeListener.onActivityResume(this.a);
    }
}
