package kafka

import configuration.KafkaConfig
import java.time.Duration
import java.util.logging.LogManager

class Consumer {
    companion object {
        const val TOPIC = "example_topic"
    }
    private val config = KafkaConfig()

    fun consume() {
        val consumer = config.createConsumer()
        consumer.subscribe(listOf(TOPIC))
        while (true) {
            val records = consumer.poll(Duration.ofSeconds(1))
            for (record in records) {
                println("Key: ${record.key()} | Value: ${record.value()} | Part: ${record.partition()}")
            }
        }
    }
}
