class Shark: FishAction, FishColor {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }

    fun swim() {
        println("50km/h")
    }
}

