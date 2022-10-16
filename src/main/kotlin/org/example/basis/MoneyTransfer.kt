package org.example.basis

class MoneyTransfer() {
    val minCommission = 35
    val valueCommission = 0.075

    fun makeTransfer(amount: Double): Double {
        return if (amount * valueCommission < minCommission) minCommission.toDouble()
        else amount + (amount * valueCommission);
    }
}