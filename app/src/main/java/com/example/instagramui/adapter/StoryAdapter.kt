package com.example.instagramui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagramui.R
import com.example.instagramui.model.Story


class StoryAdapter(private val context: Context, private val items: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story = items[position]

        if (holder is StoryViewHolder) {
            val imageViewProfile = (holder as StoryViewHolder).imageViewProfile
            val textViewFullName = (holder as StoryViewHolder).textViewFullName

            imageViewProfile.setImageResource(story.profile)
            textViewFullName.text = story.fullName
        }
    }

    private class StoryViewHolder(myItemView: View) : RecyclerView.ViewHolder(myItemView) {
        val imageViewProfile: ImageView = myItemView.findViewById(R.id.image_view_profile_story)
        var textViewFullName: TextView = myItemView.findViewById(R.id.text_view_full_name_story)
    }
}

