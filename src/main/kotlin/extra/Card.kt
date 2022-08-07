package extra

class Card (var rank: String = "ACE", var suit: String = "HEARTS", var flip:Boolean  = true) {

    fun printCard() {
        if(flip)
            println("Card: $rank $suit")
        else
            println("-------");
    }

    fun flip() {
        flip = !flip;
    }

}