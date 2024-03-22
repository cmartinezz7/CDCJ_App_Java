package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.utils.Constants;

public class NoResultsActivity extends MainActivity {
    private Button btnNewSearch;
    /* access modifiers changed from: private */
    public Intent intent;
    private String screenDestination = "";

    /* JADX WARNING: type inference failed for: r8v0, types: [es.santander.justicia.minisJusticia.common.activity.MainActivity, android.content.Context, es.santander.justicia.minisJusticia.NoResultsActivity] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.responsive_no_results);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.screenDestination = extras.getString(Constants.SCREEN_DESTINATION);
        }
        TextView toolBarTitle = (TextView) findViewById(R.id.tv_toolbar_title);
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NoResultsActivity.this.finish();
            }
        });
        this.btnNewSearch = (Button) findViewById(R.id.btn_new_search);
        String str = this.screenDestination;
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 11410171) {
            if (hashCode == 1913147970 && str.equals(Constants.SEARCHER_COURT_SCREEN)) {
                c = 1;
            }
        } else if (str.equals(Constants.SEARCH_FILES_SCREEN)) {
            c = 0;
        }
        if (c == 1) {
            toolBarTitle.setText(R.string.court_list);
            this.intent = new Intent(this, CourtSearcherActivityV2.class);
        }
        this.btnNewSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NoResultsActivity noResultsActivity = NoResultsActivity.this;
                noResultsActivity.startActivity(noResultsActivity.intent);
                NoResultsActivity.this.finish();
            }
        });
    }
}
