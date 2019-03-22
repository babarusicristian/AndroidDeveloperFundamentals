package cristian.babarusi.module8.challenge1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDatabaseApi {

    @GET("top_rated")
    Call<List<TitlesList>> getTopRated(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

    @GET("upcoming")
    Call<List<Titles>> getUpcoming(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

    @GET("now_playing")
    Call<List<Titles>> getNowPlaying(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

}
