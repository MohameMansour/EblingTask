package com.dro.eblingtask.network

import com.dro.eblingtask.home.TrendMovieModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET(Urls.TREND_MOVIES)
    suspend fun trendMovies(
        @Query("api_key") apiKey: String,
        @Query("sort_by") sortBy : String?,
        @Query("page") page: Int?
    ): NetworkResponse<TrendMovieModel, ErrorModel>


}