import kotlin.math.PI

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8

    override val shape = "cylinder"

    override fun printSize() {
        println(shape)
        println("diameter: $diameter cm " +
                "Height: $height cm ")
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }


}