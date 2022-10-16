package org.example.basis

class Meloman(
    private var spendSum: Double,
    private var isMeloman: Boolean
) {

    fun calculateDiscount(): Double {

        if (spendSum in 1.00..999.00) {
            spendSum
        } else if (spendSum < 10000.00) {
            spendSum -= 100
        } else spendSum *= 0.95
        return if (isMeloman) spendSum * 0.99 else spendSum
    }


}