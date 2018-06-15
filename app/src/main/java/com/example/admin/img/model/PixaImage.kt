package com.example.admin.img.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by SenTH on 6/15/2018.
 */
class PixaImage {
    @SerializedName("webformatWidth")
    @Expose
    val width: Int = 0
    @SerializedName("webformatHeight")
    @Expose
    val height: Int = 0;
    @SerializedName("previewURL")
    @Expose
    val imgUrl : String = ""
}