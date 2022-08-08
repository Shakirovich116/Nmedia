package ru.netology.nmedia.data

import androidx.lifecycle.LiveData
import ru.netology.nmedia.post.Post

interface PostRepository {

    val data: LiveData<Post>

    fun liked()

    fun shareClicked()
}