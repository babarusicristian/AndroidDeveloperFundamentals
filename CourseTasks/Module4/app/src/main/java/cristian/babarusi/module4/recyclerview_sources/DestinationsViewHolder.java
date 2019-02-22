package cristian.babarusi.module4.recyclerview_sources;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cristian.babarusi.module4.R;

public class DestinationsViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextViewTitle;
    private TextView mTextViewDescription;
    private ImageView mImageViewPicture;

    public DestinationsViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewTitle = itemView.findViewById(R.id.textview_destination_title);
        mTextViewDescription = itemView.findViewById(R.id.textview_destination_description);
        mImageViewPicture = itemView.findViewById(R.id.imageview_destination_picture);
    }

    public TextView getTextViewTitle() {
        return mTextViewTitle;
    }

    public void setTextViewTitle(TextView textViewTitle) {
        mTextViewTitle = textViewTitle;
    }

    public TextView getTextViewDescription() {
        return mTextViewDescription;
    }

    public void setTextViewDescription(TextView textViewDescription) {
        mTextViewDescription = textViewDescription;
    }

    public ImageView getImageViewPicture() {
        return mImageViewPicture;
    }

    public void setImageViewPicture(ImageView imageViewPicture) {
        mImageViewPicture = imageViewPicture;
    }
}
