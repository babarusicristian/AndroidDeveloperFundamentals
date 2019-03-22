package cristian.babarusi.module8.challenge1;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieModelList {

    @SerializedName("results")
    private List<MovieModel> mMovieModelList;

    public List<MovieModel> getMovieModelList() {
        return mMovieModelList;
    }

    public void setMovieModelList(List<MovieModel> movieModelList) {
        mMovieModelList = movieModelList;
    }
}
