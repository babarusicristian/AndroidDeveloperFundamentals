package cristian.babarusi.module4.recyclerview_sources;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cristian.babarusi.module4.R;

public class AndroidVersionsViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextViewAndroidTitle;
    private TextView mTextViewAndroidDescription;
    private ImageView mImageViewAndroidPicture;

    public AndroidVersionsViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextViewAndroidTitle = itemView.findViewById(R.id.textview_android_title);
        mTextViewAndroidDescription = itemView.findViewById(R.id.textview_android_description);
        mImageViewAndroidPicture = itemView.findViewById(R.id.imageview_android_picture);
    }

    public TextView getTextViewAndroidTitle() {
        return mTextViewAndroidTitle;
    }

    public void setTextViewAndroidTitle(TextView textViewAndroidTitle) {
        mTextViewAndroidTitle = textViewAndroidTitle;
    }

    public TextView getTextViewAndroidDescription() {
        return mTextViewAndroidDescription;
    }

    public void setTextViewAndroidDescription(TextView textViewAndroidDescription) {
        mTextViewAndroidDescription = textViewAndroidDescription;
    }

    public ImageView getImageViewAndroidPicture() {
        return mImageViewAndroidPicture;
    }

    public void setImageViewAndroidPicture(ImageView imageViewAndroidPicture) {
        mImageViewAndroidPicture = imageViewAndroidPicture;
    }
}
