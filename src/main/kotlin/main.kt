import kotlin.math.max

fun main() {
    val totalComission = comission("VK Pay", 0, amount = 77_000)
    println(totalComission)
}
const val ERROR_LIMIT = -1
const val ERROR_CARD = -2
const val MASTER_LIMIT = 75_000 //месячный беспроцентный лимит по данной карте
const val LIMIT_DAILY = 150_000
const val LIMIT_MONTHLY = 600_000

fun comission(typeCard: String = "Maestro", previous: Int = 0, amount: Int): Int {
    if (amount > LIMIT_DAILY || amount + previous > LIMIT_MONTHLY) return ERROR_LIMIT
    return when (typeCard) {
        "MasterCard", "Maestro" -> if (amount < 300) (amount * 0.006 + 20).toInt()
                                   else if (amount > MASTER_LIMIT) ((amount - MASTER_LIMIT) * 0.006 + 20).toInt()
                                   else 0
        "Visa", "Mir" -> max(35, (amount * 0.0075).toInt())
        "VK Pay" -> 0
        else -> ERROR_CARD
    }
}