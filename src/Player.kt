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