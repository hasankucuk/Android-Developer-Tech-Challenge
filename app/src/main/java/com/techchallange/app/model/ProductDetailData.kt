package com.techchallange.app.model

import com.google.gson.annotations.SerializedName

data class ProductDetailData(
    @SerializedName("orderDetail") val orderDetail: String,
    @SerializedName("summaryPrice") val summaryPrice: Double
)
