package ru.netology

import kotlin.math.max

val ERROR_LIMIT = -1
val ERROR_CARDTYPE = -2

const val cardType = "Мир"
const val limitOnDay = 150_000
const val limitOnDayVkPay = 15_000
const val limitOnMonth = 600_000
const val limitOnMonthVkPay = 40_000
const val amountRemittanceAgoToday = 0
const val amountRemittanceAgoMonth = 0
const val amount = 80_000

fun main() {
    println("Комиссия составила: ${taxRemittance(cardType, amountRemittanceAgoToday, amountRemittanceAgoMonth, amount)} руб.")
}

fun taxRemittance(
    cardType: String,
    amountRemittanceAgoToday: Int = 0,
    amountRemittanceAgoMonth: Int = 0,
    amount: Int
): Int {
    if (amountRemittanceAgoMonth + amountRemittanceAgoToday + amount > limitOnMonth ||
        amountRemittanceAgoToday + amount > limitOnDay) {
        return ERROR_LIMIT
    }
    return when (cardType) {
        "MasterCard", "Maestro"-> if (amount in 300..75_000) {
            return 0
        } else {
            return (amount * 0.006 +20).toInt()
        }

        "Visa", "Мир" -> return max((amount * 0.0075).toInt(), 35)

        "VKPay" -> if (amount + amountRemittanceAgoToday > limitOnDayVkPay ||
            amount + amountRemittanceAgoMonth + amountRemittanceAgoToday > limitOnMonthVkPay) {
            return ERROR_LIMIT
        } else {
            return 0
        }

        else -> ERROR_CARDTYPE
    }
}