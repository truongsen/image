package com.example.admin.img.api.Response

import com.example.admin.img.model.PixaImage
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by SenTH on 6/15/2018.
 */
class PixaResponse {
    @SerializedName("totalHits")
    @Expose
    var totalHits: Int = 0
    @SerializedName("hits")
    @Expose
    lateinit var listImages: ArrayList<PixaImage>
}