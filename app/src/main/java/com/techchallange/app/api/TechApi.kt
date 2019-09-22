package com.techchallange.app.api

import com.techchallange.app.model.ProductData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface TechApi {

    @GET
    fun marketApi(@Url url: String): Observable<List<ProductData>>
}