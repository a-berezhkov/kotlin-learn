package org.example.basis

class Likes(likes: Int) {

    init {

        println("Понравилось $likes ${makeText(likes)}")
    }

    private fun makeText(likes: Int): String {
        return if (likes.toString().last() == '1' && likes.toString().takeLast(2) != "11") {
            "человеку"
        } else {
            "человекам"
        }

    }
}

