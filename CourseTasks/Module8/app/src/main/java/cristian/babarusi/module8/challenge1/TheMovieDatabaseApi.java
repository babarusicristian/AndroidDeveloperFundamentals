package cristian.babarusi.module8.challenge1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDatabaseApi {

    //for titles of top rated
    @GET("top_rated")
    Call<MovieModelList> getTopRated(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

    //for total pages of top rated
    @GET("top_rated")
    Call<MovieModel> getTopRatedTotalPages(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

    //for titles of upcoming
    @GET("upcoming")
    Call<MovieModelList> getUpcoming(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

    //for total pages of upcoming
    @GET("upcoming")
    Call<MovieModel> getUpcomingTotalPages(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

    //for titles of now playing
    @GET("now_playing")
    Call<MovieModelList> getNowPlaying(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

    //for total pages of now playing
    @GET("now_playing")
    Call<MovieModel> getNowPlayingTotalPages(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer page);

}
