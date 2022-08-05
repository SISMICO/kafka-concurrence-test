import kafka.Consumer
import kafka.Producer
import java.util.Random

fun main(args: Array<String>) {
    val keys = (1..100).toList()
    val producer = Producer()

    Thread {
        Consumer().consume()
    }.start()

    keys.parallelStream().forEach {
            for (x in 0..10) {
                producer.produce("KEY$it", "${Random().nextLong()} $it ${Random().nextLong()}")
            }
        }
}
