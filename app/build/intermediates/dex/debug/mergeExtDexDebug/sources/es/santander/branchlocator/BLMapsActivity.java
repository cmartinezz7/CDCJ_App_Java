package es.santander.branchlocator;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BLMapsActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        BLMapsActivity.super.onCreate(savedInstanceState);
        setContentView(R.layout.branch_locator_maps);
        initPermissionCheck();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [es.santander.branchlocator.BLMapsActivity, android.app.Activity] */
    private void initPermissionCheck() {
        try {
            if (!BLPermissionCheckHelper.hasPermission(this, "android.permission.ACCESS_FINE_LOCATION")) {
                BLPermissionCheckHelper.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
            } else {
                setPermissionOK();
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [es.santander.branchlocator.BLMapsActivity, android.app.Activity] */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (BLPermissionCheckHelper.hasPermission(this, "android.permission.ACCESS_FINE_LOCATION")) {
            setPermissionOK();
        } else {
            finish();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.content.Context, es.santander.branchlocator.BLMapsActivity] */
    private void setPermissionOK() {
        startActivity(new Intent(this, BLMapsLogicActivity.class), (getIntent() == null || getIntent().getExtras() == null) ? null : getIntent().getExtras());
        finish();
    }
}
