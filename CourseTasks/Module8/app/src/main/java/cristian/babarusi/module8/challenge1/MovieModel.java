package cristian.babarusi.module8.challenge1;

import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("title")
    private String mTitle;

    @SerializedName("total_pages")
    private int mTotalPages;

    public String getTitle() {
        return mTitle;
    }

    public int getTotalPages() {
        return mTotalPages;
    }
}
