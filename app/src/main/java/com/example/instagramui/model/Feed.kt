package com.example.instagramui.model

data class Feed(
    val post: Post? = null,
    val stories: ArrayList<Story> = ArrayList()
)

