package org.example.control


fun main() {
    println(secToText(60))
    println(secToText(120))
    println(secToText(300))
    println(secToText(660))
    println(secToText(60 * 21))
    println(secToText(60 * 25))

    println(secToText(60 * 60 + 2))
    println(secToText(60 * 60 * 2))
    println(secToText(60 * 60 * 3))
    println(secToText(60 * 60 * 10))
    println(secToText(60 * 60 * 11))
    println(secToText(60 * 60 * 21))


    println(calculate(Card.VISA, 100.00, 100.00))
    println(calculate(Card.VK_PAY, 1000.00, 0.00))
    println(calculate(Card.MASTERCARD, 100_000.00, 0.00))
}

private fun secToText(countSecond: Int): String {
    return when (countSecond) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> (countSecond / 60).toString() + makeTextMinute(countSecond) + " назад"
        in (60 * 60 + 1)..(24 * 60 * 60) -> ((countSecond / 60) / 60).toString() + makeTextHours(countSecond) + " назад"
        in (24 * 60 * 60 + 1)..(2 * 24 * 60 * 60) -> ((countSecond / 60) / 60).toString() + " вчера"
        in (2 * 24 * 60 * 60 + 1)..(3 * 24 * 60 * 60) -> ((countSecond / 60) / 60).toString() + " позавчера"
        else -> ((countSecond / 60) / 60).toString() + " давно"
    }
}

private fun makeTextMinute(countSecond: Int): String {
    val countMinute = countSecond / 60
    return if (countMinute.toString().last() == '1' && countMinute.toString().takeLast(2) != "11") {
        " минуту"
    } else if (countMinute.toString().last() == '2' || countMinute.toString().last() == '3' || countMinute.toString()
            .last() == '4'
    ) {
        " минуты"
    } else " минут"
}


private fun makeTextHours(countSecond: Int): String {
    val countHours = (countSecond / 60) / 60
    return if (countHours.toString().last() == '1' && countHours.toString().takeLast(2) != "11") {
        " час"
    } else if (countHours.toString().last() == '2' || countHours.toString().last() == '3' || countHours.toString()
            .last() == '4'
    ) {
        " часа"
    } else " часов"
}

enum class Card {
    MASTERCARD, MAESTRO, VISA, MIR, VK_PAY

}

private fun calculate(cardType: Card = Card.VK_PAY, sumTransfer: Double, sumTransferMonth: Double = 0.00): Double {
    val pay = when (cardType) {
        Card.VK_PAY -> sumTransfer
        Card.MASTERCARD, Card.MAESTRO -> if (sumTransfer in 300.0..75000.0) sumTransfer else sumTransfer + (sumTransfer * 0.94 + 20)
        Card.MIR, Card.VISA -> if (0.075 * sumTransfer < 35) sumTransfer + 35 else sumTransfer + (0.075 * sumTransfer)
    }
    println("Общая сумма за месяц: " + (sumTransferMonth + pay))
    return pay


}
