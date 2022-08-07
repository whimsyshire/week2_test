import decor.DataDecoration
import decor.Decoration
import java.util.*

fun main(args: Array<String>) {
    helloWorld();
    //operatorsV1(5,6);
    operatorsV2(5, 6);
    forLoop(50);
    whenStatement(50);
    nullTest(null);
    listTest();
    forLoopTest();
    whileLoopTest();
    feedTheFish();

    defaultParam(humidity = 30);

    lazyMap();
    println("-----")
    println("-----")
    println("-----")
    eagerMap();

    higherOrderFunction();

    buildAquarium();

    makeFish();

    makeDecorations();
    makeDataDecorations();

}


fun helloWorld() {
    println("Hello World!");
}

fun operatorsV1(fish: Any, plants: Any) {
    println("I have $fish fish and $plants plants");
    //println("I have ${fish + plants} fish and plants");
}

fun operatorsV2(fish: Int, plants: Int) {
    println("I have $fish fish and $plants plants");
    println("I have ${fish + plants} fish and plants");
}

fun forLoop(fish: Int) {
    for (k in 100 downTo 0 step 10) {
        if (k == fish) {
            println("Got fish: $fish");
        } else {
            ;
        }
    }
}

fun whenStatement(fishWeight: Int) {
    when (fishWeight) {
        in 0..50 -> println("small fish");
        in 50..100 -> println("big fish");
        //> 100 -> println("huge fish");
        in 100..Int.MAX_VALUE -> println("huge fish");
        else -> println("wtf, you kidding?");
    }
//
//    when  {
//        fishWeight in 0..50 -> println("small fish");
//        fishWeight in 50..100 -> println("big fish");
//        fishWeight> 100 -> println("huge fish");
//        else -> println("wtf, you kidding?")
//    }
}

fun nullTest(fishFoodTreats: Int?) {
    //println("fish food treats: ${fishFoodTreats!!.dec() ?: 0}")
    println("fish food treats: ${fishFoodTreats?.dec() ?: 0}")
}


fun listTest() {
    val school = listOf("mackerel", "trout", "halibut");
    println(school.toString());

    val school2 = mutableListOf("tuna", "salmon", "shark");
    println(school2.remove("shark"));
    println(school2.toString());

    val numbers = intArrayOf(1, 2, 3);
    val oceans = listOf("Atlantic", "Pacific")
    val oddList = listOf(numbers, oceans, "salmon")

    val array = Array(5) { it * 2 }
    println(array.toList().toString());
}

fun forLoopTest() {
    val school = arrayOf("shark", "salmon", "minnow")
    for ((index, element) in school.withIndex()) {
        println("Item at $index is $element");
    }
}

fun whileLoopTest() {
    var bubbles = 0;
    while (bubbles < 50) {
        bubbles++;
    }
    println("$bubbles bubbles in the water\n");

    do {
        bubbles--;
    } while (bubbles > 50)
    println("$bubbles bubbles in the water\n");

    repeat(2) {
        println("A fish is swimming");
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day);
    println("Today is $day and the fish eat $food")
}

fun randomDay(): String {
    val week = arrayOf(
        "Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday"
    )
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun defaultParam(temp: Int = 26, humidity: Int = 50) {
    println("Weather: Temp: $temp Humidity: $humidity");
    println("isTooHot: ${isTooHot(temp)}");
}

fun isTooHot(temperature: Int) = temperature > 30

fun filterTest() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot");
    println(decorations.filter { it[0] == 'p' })
    println(decorations.asSequence().filter { x -> x[0] == 'p'; });
}

fun lazyMap() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot");
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
}

fun eagerMap() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot");
    val eagerMap = decorations.map {
        println("access: $it")
        it
    }
    println("eager: $eagerMap")
    println("-----")
    println("first: ${eagerMap.first()}")
    println("-----")
    println("all: ${eagerMap.toList()}")
}


fun lambda() {
    var dirtyLevel = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    val waterFilterV2 = foo(dirtyLevel);
        println(waterFilter(dirtyLevel));
        println(waterFilterV2)
}

fun foo(dirty: Int) : Int {
    return (dirty / 2);
}


fun higherOrderFunction() {
    val a = Aquarium();
    println(updateDirty(15, Aquarium()::increaseDirty));
}

//fun increaseDirty( start: Int ) = start + 1;

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun buildAquarium() {
    val myAquarium = Aquarium(numberOfFish = 29)
    myAquarium.printSize()
    println(myAquarium.volume);
    myAquarium.volume=50;
    println(myAquarium.volume);
    myAquarium.printSize()


    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize();
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")
}

fun makeDecorations() {
    val decoration1 = Decoration("granite")
    println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))
}

fun makeDataDecorations() {
    val decoration1 = DataDecoration("granite")
    println(decoration1)

    val decoration2 = DataDecoration("slate")
    println(decoration2)

    val decoration3 = DataDecoration("slate")
    println(decoration3)

    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))
}


