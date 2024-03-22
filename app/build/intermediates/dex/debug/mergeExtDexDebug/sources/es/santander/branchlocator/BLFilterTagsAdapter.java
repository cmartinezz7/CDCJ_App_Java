package es.santander.branchlocator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class BLFilterTagsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<BLFilter> filters;

    public BLFilterTagsAdapter(Context context2, List<BLFilter> filters2) {
        this.filters = new ArrayList(filters2);
        this.context = context2;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_filter_tag, parent, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).bind(this.filters.get(position));
    }

    public int getItemCount() {
        return this.filters.size();
    }

    public void clear() {
        this.filters.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<BLFilter> list) {
        this.filters.addAll(list);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public void startFiltersActivity() {
        this.context.startActivity(new Intent(this.context, BLFiltersActivity.class));
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        BLTextView txtTag;

        MyViewHolder(View view) {
            super(view);
            setupUi(view);
            setupListeners(view);
        }

        /* access modifiers changed from: private */
        public void bind(BLFilter filter) {
            this.txtTag.setEnabled(true);
            this.txtTag.setText(filter.getName());
            this.txtTag.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MyViewHolder.this.txtTag.setEnabled(false);
                    BLFilterTagsAdapter.this.startFiltersActivity();
                }
            });
        }

        private void setupUi(View view) {
            this.txtTag = (BLTextView) view.findViewById(R.id.tag_text);
        }

        private void setupListeners(View view) {
        }
    }
}
