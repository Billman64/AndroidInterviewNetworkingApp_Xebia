package com.aspiration.interview.data.model

class LatinMedia : ArrayList<LatinMediaItem>()

data class LatinMediaItem(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)