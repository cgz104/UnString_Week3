package com.cuongz.unstring.utils

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cuongz.unstring.R
import com.cuongz.unstring.model.feed.Datum

class FeedAdapter (private var listData: List<Datum>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val poi = 1
    private val iti = 2
    private val post1 = 3
    private val post2 = 4
    private val post3 = 5

    override fun getItemViewType(position: Int): Int {
        val dataPos = listData[position]
        return when {
            dataPos.type == "poi" -> poi
            dataPos.type == "itinerary" -> iti
            dataPos.type == "post" && dataPos.videos == null && (dataPos.photos?.size == 1 || dataPos.photos == null) -> post1
            else -> -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return if (viewType == poi){
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_poi, parent, false)
            ViewHolderPoi(view)
        }else if(viewType == iti){
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_itinerary, parent, false)
            ViewHolderIti(view)
        }else{
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_post1, parent, false)
            ViewHolderPost1(view)
        }

    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolderPoi){
            holder.bind(listData[position])
        }else if (holder is ViewHolderIti){
            holder.bind(listData[position])
        }else if (holder is ViewHolderPost1){
            holder.bind(listData[position])
        }
    }



    inner class ViewHolderPoi(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title = itemView.findViewById<TextView>(R.id.poi_t1)
        private var positionGeneral = itemView.findViewById<TextView>(R.id.poi_t2)
        private var image = itemView.findViewById<ImageView>(R.id.imageView)
        private var likeCount = itemView.findViewById<TextView>(R.id.poi_numHeart)
        private var commentCount = itemView.findViewById<TextView>(R.id.poi_numComment)
        private var imgHeart = itemView.findViewById<ImageView>(R.id.poi_imgHeart)
        private var buttonString = itemView.findViewById<ConstraintLayout>(R.id.poi_buttonString)

        fun bind(data: Datum){
            title.text = data.title
            title.isSelected = true
            positionGeneral.text = data.address
            positionGeneral.isSelected = true

            var dataLiked = data.isLiked

            var like = data.likeCounter
            if(like != 0){
                likeCount.text = data.likeCounter.toString()
                likeCount.visibility = View.VISIBLE
            }else {
                likeCount.visibility = View.INVISIBLE
            }

            val comm = data.commentCounter
            if(comm != 0){
                commentCount.text = data.commentCounter.toString()
            }else commentCount.visibility = View.INVISIBLE

            if(dataLiked == true){
                imgHeart.setImageResource(R.drawable.ic_heartfilledaccent)
                likeCount.text = data.likeCounter.toString()
                likeCount.visibility = View.VISIBLE
            }


//            buttonString.setOnClickListener {
//                if(data.i)
//            }

            imgHeart.setOnClickListener{
                if(dataLiked == false){
                    imgHeart.setImageResource(R.drawable.ic_heartfilledaccent)
                    like = like?.plus(1)
                    likeCount.visibility = View.VISIBLE
                    likeCount.text = like.toString()
                    dataLiked = true
                }
                else{
                    imgHeart.setImageResource(R.drawable.ic_icosocialheartline)
                    like = like?.minus(1)
                    if(like == 0){
                        likeCount.visibility = View.INVISIBLE
                    }else{
                        likeCount.text = like.toString()
                    }
                    dataLiked = false
                }
            }

            Glide.with(context)
                .load(data.photos?.get(0)?.url?.original)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                .apply(RequestOptions.placeholderOf(R.drawable.poi_gradien_img))
                .into(image)
        }
    }

    inner class ViewHolderIti(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title = itemView.findViewById<TextView>(R.id.iti_titleView)
        private var likeCount = itemView.findViewById<TextView>(R.id.iti_numHeart)
        private var commentCount = itemView.findViewById<TextView>(R.id.iti_numComment)
        private var imgHeart = itemView.findViewById<ImageView>(R.id.iti_imgHeart)
        private var userName = itemView.findViewById<TextView>(R.id.iti_userName)
        private var imgInfluencer = itemView.findViewById<ImageView>(R.id.iti_influencer)
        private var imgProfile = itemView.findViewById<ImageView>(R.id.iti_profileImg)
        private var description = itemView.findViewById<TextView>(R.id.iti_description)
        private var strungField = itemView.findViewById<LinearLayout>(R.id.iti_strungField)
        private var userStrung = itemView.findViewById<TextView>(R.id.iti_userStrung)
        private var addrTxt = itemView.findViewById<TextView>(R.id.iti_addressText)
        private var addrTxt2 = itemView.findViewById<TextView>(R.id.iti_addressText2)
        private var img1 = itemView.findViewById<ImageView>(R.id.iti_img1)
        private var img2 = itemView.findViewById<ImageView>(R.id.iti_img2)

        fun bind(data: Datum){
            title.text = data.title
            userName.text = data.user?.username.toString()
            description.text = data.description.toString()

            var dataLiked = data.isLiked

            var like = data.likeCounter
            if(like != 0){
                likeCount.text = data.likeCounter.toString()
                likeCount.visibility = View.VISIBLE
            }else {
                likeCount.visibility = View.INVISIBLE
            }

            val comm = data.commentCounter
            if(comm != 0){
                commentCount.text = data.commentCounter.toString()
            }else commentCount.visibility = View.INVISIBLE

            if(data.strungFrom != null){
                strungField.visibility = View.VISIBLE
                userStrung.text = data.strungFrom?.username
            }

            if(dataLiked == true){
                imgHeart.setImageResource(R.drawable.ic_heartfilledaccent)
                likeCount.text = data.likeCounter.toString()
                likeCount.visibility = View.VISIBLE
            }

            val dataIti = data.itineraries
            if(dataIti != null){
                addrTxt.text = dataIti[0].title
                if(dataIti.size > 1){
                    addrTxt2.text = dataIti[1].title

                    Glide.with(context)
                        .load(dataIti[1].photos?.url?.original)
                        .apply(RequestOptions.placeholderOf(R.drawable.poi_gradien_img))
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                        .into(img2)
                }


                Glide.with(context)
                    .load(dataIti[0].photos?.url?.original)
                    .apply(RequestOptions.placeholderOf(R.drawable.poi_gradien_img))
                    .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                    .into(img1)


            }

            var desClick = false
            description.setOnClickListener {
                if(!desClick){
                    description.maxLines = 20
                    desClick = true
                }else{
                    description.maxLines = 3
                    desClick = false
                }

            }

            if(data.user?.type == "influencer"){
                imgInfluencer.visibility = View.VISIBLE
            }

            Glide.with(context)
                .load(data.user?.profilePhoto)
                .apply(RequestOptions.circleCropTransform())
                .apply(RequestOptions.placeholderOf(R.drawable.circle_gradien_img))
                .into(imgProfile)

            imgHeart.setOnClickListener{
                if(dataLiked == false){
                    imgHeart.setImageResource(R.drawable.ic_heartfilledaccent)
                    like = like?.plus(1)
                    likeCount.visibility = View.VISIBLE
                    likeCount.text = like.toString()
                    dataLiked = true
                }
                else{
                    imgHeart.setImageResource(R.drawable.ic_icosocialheartline)
                    like = like?.minus(1)
                    if(like == 0){
                        likeCount.visibility = View.INVISIBLE
                    }else{
                        likeCount.text = like.toString()
                    }
                    dataLiked = false
                }
            }

        }
    }

    inner class ViewHolderPost1(itemView: View): RecyclerView.ViewHolder(itemView){
        private var likeCount = itemView.findViewById<TextView>(R.id.post1_numHeart)
        private var commentCount = itemView.findViewById<TextView>(R.id.post1_numComment)
        private var imgHeart = itemView.findViewById<ImageView>(R.id.post1_imgHeart)
        private var userName = itemView.findViewById<TextView>(R.id.post1_userName)
        private var imgProfile = itemView.findViewById<ImageView>(R.id.post1_imgProfile)
        private var saveCount = itemView.findViewById<TextView>(R.id.post1_numberSave)
        private var buttonSave = itemView.findViewById<ConstraintLayout>(R.id.post1_buttonSave)
        private var imgInButton = itemView.findViewById<ImageView>(R.id.post1_imgInButton)
        private var imgPost1 = itemView.findViewById<ImageView>(R.id.post1_imageView)
        private var address = itemView.findViewById<TextView>(R.id.post1_addressText)
        private var status = itemView.findViewById<TextView>(R.id.post1_statusText)
        private var imgInfluencer = itemView.findViewById<ImageView>(R.id.post1_influencer)


        fun bind(data: Datum){
            var numberSaved = data.saveCounter
            var like = data.likeCounter
            val comm = data.commentCounter

            saveCount.text = numberSaved.toString()

            userName.text = data.user?.username.toString()

            status.text = data.description

            if(data.type == "influencer"){
                imgInfluencer.visibility = View.VISIBLE
            }

            if(like != 0){
                likeCount.text = data.likeCounter.toString()
                likeCount.visibility = View.VISIBLE
            }else {
                likeCount.visibility = View.INVISIBLE
            }

            if(comm != 0){
                commentCount.text = data.commentCounter.toString()
            }else commentCount.visibility = View.INVISIBLE

            if(data.isLiked!! == true){
                imgHeart.setImageResource(R.drawable.ic_heartfilledaccent)
                likeCount.text = data.likeCounter.toString()
                likeCount.visibility = View.VISIBLE
            }

            address.text = data.place?.address

            Glide.with(context)
                .load(data.photos?.get(0)?.url?.original)
                .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
                .apply(RequestOptions.placeholderOf(R.drawable.poi_gradien_img))
                .into(imgPost1)

            Glide.with(context)
                .load(data.user?.profilePhoto)
                .apply(RequestOptions.placeholderOf(R.drawable.circle_gradien_img))
                .apply(RequestOptions.circleCropTransform())
                .into(imgProfile)


            if(!data.isSaved!!){
                buttonSave.setBackgroundResource(R.drawable.button_string)
                saveCount.setTextColor(Color.parseColor("#933dec"))
                imgInButton.setImageResource(R.drawable.ic_savefilledpurple)
            }

            buttonSave.setOnClickListener {
                if(data.isSaved == false){
                    buttonSave.setBackgroundResource(R.drawable.button_string2)
                    saveCount.setTextColor(Color.parseColor("#FFFFFF"))
                    numberSaved = numberSaved?.plus(1)
                    saveCount.text = numberSaved.toString()
                    imgInButton.setImageResource(R.drawable.ic_savefilledlight)
                    data.isSaved = true
                }else{
                    buttonSave.setBackgroundResource(R.drawable.button_string)
                    saveCount.setTextColor(Color.parseColor("#933dec"))
                    numberSaved = numberSaved?.minus(1)
                    imgInButton.setImageResource(R.drawable.ic_savefilledpurple)
                    saveCount.text = numberSaved.toString()
                    data.isSaved = false
                }
            }

            imgHeart.setOnClickListener{
                if(data.isLiked == false){
                    imgHeart.setImageResource(R.drawable.ic_heartfilledaccent)
                    like = like?.plus(1)
                    likeCount.visibility = View.VISIBLE
                    likeCount.text = like.toString()
                    data.isLiked = true
                }
                else{
                    imgHeart.setImageResource(R.drawable.ic_icosocialheartline)
                    like = like?.minus(1)
                    if(like == 0){
                        likeCount.visibility = View.INVISIBLE
                    }else{
                        likeCount.text = like.toString()
                    }
                    data.isLiked = false
                }
            }

        }
    }

}





//class FeedAdapter (private var listData: List<Datum>, val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
//    private val poi = 1
//    private val iti = 2
//
//    override fun getItemViewType(position: Int): Int {
//        return when {
//            listData[position].type == "poi" -> poi
//            listData[position].type == "itinerary" -> iti
//            else -> -1
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return if (viewType == poi){
//            val layoutInflater = LayoutInflater.from(parent.context)
//            val itemPoi = ItemPoiBinding.inflate(layoutInflater, parent, false)
//            ViewHolderPoi(itemPoi)
//        }else{
//            val layoutInflater = LayoutInflater.from(parent.context)
//            val itemIti = ItemItineraryBinding.inflate(layoutInflater, parent, false)
//            ViewHolderIti(itemIti)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return listData.size
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if(holder is ViewHolderPoi){
//            holder.binding.itemPoi = listData[position]
//        }else if (holder is ViewHolderIti){
//            holder.binding.itemIti = listData[position]
//        }
//    }
//
//    inner class ViewHolderPoi(val binding: ItemPoiBinding): RecyclerView.ViewHolder(binding.root){
//
//    }
//
//    inner class ViewHolderIti(val binding: ItemItineraryBinding): RecyclerView.ViewHolder(binding.root){
//
//    }
//
//    fun buttonLike(v: View){
//        Log.w("test", "go here")
//    }
//
//
//}