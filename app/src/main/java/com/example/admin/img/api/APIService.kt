package com.example.admin.img.api

import com.example.admin.img.api.Response.PixaResponse
import com.example.admin.img.model.PixaImage
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap


/**
 * Created by SenTH on 6/15/2018.
 */
interface APIService {
    @GET("api/")
    fun getImages(@QueryMap params: Map<String, String>): Call<PixaResponse>
}