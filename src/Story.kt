class Story{
    companion object {
        fun longCaveCorridor(player1: Player){

            val randomNum = (1..5).random()
            println("You got to the right, to the long long corridor. It seems to break out in $randomNum branches. \n" +
                    "Each branch has a big, dramatic entrance gate, which behind each there is a different monster.\n" +
                    "Choose a door to go through")
            var choice = readLine()!!.toInt()

        }

        fun mineShafts(player1: Player){

            println("You go to your left to the mine shafts. You immediately smell the smell of rotting bodies, sulfur and rotting wood.\n" +
                    "You keep walking forward, and a support beam collapses in front of your feet, and on top there is a goblin, thirsty for your blood.")


            var goblin = Monster("Goblin", 15, 45, "big hulking ogre armed with a rusty yet sharp dagger", player1, true, false)
            monsterFightLoop(player1, goblin)
            println("the goblin collapses in front of you, revealing the rest of the mine shafts.\n" +
                    "Do you \n" +
                    "1. keep going\n" +
                    "2. turn back")
            var choice = readLine()!!.toInt()



            if (!goblin.isAlive){
                println("The ${goblin.name} has collapsed in front of you, revealing miles and miles of more abandoned mine shafts, \n" +
                        "probably with more dangerous creatures to face, and better loot to gain.\n" +
                        "Which do you do?\n" +
                        "1. Keep going through mine shafts\n" +
                        "2. Turn back to long corridor")

                if (choice == 1){
                    println("")
                }
                if (choice == 2){
                    longCaveCorridor(player1)
                }

            }

        }

    }
}