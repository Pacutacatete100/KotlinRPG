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