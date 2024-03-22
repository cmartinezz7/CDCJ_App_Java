package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.enums.PopupTypeEnum;
import es.santander.justicia.minisJusticia.fragments.RequestCorrectlyPopupFragment;
import es.santander.justicia.utils.Constants;

public class PopupActivity extends MainActivity {
    private int popupId;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_popup_dialog);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.popupId = extras.getInt(Constants.POPUP_NAME);
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        if (AnonymousClass1.$SwitchMap$es$santander$justicia$minisJusticia$enums$PopupTypeEnum[PopupTypeEnum.getPopupType(this.popupId).ordinal()] == 1) {
            fragment = RequestCorrectlyPopupFragment.newInstance();
        }
        if (fragment != null) {
            fragmentTransaction.replace(R.id.fragment_space, fragment);
            fragmentTransaction.commit();
        }
    }

    /* renamed from: es.santander.justicia.minisJusticia.PopupActivity$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$es$santander$justicia$minisJusticia$enums$PopupTypeEnum;

        static {
            int[] iArr = new int[PopupTypeEnum.values().length];
            $SwitchMap$es$santander$justicia$minisJusticia$enums$PopupTypeEnum = iArr;
            try {
                iArr[PopupTypeEnum.ACCESS_REQUEST_SENT_CORRECTLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }
}
