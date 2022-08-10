package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.DrawableRes
import ru.netology.nmedia.databinding.ActivityMainBinding
import androidx.activity.viewModels
import ru.netology.nmedia.viewModel.PostViewModel
import ru.netology.nmedia.post.countFormat
import ru.netology.nmedia.post.Post



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this){  post ->
            binding.render(post)

        }




//        
//            viewModel.clickLikedPost()
//
//            viewModel.clickSharePost()

    }

            private fun ActivityMainBinding.render (post:Post) {

                with(postLayout) {
                    author.text = post.author
                    content.text = post.content
                    published.text = post.published
                    likesCount.text = countFormat(if (post.likedByMe) (post.likesCount + 1) else (post.likesCount))
                    shareCount.text = countFormat(post.sharesCount)
                    viewsCount.text = countFormat(post.viewsCount)

                    likes.setOnClickListener() {
                        likes.setImageResource(
                            if (post.likedByMe) R.drawable.ic_like_red_24
                            else R.drawable.like_24
                        )
                        viewModel.clickLikedPost()


                    }
                    share.setOnClickListener(){

                        viewModel.clickSharePost()

                    }




            }




        }

//    @DrawableRes
//    private fun getLikeIconResId(likedByMe: Boolean) =
//        if (likedByMe) R.drawable.ic_like_red_24 else R.drawable.like_24


}