package cristian.babarusi.module4.recyclerview_sources;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import cristian.babarusi.module4.Challenge4Activity;
import cristian.babarusi.module4.R;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsViewHolder> {

    private Context mContext;
    private List<Destinations> mListDestinations;

    //constructor custom
    public DestinationsAdapter(List<Destinations> list, Context context) {
        mListDestinations = list;
        mContext = context;
    }

    //draw layout
    @NonNull
    @Override
    public DestinationsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.destinations_item,
                        viewGroup, false);
        return new DestinationsViewHolder(itemView);
    }

    //populate layout with items
    @Override
    public void onBindViewHolder(@NonNull DestinationsViewHolder destinationsViewHolder, int i) {
        Destinations currentDestination = mListDestinations.get(i);
        destinationsViewHolder.getTextViewTitle().setText(currentDestination.getTitle());
        destinationsViewHolder.getTextViewDescription().setText(currentDestination.getDescription());

        Glide.with(mContext).load(currentDestination.getPicture()).placeholder(R.drawable.android_1)
                .into(destinationsViewHolder.getImageViewPicture());
    }

    @Override
    public int getItemCount() {
        return mListDestinations.size();
    }
}
