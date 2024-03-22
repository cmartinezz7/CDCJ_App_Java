package es.santander.branchlocator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class BLFiltersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */
    public BLFontManager BLFontManager;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public List<BLFilterItem> filters;

    public BLFiltersAdapter(Context context2, List<BLFilterItem> filters2) {
        this.filters = filters2;
        this.context = context2;
    }

    public int getItemViewType(int position) {
        return this.filters.get(position).getBLFilterType().ordinal();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new FilterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_filter, parent, false));
        }
        if (viewType != 1) {
            return new FilterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_filter, parent, false));
        }
        return new HeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_header_filter, parent, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BLFilterItem item = this.filters.get(position);
        if (item.getBLFilterType() == BLFilterType.NORMAL) {
            ((FilterViewHolder) holder).bind(this.filters.get(position).getFilter());
        } else if (item.getBLFilterType() == BLFilterType.TITLE) {
            ((HeaderViewHolder) holder).bind(this.filters.get(position).getFilterTitle());
        }
    }

    public int getItemCount() {
        return this.filters.size();
    }

    public void deselectAll() {
        for (BLFilterItem filter : this.filters) {
            if (filter.getBLFilterType() == BLFilterType.NORMAL) {
                filter.getFilter().setSelected(false);
            }
        }
        notifyDataSetChanged();
    }

    public List<BLFilter> getSelectedFilters() {
        List<BLFilter> filters2 = getAllFilters();
        List<BLFilter> selectedFilters = new ArrayList<>();
        for (BLFilter filter : filters2) {
            if (filter.isSelected()) {
                selectedFilters.add(filter);
            }
        }
        return selectedFilters;
    }

    public List<BLFilter> getAllFilters() {
        List<BLFilter> filtersWithoutHeader = new ArrayList<>();
        for (BLFilterItem filter : this.filters) {
            if (filter.getBLFilterType() == BLFilterType.NORMAL) {
                filtersWithoutHeader.add(filter.getFilter());
            }
        }
        return filtersWithoutHeader;
    }

    public void clear() {
        this.filters.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<BLFilterItem> list) {
        this.filters.addAll(list);
        notifyDataSetChanged();
    }

    private class FilterViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFilter;
        private RelativeLayout imgFilterBackground;
        private BLTextView txtTitle;

        FilterViewHolder(View view) {
            super(view);
            setupUi(view);
            setupListeners(view);
        }

        /* access modifiers changed from: private */
        public void bind(BLFilter filter) {
            if (filter != null) {
                BLFontManager unused = BLFiltersAdapter.this.BLFontManager = new BLFontManager(BLFiltersAdapter.this.context);
                this.txtTitle.setText(filter.getName());
                if (filter.isSelected()) {
                    selectFilter(filter);
                } else {
                    deselectFilter(filter);
                }
            }
        }

        private void selectFilter(BLFilter filter) {
            BLUtils.setBackground(this.imgFilterBackground, BLFiltersAdapter.this.context, R.drawable.bl_square_red);
            if (filter.getCode() != 5) {
                this.imgFilter.setImageDrawable(ResourcesCompat.getDrawable(BLFiltersAdapter.this.context.getResources(), filter.getImage(), (Resources.Theme) null));
                this.imgFilter.setColorFilter(ContextCompat.getColor(BLFiltersAdapter.this.context, R.color.santander_red), PorterDuff.Mode.SRC_IN);
            } else {
                this.imgFilter.setImageDrawable(ContextCompat.getDrawable(BLFiltersAdapter.this.context, R.drawable.bl_ic_workcafe));
                this.imgFilter.setColorFilter((ColorFilter) null);
            }
            BLFiltersAdapter.this.BLFontManager.inserTypeFont(this.txtTitle, BLConstants.BOLD_FONT);
        }

        private void deselectFilter(BLFilter filter) {
            BLUtils.setBackground(this.imgFilterBackground, BLFiltersAdapter.this.context, R.drawable.bl_square_grey_transparent);
            if (filter.getImage() == R.drawable.bl_ic_active) {
                this.imgFilter.setImageDrawable((Drawable) null);
            } else {
                this.imgFilter.setImageDrawable(ResourcesCompat.getDrawable(BLFiltersAdapter.this.context.getResources(), filter.getImage(), (Resources.Theme) null));
                this.imgFilter.setColorFilter(ContextCompat.getColor(BLFiltersAdapter.this.context, R.color.light_grey), PorterDuff.Mode.SRC_IN);
            }
            BLFiltersAdapter.this.BLFontManager.inserTypeFont(this.txtTitle, BLConstants.DEFAULT_FONT);
        }

        private void setupUi(View view) {
            this.imgFilterBackground = (RelativeLayout) view.findViewById(R.id.cell_filter_img_background);
            this.imgFilter = (ImageView) view.findViewById(R.id.cell_filter_img);
            this.txtTitle = (BLTextView) view.findViewById(R.id.cell_filter_txt_title);
        }

        private void setupListeners(View view) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int position = FilterViewHolder.this.getAdapterPosition();
                    ((BLFilterItem) BLFiltersAdapter.this.filters.get(position)).getFilter().setSelected(!((BLFilterItem) BLFiltersAdapter.this.filters.get(position)).getFilter().isSelected());
                    BLFiltersAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        private BLTextView filterHeader;

        HeaderViewHolder(View view) {
            super(view);
            setupUi(view);
        }

        /* access modifiers changed from: private */
        public void bind(String title) {
            this.filterHeader.setText(title);
        }

        private void setupUi(View view) {
            this.filterHeader = (BLTextView) view.findViewById(R.id.cell_header_filter_title);
        }
    }
}
