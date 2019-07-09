package com.cuongz.unstring.getFeed

import com.cuongz.unstring.model.feed.Feed

interface GetFeedInterface {
    interface Presenter{
        fun getFeedFromServer(accessToken: String)
    }

    interface View{
        fun onSuccess(feed: Feed)

        fun onFailure()
    }
}