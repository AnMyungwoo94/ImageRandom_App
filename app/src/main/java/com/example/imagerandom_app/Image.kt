package com.example.imagerandom_app

data class ImageResponse(
    val id : String,
    val urls : UriResponse,
    val color: String,
)

data class UriResponse(
    val raw : String,
    val full : String,
    val regular: String,
    val small : String,
    var thumb : String,
    )

