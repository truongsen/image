package com.example.admin.img.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.admin.img.R
import com.example.admin.img.model.PixaImage
import kotlinx.android.synthetic.main.item_image.view.*
import android.support.v7.widget.StaggeredGridLayoutManager


/**
 * Created by SenTH on 6/15/2018.
 */
class ImageAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private lateinit var mContext: Context
    private lateinit var mListItems: ArrayList<PixaImage>

    constructor(context: Context, listImage: ArrayList<PixaImage>) {
        mContext = context
        mListItems = listImage
    }

    override fun getItemCount(): Int {
        return if (mListItems == null) 0 else mListItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val layoutParams = holder.itemView.getLayoutParams() as StaggeredGridLayoutManager.LayoutParams
        if (position % 3 == 0)
            layoutParams.isFullSpan = true
        else
            layoutParams.isFullSpan = false

        val item: PixaImage = mListItems.get(position)
        if (holder is ImageHolder) {
            holder.setData(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var layoutInflate: LayoutInflater = LayoutInflater.from(mContext)
        var view: View = layoutInflate.inflate(R.layout.item_image, parent, false)
        return ImageHolder(view)
    }

    fun addData(item: PixaImage) {
        mListItems.add(item)
        notifyItemInserted(itemCount - 1)
    }

    fun addData(items: List<PixaImage>) {
        var sizeBefore = itemCount
        mListItems.addAll(items)
        notifyItemRangeInserted(sizeBefore, itemCount)
    }

    fun removeData(position: Int) {

    }

    class ImageHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun setData(image: PixaImage) {
            Glide.with(itemView.context).load(image.imgUrl).into(itemView.ivPixa)
        }
    }
}