package kafka

import configuration.KafkaConfig
import org.apache.kafka.clients.producer.ProducerRecord

class Producer {
    companion object {
        const val TOPIC = "example_topic"
    }
    private val config = KafkaConfig()

    fun produce(key: String, value: String) {
        val producer = config.createProducer()
        val record = ProducerRecord(TOPIC, key, value)
        producer.run {
            send(record)
            flush()
            close()
        }
    }
}
