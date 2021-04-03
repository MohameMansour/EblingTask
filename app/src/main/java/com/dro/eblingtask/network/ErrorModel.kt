package com.dro.eblingtask.network


data class ErrorModel(
    val status_code: Int,
    val status_message: String,
    val success: Boolean
)