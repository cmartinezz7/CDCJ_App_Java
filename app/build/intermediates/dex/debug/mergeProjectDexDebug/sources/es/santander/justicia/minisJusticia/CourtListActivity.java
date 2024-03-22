package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.adapters.CourtListAdapter;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.CourtSearcherController;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.interfaces.CourtSearcherCallback;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import es.santander.justicia.utils.Constants;
import java.util.ArrayList;

public class CourtListActivity extends MainActivity implements CourtSearcherCallback {
    private Context context;
    /* access modifiers changed from: private */
    public CourtListAdapter courtListAdapter;
    private ListView courtListView;
    private ProgressDialog dialog;

    /* JADX WARNING: type inference failed for: r4v2, types: [android.widget.TextView, es.santander.justicia.minisJusticia.views.QFontTextView] */
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getBaseContext();
        setTealiumName("/lista_juzgados");
        setContentView(R.layout.list_back_button_activity);
        Bundle extra = getIntent().getExtras();
        String province = "";
        String judicialEnvironment = "";
        if (extra != null) {
            province = extra.getString(Constants.PROVINCE);
            judicialEnvironment = extra.getString(Constants.JUDICIAL_ENVIRONMENT);
        }
        ((QFontTextView) findViewById(R.id.tv_toolbar_title)).setText(R.string.select_court_list);
        ((ImageButton) findViewById(R.id.buttonBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CourtListActivity.this.finish();
            }
        });
        this.courtListView = (ListView) findViewById(R.id.lv_list);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.dialog = progressDialog;
        progressDialog.setCancelable(false);
        this.dialog.setMessage(getResources().getString(R.string.loading_court_list));
        this.dialog.show();
        new CourtSearcherController(this).searchCourts(province, judicialEnvironment);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.CourtListActivity] */
    public void onFinishSearch(ArrayList<CourtDataDto> courtList, boolean success) {
        ProgressDialog progressDialog = this.dialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (!success || courtList.isEmpty()) {
            Intent intent = new Intent(this, NoResultsActivity.class);
            intent.putExtra(Constants.SCREEN_DESTINATION, Constants.SEARCHER_COURT_SCREEN);
            startActivity(intent);
            finish();
            return;
        }
        CourtListAdapter courtListAdapter2 = new CourtListAdapter(this.context, courtList);
        this.courtListAdapter = courtListAdapter2;
        this.courtListView.setAdapter(courtListAdapter2);
        this.courtListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, es.santander.justicia.minisJusticia.CourtListActivity] */
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String courtCode = CourtListActivity.this.courtListAdapter.getItem(position).getCourtCode();
                Intent intent = new Intent(CourtListActivity.this, MapsActivity.class);
                intent.putExtra(Constants.COURT_CODE, courtCode);
                CourtListActivity.this.startActivity(intent);
            }
        });
    }
}
