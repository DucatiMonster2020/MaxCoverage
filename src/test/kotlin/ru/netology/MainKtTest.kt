package ru.netology

import ERROR_CARD
import ERROR_LIMIT
import comission
import junit.framework.Assert.assertEquals
import kotlin.test.Test

class MainKtTest {

    @Test
    fun comission() {
        val typeCard  = "Visa"
        val amount = 1_000
        val previous = 0

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(35, result)
    }
    @Test
    fun comissionDailyLimmit() {
        val typeCard  = "Visa"
        val amount = 160_000
        val previous = 0

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun comissionMonthlyLimmit() {
        val typeCard  = "VK Pay"
        val amount = 160_000
        val previous = 500_000

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun comissionWrongTypeCard() {
        val typeCard  = "Lenta"
        val amount = 15_000
        val previous = 0

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(ERROR_CARD, result)
    }
    @Test
    fun comissionMaestroMasterNoCom() {
        val typeCard  = "Maestro"
        val amount = 15_000
        val previous = 0

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(0, result)
    }
    @Test
    fun comissionMaestroMasterLimits() {
        val typeCard  = "Maestro"
        val amount = 77_000
        val previous = 0

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(32, result)
    }
    @Test
    fun comissionMaestroMasterLess300() {
        val typeCard  = "Maestro"
        val amount = 250
        val previous = 0

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(21, result)
    }
    @Test
    fun comissionTypeCard() {
        val typeCard  = "VK Pay"
        val amount = 250
        val previous = 0

        val result = comission(typeCard = typeCard, previous = previous, amount = amount)

        assertEquals(0, result)
    }
}