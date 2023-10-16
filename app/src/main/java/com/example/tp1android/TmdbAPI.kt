package com.example.tp1android

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
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
    suspend fun searchmovies(@Query("api_key") api_key: String): AffichageMovie

}

val retrofit= Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build();

val api = retrofit.create(Api::class.java)


