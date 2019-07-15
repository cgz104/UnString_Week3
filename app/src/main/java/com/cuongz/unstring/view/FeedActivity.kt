package com.cuongz.unstring.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cuongz.unstring.R
import com.cuongz.unstring.getFeed.GetFeedInterface
import com.cuongz.unstring.getFeed.GetFeedPresenter
import com.cuongz.unstring.model.feed.Datum
import com.cuongz.unstring.model.feed.Feed
import com.cuongz.unstring.utils.EndlessRecyclerViewScrollListener
import com.cuongz.unstring.utils.FeedAdapter
import kotlinx.android.synthetic.main.activity_feed.*

class FeedActivity : AppCompatActivity(), GetFeedInterface.View {
    var presenter: GetFeedInterface.Presenter = GetFeedPresenter(this)
    var adapter: FeedAdapter? = null
    private var listOfData: MutableList<Datum> = ArrayList()
    private lateinit var accessToken: String
    private var pg = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        intent
        accessToken = intent.getStringExtra("accessToken")

        listFeed.layoutManager = LinearLayoutManager(this)
        adapter = FeedAdapter(listOfData, this)
        listFeed.adapter = adapter


        val scrollListener = object : EndlessRecyclerViewScrollListener(listFeed.layoutManager!!) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                Log.w("testing", "go here")
                presenter.getFeedFromServer(accessToken, page.toString())
                pg++
                Log.w("page123", "$page")
            }
        }

        listFeed.addOnScrollListener(scrollListener)


        initProgressBar()
        presenter.getFeedFromServer(accessToken, pg.toString())

        swipeContainer.setOnRefreshListener { fetchTimelineAsync() }
    }

    override fun onSuccess(feed: Feed) {
        feed.data?.let { this.listOfData.addAll(it) }
        adapter?.notifyDataSetChanged()

        swipeContainer.isRefreshing = false
        hideProgressBar()
    }

    override fun onFailure() {

    }

    private fun initProgressBar() {
        progressBar.visibility = View.VISIBLE
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    private fun fetchTimelineAsync() {
        presenter.getFeedFromServer(accessToken, pg.toString())
    }
}
