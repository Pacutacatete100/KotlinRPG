
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

