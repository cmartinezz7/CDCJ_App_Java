package es.santander.justicia.minisJusticia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import es.santander.justicia.minisJusticia.PopupActivity.1;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.enums.PopupTypeEnum;
import es.santander.justicia.minisJusticia.fragments.RequestCorrectlyPopupFragment;

public class PopupActivity extends MainActivity {
   private int popupId;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558428);
      Bundle extras = this.getIntent().getExtras();
      if (extras != null) {
         this.popupId = extras.getInt("popupName");
      }

      FragmentManager fragmentManager = this.getSupportFragmentManager();
      FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      Fragment fragment = null;
      PopupTypeEnum popupType = PopupTypeEnum.getPopupType(this.popupId);
      switch(1.$SwitchMap$es$santander$justicia$minisJusticia$enums$PopupTypeEnum[popupType.ordinal()]) {
      case 1:
         fragment = RequestCorrectlyPopupFragment.newInstance();
      default:
         if (fragment != null) {
            fragmentTransaction.replace(2131362207, fragment);
            fragmentTransaction.commit();
         }

      }
   }
}
