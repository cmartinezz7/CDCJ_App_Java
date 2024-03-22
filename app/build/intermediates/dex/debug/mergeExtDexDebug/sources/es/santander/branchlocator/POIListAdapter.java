package es.santander.branchlocator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class POIListAdapter extends RecyclerView.Adapter<POIsViewHolder> {
    BLRecyclerViewOnClickListener onClickListener;
    ArrayList<POIListItem> pois;

    public POIListAdapter(BLRecyclerViewOnClickListener onClickListener2, ArrayList<POIListItem> pois2) {
        this.pois = pois2;
        this.onClickListener = onClickListener2;
    }

    public POIsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new POIsViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.poi_list_item, viewGroup, false));
    }

    public void onBindViewHolder(POIsViewHolder viewHolder, int index) {
        viewHolder.title.setText(this.pois.get(index).title);
        viewHolder.subtitle.setText(this.pois.get(index).getSubtitleFormat());
        viewHolder.distance.setText(this.pois.get(index).distance);
    }

    public int getItemCount() {
        return this.pois.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        POIListAdapter.super.onAttachedToRecyclerView(recyclerView);
    }

    public class POIsViewHolder extends RecyclerView.ViewHolder {
        BLTextView distance;
        BLTextView subtitle;
        BLTextView title;

        POIsViewHolder(View itemView) {
            super(itemView);
            this.title = (BLTextView) itemView.findViewById(R.id.tvTitle);
            this.subtitle = (BLTextView) itemView.findViewById(R.id.tvSubtitle);
            this.distance = (BLTextView) itemView.findViewById(R.id.tvDistance);
            itemView.setOnClickListener(new View.OnClickListener(POIListAdapter.this) {
                public void onClick(View v) {
                    POIListAdapter.this.onClickListener.onClick(POIListAdapter.this.pois.get(POIsViewHolder.this.getAdapterPosition()));
                }
            });
        }
    }
}
