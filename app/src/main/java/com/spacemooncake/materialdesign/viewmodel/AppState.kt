package com.spacemooncake.materialdesign.viewmodel

import com.spacemooncake.materialdesign.model.PictureOfTheDayResponseDate

sealed class AppState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseDate) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}