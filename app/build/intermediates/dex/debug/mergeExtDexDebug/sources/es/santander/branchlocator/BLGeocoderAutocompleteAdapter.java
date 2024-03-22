package es.santander.branchlocator;

import android.content.Context;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BLGeocoderAutocompleteAdapter extends ArrayAdapter<BLGeocoderAutoCompleteResult> implements Filterable {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public ArrayList<BLGeocoderAutoCompleteResult> resultList = new ArrayList<>();

    BLGeocoderAutocompleteAdapter(Context context2) {
        super(context2, 17367047, 16908308);
        this.context = context2;
    }

    public int getCount() {
        ArrayList<BLGeocoderAutoCompleteResult> arrayList = this.resultList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public BLGeocoderAutoCompleteResult getItem(int index) {
        ArrayList<BLGeocoderAutoCompleteResult> arrayList = this.resultList;
        if (arrayList != null) {
            return arrayList.get(index);
        }
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = super.getView(position, convertView, parent);
        BLGeocoderAutoCompleteResult item = getItem(position);
        if (item != null) {
            TextView textView1 = (TextView) row.findViewById(16908308);
            textView1.setText(item.getStreetAndNumber());
            ((TextView) row.findViewById(16908309)).setText(item.getLocaltyCountry());
            textView1.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return row;
    }

    public Filter getFilter() {
        return new Filter() {
            /* access modifiers changed from: protected */
            public Filter.FilterResults performFiltering(CharSequence constraint) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                if (constraint != null) {
                    BLGeocoderAutocompleteAdapter bLGeocoderAutocompleteAdapter = BLGeocoderAutocompleteAdapter.this;
                    List locations = bLGeocoderAutocompleteAdapter.findLocations(bLGeocoderAutocompleteAdapter.context, constraint.toString());
                    filterResults.values = locations;
                    filterResults.count = locations.size();
                }
                return filterResults;
            }

            /* access modifiers changed from: protected */
            public void publishResults(CharSequence constraint, Filter.FilterResults results) {
                if (results == null || results.count <= 0) {
                    BLGeocoderAutocompleteAdapter.this.notifyDataSetInvalidated();
                    return;
                }
                ArrayList unused = BLGeocoderAutocompleteAdapter.this.resultList = (ArrayList) results.values;
                BLGeocoderAutocompleteAdapter.this.notifyDataSetChanged();
            }
        };
    }

    /* access modifiers changed from: private */
    public List<BLGeocoderAutoCompleteResult> findLocations(Context context2, String query_text) {
        List<BLGeocoderAutoCompleteResult> searchResultList = new ArrayList<>();
        try {
            List<Address> addresses = new Geocoder(context2, context2.getResources().getConfiguration().locale).getFromLocationName(query_text, 20);
            for (int i = 0; i < addresses.size(); i++) {
                Address address = addresses.get(i);
                if (address.getMaxAddressLineIndex() != -1) {
                    searchResultList.add(new BLGeocoderAutoCompleteResult(address));
                }
            }
        } catch (IOException e) {
        }
        return searchResultList;
    }
}
