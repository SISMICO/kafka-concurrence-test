package configuration

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties

class KafkaConfig {
    fun createProducer() =
        KafkaProducer<String, String>(loadProducerProperties())

    fun createConsumer() =
        KafkaConsumer<String, String>(loadConsumerProperties())

    private fun loadProducerProperties() =
        Properties().apply {
            setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
            setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
            setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
        }

    private fun loadConsumerProperties() =
        Properties().apply {
            setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
            setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java.name)
            setProperty(ConsumerConfig.GROUP_ID_CONFIG, "concurrence")
            setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
        }
}
