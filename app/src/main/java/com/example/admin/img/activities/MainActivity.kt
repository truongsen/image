package com.example.admin.img.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.example.admin.img.R
import com.example.admin.img.adapter.ImageAdapter
import com.example.admin.img.api.APIClient
import com.example.admin.img.api.Response.PixaResponse
import com.example.admin.img.model.PixaImage
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    fun loadData() {
        var params: HashMap<String, String> = HashMap()
        params.put("key", "6416729-59fe73005ed65276e08b8335e")
        params.put("page", "1")
        params.put("per_page", "30")
        var call: Call<PixaResponse> = APIClient.create().getImages(params);
        call.enqueue(object : Callback<PixaResponse> {
            override fun onFailure(call: Call<PixaResponse>?, t: Throwable?) {
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<PixaResponse>?, response: Response<PixaResponse>?) {
                progressBar.visibility = View.GONE
                var layoutManager: StaggeredGridLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                var listImages: ArrayList<PixaImage> = response!!.body()!!.listImages
                var adapter: ImageAdapter = ImageAdapter(this@MainActivity, listImages)
                rvImage.layoutManager = layoutManager
                rvImage.adapter = adapter;
            }

        })
    }
}
