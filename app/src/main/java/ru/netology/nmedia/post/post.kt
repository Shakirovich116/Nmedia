package ru.netology.nmedia.post


import java.math.RoundingMode
import java.text.DecimalFormat

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    var likes: Int = 0,
    var shares: Int = 0,
    var views: Int = 0,
    var likedByMe: Boolean = false
)
val post = Post(
    id = 1,
    author = "Нетология. Университет интернет-профессий будущего",
    content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
    published = "21 мая в 18:36",
    likedByMe = false)

fun countFormat(count: Int): String {
    return when (count) {
        in 1..999 -> "${count.toString()}"
        in 1000..1099 ->"${roundNoDecimal(count.toDouble()/1_000.0)}K"
        in 1100..9_999 ->"${roundWithDecimal(count.toDouble()/1_000.0)}K"
        in 10_000..999_999 ->"${roundNoDecimal(count.toDouble()/1_000.0)}K"
        in 1_000_000..1_099_999 ->"${roundNoDecimal(count.toDouble()/1_000_000.0)}M"
        in 1_100_000..Int.MAX_VALUE ->"${roundWithDecimal(count.toDouble()/1_000_000.0)}M"

        else-> count.toString()
    }
}

fun roundWithDecimal(number: Double): Double? {
    val df = DecimalFormat("#.#")
    df.roundingMode = RoundingMode.FLOOR
    return df.format(number).toDouble()
}
fun roundNoDecimal(number: Double): Int? {
    val df = DecimalFormat("#")
    df.roundingMode = RoundingMode.FLOOR
    return df.format(number).toInt()
}