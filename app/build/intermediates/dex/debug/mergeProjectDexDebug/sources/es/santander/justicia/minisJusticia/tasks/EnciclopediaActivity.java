package es.santander.justicia.minisJusticia.tasks;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment;

public class EnciclopediaActivity extends AppCompatActivity {
    private static final int CONTENT_VIEW_ID = 1010;

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, es.santander.justicia.minisJusticia.tasks.EnciclopediaActivity, androidx.appcompat.app.AppCompatActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        EnciclopediaActivity.super.onCreate(savedInstanceState);
        FrameLayout frame = new FrameLayout(this);
        frame.setId(CONTENT_VIEW_ID);
        setContentView(frame, new Toolbar.LayoutParams(-1, -1));
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(CONTENT_VIEW_ID, new EnciclopediaFragment()).commit();
        }
    }
}
