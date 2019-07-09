package com.cuongz.unstring.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cuongz.unstring.R
import com.cuongz.unstring.getFeed.GetFeedInterface
import com.cuongz.unstring.getFeed.GetFeedPresenter
import com.cuongz.unstring.model.feed.Feed
import com.cuongz.unstring.utils.FeedAdapter
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity(), GetFeedInterface.View {
    var presenter: GetFeedInterface.Presenter = GetFeedPresenter(this)
    var adapter: FeedAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        intent
        val accessToken = intent.getStringExtra("accessToken")
        presenter.getFeedFromServer(accessToken)
    }

    override fun onSuccess(feed: Feed) {
        adapter = feed.data?.let { FeedAdapter(it) }
        listFeed.adapter = adapter
        listFeed.layoutManager = LinearLayoutManager(this)
    }

    override fun onFailure() {

    }
}
