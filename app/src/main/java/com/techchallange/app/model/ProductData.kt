package com.techchallange.app.model

import com.google.gson.annotations.SerializedName

data class ProductData(
    @SerializedName("date") val date: String,
    @SerializedName("month") val month: String,
    @SerializedName("marketName") val marketName: String,
    @SerializedName("orderName") val orderName: String,
    @SerializedName("productPrice") val productPrice: Double,
    @SerializedName("productState") val productState: String,
    @SerializedName("productDetail") val productDetail: ProductDetailData
)
