package cristian.babarusi.module4.recyclerview_sources;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import cristian.babarusi.module4.R;

public class AndroidVersionsAdapter extends RecyclerView.Adapter<AndroidVersionsViewHolder> {

    Context mContext;
    List<AndroidVersions> mListAndroidVersions;

    public AndroidVersionsAdapter (List<AndroidVersions> list, Context context) {
        mListAndroidVersions = list;
        mContext = context;
    }

    //draw position of items
    @NonNull
    @Override
    public AndroidVersionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.android_item,
                        viewGroup, false);
        return new AndroidVersionsViewHolder(itemView);
    }

    //populate items
    @Override
    public void onBindViewHolder(@NonNull final AndroidVersionsViewHolder androidVersionsViewHolder, final int i) {
        AndroidVersions currentAndroidVersion = mListAndroidVersions.get(i);
        androidVersionsViewHolder.getTextViewAndroidTitle().setText(currentAndroidVersion.getTitle());
        androidVersionsViewHolder.getTextViewAndroidDescription().setText(currentAndroidVersion.getDescription());

        Glide.with(mContext).load(currentAndroidVersion.getPicture()).placeholder(R.drawable.android_1)
                .into(androidVersionsViewHolder.getImageViewAndroidPicture());

        androidVersionsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String itemClicked = mListAndroidVersions.get(i).getTitle(); //for the title of that item clicked
                Toast.makeText(mContext, "Clicked " + (i+1), Toast.LENGTH_SHORT).show();
            }
        });

        androidVersionsViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "Long clicked " + (i+1), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListAndroidVersions.size();
    }
}
