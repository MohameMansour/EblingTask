package com.dro.eblingtask.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dro.eblingtask.network.ErrorModel
import com.dro.eblingtask.network.NetworkResponse
import kotlinx.coroutines.launch

class TrendMovieViewModel :ViewModel() {

        private var repo = HomeRepository()
        public var trendMovie = MutableLiveData<TrendMovieModel>()

        var showLoading = MutableLiveData<Boolean>()
        val error = MutableLiveData<ErrorModel>()

    fun getTrendMovies(sort:String? , page: Int?) {

        showLoading.value = true

        viewModelScope.launch {

            val result = repo.trendMovies(sort , page)

            when (result) {
                is NetworkResponse.Success-> {
                    trendMovie.value = result.body
                }
                is NetworkResponse.ApiError -> {
                    error.value = result.body
                }
                is NetworkResponse.NetworkError -> {
                }
                is NetworkResponse.UnknownError -> {
                }
            }

            showLoading.value = false
        }
    }

}