package au.edu.unsw.infs3634.tourismguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {
    public static final int SORT_METHOD_RATING_LOW = 1;
    public static final int SORT_METHOD_RATING_HIGH = 2;
    public static final int SORT_METHOD_PRICE_LOW = 3;
    public static final int SORT_METHOD_PRICE_HIGH = 4;

    private ArrayList<Attraction> mAttractions;
    private RecyclerViewClickListener mListener;
    private ArrayList<Attraction> mAttractionsFiltered;

    public ListAdapter(ArrayList<Attraction> attractions, RecyclerViewClickListener listener) {
        mAttractions = attractions;
        mListener = listener;
        mAttractionsFiltered = new ArrayList<>(attractions);
    }

    //This onClickListener takes the View and String name; Passed by the MainActivity
    public interface RecyclerViewClickListener {
        void onClick(View view, String name);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attractions_list_row, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Attraction attraction = mAttractions.get(position);
        holder.name.setText(attraction.getName());
        holder.rating.setText(attraction.getRating());
        holder.type.setText(attraction.getType());
        holder.location.setText(attraction.getLocation());
        holder.price.setText(attraction.getPrice());
        holder.icon.setImageResource(attraction.getIcon());
        holder.itemView.setTag(attraction.getName());
        holder.ratingBar.setRating(Float.parseFloat(attraction.getRating()));
    }

    @Override
    public int getItemCount() {
        return mAttractions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, type, rating, location, price;
        public ImageView icon;
        public RatingBar ratingBar;
        private RecyclerViewClickListener listener;

        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            location = itemView.findViewById(R.id.tvLocation);
            type = itemView.findViewById(R.id.tvType);
            rating = itemView.findViewById(R.id.tvRating);
            price = itemView.findViewById(R.id.tvPrice);
            icon = itemView.findViewById(R.id.ivIcon);
            ratingBar = itemView.findViewById(R.id.rbRating);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                ArrayList<Attraction> filteredList = new ArrayList<>();

                if (charString.isEmpty()) {
                    filteredList = mAttractionsFiltered;
                } else {
                    for (Attraction attraction: mAttractions) {
                        if (attraction.getName().toLowerCase().contains(charString.toLowerCase().trim())) {
                            filteredList.add(attraction);
                        }
                    }
                    //mAttractionsFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;

                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mAttractions.clear();
                mAttractions.addAll((ArrayList<Attraction>) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public void sort (final int sortMethod){
        if (mAttractions.size() > 0) {
            Collections.sort(mAttractions, new Comparator<Attraction>() {
                @Override
                public int compare(Attraction o1, Attraction o2) {
                    if (sortMethod == SORT_METHOD_RATING_LOW) {
                        return o1.getRating().compareTo(o2.getRating());
                    }
                    else if (sortMethod == SORT_METHOD_RATING_HIGH) {
                        return o2.getRating().compareTo(o1.getRating());
                    }
                    else if (sortMethod == SORT_METHOD_PRICE_LOW) {
                        return o1.getPrice().compareTo(o2.getPrice());
                    }
                    else if (sortMethod == SORT_METHOD_PRICE_HIGH) {
                        return o2.getPrice().compareTo(o1.getPrice());
                    }
                    return o2.getRating().compareTo(o1.getRating());
                }
            });
        }
        notifyDataSetChanged(); //Refreshes RecyclerView
    }


}
