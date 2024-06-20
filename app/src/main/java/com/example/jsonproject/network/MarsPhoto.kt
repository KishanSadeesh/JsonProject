package com.example.jsonproject.network

import com.squareup.moshi.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class MarsPhoto(
    val id: String,
    @Json(name = "img_src")
    val imgSrc : String,


)
