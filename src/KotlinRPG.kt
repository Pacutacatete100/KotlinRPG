
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

    if (choice == 1){
        var shop = Shop(shopItems, player1)
        shop.sellItems()
        var purchasedPower = shopItems[choice - 1]
        shop.addItemsToPlayerInventory(purchasedPower)
        player1.printPowers()

    }
    if (choice == 2){
        //go to cave
        println("You enter the cave. To your right is a long corridor, seemingly going to another branch of the cave.\n" +
                "To your left is what looks like abandoned mine shafts.\n" +
                "Choose where you want to go\n" +
                "1. Long corridor\n" +
                "2. Mine shafts")
        choice = readLine()!!.toInt()
        if (choice == 1){
            longCaveCorridor(player1)
        }else if (choice == 2){
            mineShafts(player1)
        }
    }
}
fun longCaveCorridor(player1: Player){
    val randomNum = (1..5).random()
    println("You got to the right, to the long long corridor. It seems to break out in $randomNum branches. \n" +
            "Each branch has a big, dramatic entrance gate, which behind there is a different monster.\n" +
            "Choose a door to go through")
}

fun mineShafts(player1: Player){
    println("You go to your left to the mine shafts. You immediately smell the smell of rotting bodies, sulfur and rotting wood.\n" +
            "You keep walking forward, and a support beam collapes infront of your feet, and on top there is a goblin, thirsty for your blood.")

    var goblin = Monster("Goblin", 15, 45, "big hulking ogre armed with a rusty yet sharp dagger", player1, true, false)
    monsterFightLoop(player1, goblin)
    println("the goblin colleapses in front of you, revealing the rest of the mine shafts.")

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

fun printPowerList(powerList: List<Power>){
    for (power in powerList){
        println("${power.choiceNumber}. ${power.name}: ${power.description}")
    }
}

