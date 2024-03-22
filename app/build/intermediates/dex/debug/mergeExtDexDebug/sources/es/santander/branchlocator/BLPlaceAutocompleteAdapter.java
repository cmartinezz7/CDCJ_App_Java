package es.santander.branchlocator;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class BLPlaceAutocompleteAdapter extends ArrayAdapter<AutocompletePrediction> implements Filterable {
    private static final CharacterStyle STYLE_BOLD = new StyleSpan(1);
    private static final String TAG = "PlaceAutoCompleteAd";
    private LatLngBounds latLngBounds;
    private PlacesClient placesClient;
    /* access modifiers changed from: private */
    public List<AutocompletePrediction> resultList;

    BLPlaceAutocompleteAdapter(Context context, PlacesClient placesClient2, LatLngBounds latLngBounds2) {
        super(context, R.layout.simple_expandable_list_item, 16908308);
        this.placesClient = placesClient2;
        this.latLngBounds = latLngBounds2;
    }

    /* access modifiers changed from: package-private */
    public void setBounds(LatLngBounds latLngBounds2) {
        this.latLngBounds = latLngBounds2;
    }

    public int getCount() {
        List<AutocompletePrediction> list = this.resultList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public AutocompletePrediction getItem(int position) {
        List<AutocompletePrediction> list = this.resultList;
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = super.getView(position, convertView, parent);
        AutocompletePrediction item = getItem(position);
        if (item != null) {
            CharacterStyle characterStyle = STYLE_BOLD;
            ((TextView) row.findViewById(16908308)).setText(item.getPrimaryText(characterStyle));
            ((TextView) row.findViewById(16908309)).setText(item.getSecondaryText(characterStyle));
        }
        return row;
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults results = new Filter.FilterResults();
                List<AutocompletePrediction> filterData = new ArrayList<>();
                if (charSequence != null) {
                    filterData = BLPlaceAutocompleteAdapter.this.getAutocomplete(charSequence);
                }
                results.values = filterData;
                if (filterData != null) {
                    results.count = filterData.size();
                } else {
                    results.count = 0;
                }
                return results;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence constraint, Filter.FilterResults results) {
                if (results == null || results.count <= 0) {
                    BLPlaceAutocompleteAdapter.this.notifyDataSetInvalidated();
                    return;
                }
                List unused = BLPlaceAutocompleteAdapter.this.resultList = (List) results.values;
                BLPlaceAutocompleteAdapter.this.notifyDataSetChanged();
            }

            public CharSequence convertResultToString(Object resultValue) {
                if (resultValue instanceof AutocompletePrediction) {
                    return ((AutocompletePrediction) resultValue).getFullText((CharacterStyle) null);
                }
                return super.convertResultToString(resultValue);
            }
        };
    }

    /* access modifiers changed from: private */
    public List<AutocompletePrediction> getAutocomplete(CharSequence constraint) {
        Task<FindAutocompletePredictionsResponse> results = this.placesClient.findAutocompletePredictions(FindAutocompletePredictionsRequest.builder().setQuery(constraint.toString()).setCountry("").setLocationBias(RectangularBounds.newInstance(this.latLngBounds)).setSessionToken(AutocompleteSessionToken.newInstance()).setTypeFilter(TypeFilter.ADDRESS).build());
        try {
            Tasks.await(results, 60, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
        }
        if (!results.isSuccessful() || results.getResult() == null) {
            return null;
        }
        return ((FindAutocompletePredictionsResponse) results.getResult()).getAutocompletePredictions();
    }
}
