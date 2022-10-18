package org.example.control

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun calculateVisaCard() {
        assertEquals(calculate(Card.VISA, 100.00, 100.00), 135.0)
        assertEquals(calculate(Card.VISA, 100_000.00), 107500.0)
        assertEquals(calculate(Card.MIR, 100.00, 100.00), 135.0)
        assertEquals(calculate(Card.MIR, 100_000.00), 107500.0)
    }

    @Test
    fun calculateVkCard() {
        assertEquals(calculate(Card.VK_PAY, 1000.00, 0.00), 1000.0)
    }

    @Test
    fun calculateMasterCard() {
        assertEquals(calculate(Card.MASTERCARD, 100_000.00, 0.00), 194020.0)
        assertEquals(calculate(Card.MASTERCARD, 400.00, 0.00), 400.0)
        assertEquals(calculate(Card.MAESTRO, 100_000.00, 0.00), 194020.0)
        assertEquals(calculate(Card.MAESTRO, 400.00, 0.00), 400.0)
        assertEquals(calculate(Card.MAESTRO, 0.00, 0.00), 20.0)
    }

}