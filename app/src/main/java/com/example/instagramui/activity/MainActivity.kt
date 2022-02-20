package com.example.instagramui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.EmojiCompatConfigurationView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramui.R
import com.example.instagramui.adapter.FeedAdapter
import com.example.instagramui.model.Feed
import com.example.instagramui.model.Post
import com.example.instagramui.model.Story

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        context = this
        recyclerView = findViewById(R.id.recycler_view_main)
        recyclerView.layoutManager = GridLayoutManager(context, 1)

        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(context, feeds)
        recyclerView.adapter = adapter
    }

    private fun getAllFeeds(): ArrayList<Feed> {

        val stories: ArrayList<Story> = ArrayList<Story>()

        stories.add(Story(R.drawable.im_user_4, "Xurshid"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_1, "Firdavs"))
        stories.add(Story(R.drawable.im_user_4, "Xurshid"))
        stories.add(Story(R.drawable.im_user_3, "Sherzod"))
        stories.add(Story(R.drawable.im_user_2, "Begzod"))
        stories.add(Story(R.drawable.im_user_1, "Firdavs"))

        val feeds: ArrayList<Feed> = ArrayList()

        feeds.add(Feed(stories = stories))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_user_2, "Begzodbek", R.drawable.im_post_3)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Sherzodbek", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_user_4, "Firdavsbek", R.drawable.im_post_1)))

        EmojiCompatConfigurationView

        return feeds;
    }
}

