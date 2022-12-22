abstract class Warrior(val age: Int) {
    abstract val weaponType: String
    override fun toString(): String{
        return "Age: $age, weapon type: $weaponType"
    }
}

class FootSoldier(age: Int): Warrior(age) {
    override val weaponType: String
        get() = "Rifle"
}

class Sailor(age: Int): Warrior(age) {
    override val weaponType: String
        get() = "Cutlass"
}

fun main(args: Array<String>) {
    val myWarrior: Warrior = Sailor(32)

    println(myWarrior)
}