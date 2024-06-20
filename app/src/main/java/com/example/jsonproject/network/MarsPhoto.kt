package com.example.jsonproject.network

import kotlinx.serialization.SerialName

data class MarsPhoto(
    val id: String,
      @SerialName(value = "img_src")
      val imgSrc : String
)
