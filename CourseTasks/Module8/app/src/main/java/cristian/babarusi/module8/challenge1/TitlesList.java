package cristian.babarusi.module8.challenge1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TitlesList {

    @SerializedName("results")
    private List<Titles> mTitlesList;

    public List<Titles> getTitlesList() {
        return mTitlesList;
    }

    public void setTitlesList(List<Titles> titlesList) {
        mTitlesList = titlesList;
    }
}
