package com.dro.eblingtask.home

import com.prostacare.doctoronline.network.RetrofitBuilder

class HomeRepository {

    val client = RetrofitBuilder().instant

//    suspend fun trendMovies(apiKey:String,page:String?) = client.trendMovies(apiKey,page)

//    suspend fun trendMovies() = client.trendMovies("3fb43d674c421dab1ba9b705300cea01","popularity.desc",1)

    suspend fun trendMovies(sort:String? , page:Int?) = client.trendMovies("3fb43d674c421dab1ba9b705300cea01",sort,page)

}