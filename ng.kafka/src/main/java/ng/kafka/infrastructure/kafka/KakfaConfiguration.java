package ng.kafka.infrastructure.kafka;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KakfaConfiguration {
//
//    public static Consumer<Long, String> createConsumer() {
//        Properties props = new Properties();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, IKafkaConstants.KAFKA_BROKERS);
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, IKafkaConstants.GROUP_ID_CONFIG);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, IKafkaConstants.MAX_POLL_RECORDS);
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, IKafkaConstants.OFFSET_RESET_EARLIER);
//        Consumer<Long, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Collections.singletonList(IKafkaConstants.TOPIC_NAME));
//        return consumer;
//    }
//
//    @Bean
//    public ProducerFactory<String, User> producerFactory() {
//        Map<String, Object> config = new HashMap<>();
//
//        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//        return new DefaultKafkaProducerFactory<>(config);
//    }

//    @Bean
//    public KafkaTemplate<String, User> kafkaUserTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
}