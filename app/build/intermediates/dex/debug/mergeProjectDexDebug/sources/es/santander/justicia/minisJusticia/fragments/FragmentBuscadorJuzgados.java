package es.santander.justicia.minisJusticia.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados;
import es.santander.justicia.minisJusticia.ActivitySearchTribunals;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontButton;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;
import java.util.ArrayList;

public class FragmentBuscadorJuzgados extends ActivityHomeLetrados.PlaceholderFragment {
    /* access modifiers changed from: private */
    public String mCodEnvironment;
    /* access modifiers changed from: private */
    public String mCodProvincia;
    private Spinner mSpinnerEnvironment;
    private Spinner mSpinnerProvices;
    private QFontButton mTextSearch;

    public void onStart() {
        super.onStart();
        TealiumHelper.trackView("/busqueda_juzgado");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_buscador_juzgados, container, false);
        this.mSpinnerProvices = (Spinner) viewGroup.findViewById(R.id.spinner_provices);
        this.mSpinnerEnvironment = (Spinner) viewGroup.findViewById(R.id.spinner_environment);
        this.mTextSearch = (QFontButton) viewGroup.findViewById(R.id.text_buscar);
        initUi();
        return viewGroup;
    }

    private void initUi() {
        final ArrayList<SpinnerValuesDTO> spinnerProvinces = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_PROVINCES);
        ArrayAdapter<SpinnerValuesDTO> arrayProvinces = new ArrayAdapter<>(getActivity(), R.layout.simple_spinner_item, R.id.text_spinner, spinnerProvinces);
        arrayProvinces.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinnerProvices.setAdapter(arrayProvinces);
        this.mSpinnerProvices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = FragmentBuscadorJuzgados.this.mCodProvincia = ((SpinnerValuesDTO) spinnerProvinces.get(position)).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        final ArrayList<SpinnerValuesDTO> spinerEnvironment = SpinnerContentModel.getSpinnerValues(InitConfigConstants.SPN_JUDICIAL_ENVIRONMENT);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.simple_spinner_item, R.id.text_spinner, spinerEnvironment);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item_down);
        this.mSpinnerEnvironment.setAdapter(arrayAdapter);
        this.mSpinnerEnvironment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String unused = FragmentBuscadorJuzgados.this.mCodEnvironment = ((SpinnerValuesDTO) spinerEnvironment.get(position)).getCode();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.mTextSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FragmentBuscadorJuzgados.this.getActivity(), ActivitySearchTribunals.class);
                intent.putExtra(Constants.EXTRA_COD_PROVINCIA, FragmentBuscadorJuzgados.this.mCodProvincia);
                intent.putExtra(Constants.EXTRA_COD_ENTORNO_JUDICIAL, FragmentBuscadorJuzgados.this.mCodEnvironment);
                FragmentBuscadorJuzgados.this.startActivity(intent);
            }
        });
    }
}
