package com.cuongz.unstring.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cuongz.unstring.R
import com.cuongz.unstring.model.feed.Datum


class FeedAdapter (private var listData: List<Datum>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val poi = 1
    private val iti = 2

    override fun getItemViewType(position: Int): Int {
        return when {
            listData[position].type == "poi" -> poi
            listData[position].type == "itinerary" -> iti
            else -> -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        var view: View
//        return if (viewType == poi){
//            view = LayoutInflater.from(parent.context).inflate(R.layout.item_poi, parent, false)
//            ViewHolderPoi(view)
//        }else {
//            view = LayoutInflater.from(parent.context).inflate(R.layout.item_itinerary, parent, false)
//            ViewHolderIti(view)
//        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poi, parent, false)
        return ViewHolderPoi(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolderPoi){
            holder.bind(listData[position])
//        }else if (holder is ViewHolderIti){
//            holder.bind(listData[position])
        }
    }


//    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        fun configViewHolderPoi(viewHolderPoi: ViewHolderPoi, position: Int){
//            viewHolderPoi.bind(listData[position])
//        }
//    }


    inner class ViewHolderPoi(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title = itemView.findViewById<TextView>(R.id.poi_t1)
        private var positionGeneral = itemView.findViewById<TextView>(R.id.poi_t2)
        private var image = itemView.findViewById<ImageView>(R.id.poi_imgLocation)

        fun bind(data: Datum){
            title.text = data.title
            positionGeneral.text = data.address

//            Glide.with(itemView)
//                .load(data.photos?.get(0)?.url?.thumb)
//                .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
//                .into(image)
        }
    }

    inner class ViewHolderIti(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title = itemView.findViewById<TextView>(R.id.iti_titleView)
        private var image = itemView.findViewById<ImageView>(R.id.poi_imgLocation)

        fun bind(data: Datum){
//            positionDetail.text = data
            title.text = data.title

            Glide.with(itemView)
                .load(data.photos?.get(0)?.url?.thumb)
                .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                .into(image)
        }
    }
}