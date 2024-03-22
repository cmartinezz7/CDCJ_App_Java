package es.santander.justicia.minisJusticia.adapters;

import android.widget.Filter;
import androidx.annotation.NonNull;

public interface InterfaceExpandable {
   @NonNull
   Filter getFilter();
}
