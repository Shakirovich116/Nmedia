package ru.netology.nmedia.data.impl

import androidx.lifecycle.MutableLiveData


import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.post.Post

class InMemoryPostRepository : PostRepository {
        private var post = Post(
            1,
            "Нетология. Университет интернет-профессий будущего",
            "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            "21 мая в 18:36",
            10,
            20,
            30,
            false)

    override val data = MutableLiveData(post)


    override fun likeClicked() {
        val currentPost = checkNotNull(data.value) {
            "Not null value"
        }
        val modifiedPost = currentPost.copy(
            likedByMe = !currentPost.likedByMe,
            likesCount = currentPost.likesCount + if (!currentPost.likedByMe) 1 else -1
        )
        data.value = modifiedPost
    }


    override fun shareClicked() {
        val currentPost = checkNotNull(data.value) {
            "Not null value"
        }

        data.value = currentPost.copy(
            sharesCount = currentPost.sharesCount + 1
        )
    }
}