package com.example.instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramui.R
import com.example.instagramui.model.Feed
import com.example.instagramui.model.Story


class FeedAdapter(private val context: Context, private val items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ITEM_STORY = 0
        private const val TYPE_ITEM_POST = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].stories.size > 0) TYPE_ITEM_STORY else TYPE_ITEM_POST
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_STORY) {
            val view =
                LayoutInflater.from(context).inflate(R.layout.item_feed_story, parent, false)
            return StoryViewHolder(view)
        }
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is StoryViewHolder) {
            val recyclerView = (holder as StoryViewHolder).recyclerView

            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = manager

            refreshAdapter(recyclerView, feed.stories)
        }

        if (holder is PostViewHolder) {
            val imageViewProfile = (holder as PostViewHolder).imageViewProfile
            val imageViewPhoto = (holder as PostViewHolder).imageViewPhoto
            val textViewFullName = (holder as PostViewHolder).textViewFullName

            imageViewProfile.setImageResource(feed.post!!.profile)
            imageViewPhoto.setImageResource(feed.post.photo)
            textViewFullName.text = feed.post.fullName
        }
    }

    private fun refreshAdapter(recyclerView: RecyclerView, stories: ArrayList<Story>) {
        val adapter = StoryAdapter(context, stories)
        recyclerView.adapter = adapter
    }

    private class StoryViewHolder(myItemView: View) :
        RecyclerView.ViewHolder(myItemView) {
        val recyclerView: RecyclerView = myItemView.findViewById(R.id.recycler_view_story)
    }

    private class PostViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val imageViewProfile: ImageView = myItemView.findViewById(R.id.image_view_profile_post)
        val imageViewPhoto: ImageView = myItemView.findViewById(R.id.image_view_post_post)
        val imageViewLike: ImageView = myItemView.findViewById(R.id.icon_like_post)
        val imageViewComment: ImageView = myItemView.findViewById(R.id.icon_comment_post)
        val imageViewSend: ImageView = myItemView.findViewById(R.id.icon_send_post)
        val imageViewSave: ImageView = myItemView.findViewById(R.id.icon_save_post)
        val textViewFullName: TextView = myItemView.findViewById(R.id.text_view_full_name_post)
        val textViewCaption: TextView = myItemView.findViewById(R.id.text_view_caption_post)
    }
}
