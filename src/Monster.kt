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