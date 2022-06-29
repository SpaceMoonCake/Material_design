package com.spacemooncake.materialdesign.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spacemooncake.materialdesign.BuildConfig
import com.spacemooncake.materialdesign.model.PictureOfTheDayResponseDate
import com.spacemooncake.materialdesign.model.RepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(private val liveDate : MutableLiveData<AppState>, private val repository: RepositoryImpl = RepositoryImpl()) : ViewModel() {

    fun getLiveDate () : MutableLiveData<AppState> {
        return liveDate
    }
    fun sendRequest(){
        liveDate.postValue(AppState.Loading)
        repository.getPictureOfTheDayApi().getPictureOfTheDay(BuildConfig.NASA_API_KEY).enqueue(callBack)
    }

    val callBack = object : Callback<PictureOfTheDayResponseDate>{
        override fun onResponse(
            call: Call<PictureOfTheDayResponseDate>,
            response: Response<PictureOfTheDayResponseDate>
        ) {
            if (response.isSuccessful){
                liveDate.postValue(AppState.Success(response.body()!!))

            } else {
                liveDate.postValue(AppState.Error(throw IllegalStateException("Что-то пошло не так")))
            }
        }

        override fun onFailure(call: Call<PictureOfTheDayResponseDate>, t: Throwable) {
            //TODO HW
        }

    }

}