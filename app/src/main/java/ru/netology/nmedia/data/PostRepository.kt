package ru.netology.nmedia.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.post.Post

interface PostRepository {

    val data: MutableLiveData<Post>

    fun likeClicked()

    fun shareClicked()
}