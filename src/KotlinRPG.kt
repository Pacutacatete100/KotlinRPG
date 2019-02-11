
fun main(args: Array<String>) {
    println("enter your name")

    val name = readLine()!!

    val initialPowerList = mutableListOf<Power>(
        Power("Fireball", "shoots a fireball", 0, 20, 1, 1),
        Power("Poison", "creates cloud of poison that decreases the enemy's health for 3 turns", 0, 5, 2, 2)
    )


    val player1 = Player(name, 5, initialPowerList, 100, 50)

    player1.printInformation()
    player1.printPowers()

    println()
    println("You are walking through the great planes, when u see a giant monster.")


    val giantSpider = Monster("Giant Spider", 10, 50, "giant spider that stings you", player1, true, false)

    monsterFightLoop(player1, giantSpider)

    println("You are walking through the forest, when suddenly you spot a market to your left and a cave to your right.\n" +
            "1. Go to the market\n" +
            "2. Go to the cave")

    var choice = readLine()!!.toInt()

    var shopItems = mutableListOf<Power>()

    shopItems.add(Power("Magic Arrow", "shoots a magic arrow out of thin air", 25, 30, 1, 1))
    shopItems.add(Power("Death Orb", "creates a black hole that does damage over time", 50, 15, 2, 2))

    var shop = Shop(shopItems, player1)
    shop.sellItems()
    var purchasedPower = shopItems[choice - 1]
    shop.addItemsToPlayerInventory(purchasedPower)
    player1.printPowers()




}
class Shop(var shopItems: MutableList<Power>, var player1: Player){
    fun sellItems(){
        println("Choose an item you would like to purchase:")
        for (power in shopItems){
            println("${power.choiceNumber}. ${power.name}: ${power.description} (${power.price} gold)")
        }
        println("you have ${player1.gold} gold")
    }

    fun addItemsToPlayerInventory(chosenItem: Power){
        player1.powerList.add(chosenItem)
        player1.gold -= chosenItem.price
        chosenItem.choiceNumber = 3

    }

}


fun monsterFightLoop(player1: Player, monster: Monster){
    while (monster.health > 0 && player1.health > 0){
        monster.attackPlayer()
        var chosenPower = player1.choosePower()
        player1.usePower(chosenPower)

        if (chosenPower.powerType == 1){
            monster.takePlayerAttack(chosenPower.damage)
            println("A ${monster.name} now has ${monster.health} health")
        }else if(chosenPower.powerType == 2){
            monster.takePlayerOvertimeAttack(chosenPower.damage)
            println("The ${monster.name} now has ${monster.health} health")
        }

        if (monster.health <= 0){
            println("you have succesfully killed the ${monster.name}")
            break
        } else if(player1.health <= 0){
            println("the ${monster.name} has killed you.")
            break
        }
    }
}

class Player(val name: String, var powerLevel: Int, var powerList: MutableList<Power>, var health: Int, var gold: Int){

    fun choosePower(): Power{
        println("Choose what power you would like to use:")
        printPowers()
        var choice = readLine()!!.toInt()

        return powerList[choice - 1]
    }

    fun usePower(power: Power){
        println("you have hit the monster for ${power.damage} damage")

    }
    fun printInformation(){
        println("You are $name the adventurer. Power level: $powerLevel. Health: $health")
    }
    fun printPowers(){
        for (power in powerList){
            println("${power.choiceNumber}. ${power.name}: ${power.description} (${power.damage} damage)")
        }
    }
    fun printGold(){
        println("you have $gold gold")
    }

}

fun printPowerList(powerList: List<Power>){
    for (power in powerList){
        println("${power.choiceNumber}. ${power.name}: ${power.description}")
    }
}

class Power(val name: String, val description: String, val price: Int, var damage: Int, var choiceNumber: Int, val powerType: Int){
    fun printDescriptionAndName(){
        println("$name: $description")
    }
    fun showInShop(){
        println("this item costs $price gold pieces")
    }
    //powerType 1: one time attack
    //powerType 2: damage over time



}

class Monster(val name: String, val attack: Int, var health: Int, val description: String, val playerFighting: Player, var isAlive: Boolean, var isPoisoned: Boolean){
    fun printDescriptionAndName(){
        println("$name: $description")
    }
    fun attackPlayer(){
        println("the $name has attacked you. you have lost $attack health. You now have ${playerFighting.health}")
        playerFighting.health -= attack
    }
    fun takePlayerAttack(attack: Int): Int{
        println("You have hit the $name for $attack health")
        health -= attack
        return health
    }
    fun takePlayerOvertimeAttack(attack: Int): Int{
        println("You have hit the $name for $attack health")
        health -= attack
        return health
    }
}