package com.example.tp1android

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class TmdbAPI {


}
interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): AffichageMovie

    @GET("trending/tv/week")
    suspend fun lastseries(@Query("api_key") api_key: String): AffichageSeries

    @GET("trending/person/week")
    suspend fun lastactors(@Query("api_key") api_key: String): AffichageActors

    @GET("search/movie")
    suspend fun searchmovies(@Query("api_key") api_key: String, @Query("query") keyword: String): AffichageMovie

    @GET("search/tv")
    suspend fun searchseries(@Query("api_key") api_key: String, @Query("query") keyword: String): AffichageSeries

    @GET("search/actors")
    suspend fun searchactors(@Query("api_key") api_key: String, @Query("query") keyword: String): AffichageActors

    @GET("movie/{id}?append_to_response=credits")
    suspend fun specificmovie(@Path("id") id: String, @Query("api_key") api_key: String): MovieDetails

    @GET("tv/{id}?append_to_response=credits")
    suspend fun specificserie(@Path("id") id: String, @Query("api_key") api_key: String): SerieDetails


}

val retrofit= Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build();

val api = retrofit.create(Api::class.java)


