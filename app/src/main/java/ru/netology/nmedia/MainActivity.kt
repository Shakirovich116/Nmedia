package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import kotlinx.android.synthetic.main.menu.*
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.post.countFormat
import ru.netology.nmedia.post.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likesCount = resources.getString(R.string.likesCount).toInt(),
            shares = resources.getString(R.string.sharesCount).toInt(),
            views = resources.getString(R.string.visibilityCount).toInt(),
            likedByMe = false)


        binding.render(post)
    }
e
    private fun ActivityMainBinding.render(post: Post) {
        author.text = post.author
        content.text = post.content
        published.text = post.published

        likesCount?.setOnClickListener {
            post.likedByMe = !post.likedByMe
            likesCount.setImageResource(getLikeIconResId(post.likedByMe))
            likesCount.text = countFormat(if (post.likedByMe) (post.likesCount + 1) else (post.likesCount))
        }

        shareCount?.setOnClickListener {
            shareCount.text = countFormat(post.shares++)
        }


    }


    @DrawableRes
    private fun getLikeIconResId(liked: Boolean) =
        if (liked) R.drawable.ic_like_red_24 else R.drawable.like_24


}