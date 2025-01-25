package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun taxRemittance_MastercardMaestroOverFreeLimit() {
        val cardType = "MasterCard"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 0
        val amount = 80_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(500, result)
    }

    @Test
    fun taxRemittance_MastercardMaestroFrom300To75000() {
        val cardType = "Maestro"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 0
        val amount = 10_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(0, result)
    }

    @Test
    fun taxRemittance_VisaMir() {
        val cardType = "Мир"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 0
        val amount = 10_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(75, result)
    }

    @Test
    fun taxRemittance_VkPayOverLimitDay() {
        val cardType = "VKPay"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 0
        val amount = 20_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(-1, result)
    }

    @Test
    fun taxRemittance_VkPayOverLimitMonth() {
        val cardType = "VKPay"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 35_000
        val amount = 10_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(-1, result)
    }

    @Test
    fun taxRemittance_FreeLimit() {
        val cardType = "VKPay"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 15_000
        val amount = 10_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(0, result)
    }

    @Test
    fun taxRemittance_OtherCardType() {
        val cardType = "UnionPay"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 0
        val amount = 10_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(-2, result)
    }

    @Test
    fun taxRemittance_OverLimitDay() {
        val cardType = "UnionPay"
        val amountRemittanceAgoToday = 140_000
        val amountRemittanceAgoMonth = 0
        val amount = 20_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(-1, result)
    }

    @Test
    fun taxRemittance_OverLimitMonth() {
        val cardType = "UnionPay"
        val amountRemittanceAgoToday = 0
        val amountRemittanceAgoMonth = 590_000
        val amount = 20_000

        val result = ru.netology.taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)

        assertEquals(-2, result)
    }
}