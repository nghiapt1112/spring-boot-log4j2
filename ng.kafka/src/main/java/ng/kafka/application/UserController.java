package ng.kafka.application;

import ng.kafka.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    //    public static final String DEFAULT_TOPIC = "test";
//    @Autowired
//    private KafkaTemplate<String, User> kafkaUserTemplate;
//
//    @GetMapping("/publish")
//    public String pubMessage(@RequestParam String msg) {
//
//        kafkaUserTemplate.send(DEFAULT_TOPIC, User.builder().address("address" + msg).name("name " + msg).build());
//        return String.format("Message %s sent successfull", msg);
//    }

    @Autowired
    private MessageProducer producer;

    @Autowired
    private MessageListener listener;

    @GetMapping("push")
    public void pushMessage(@RequestParam String message) throws InterruptedException {
        /*
         * Sending a Hello World message to topic 'baeldung'.
         * Must be recieved by both listeners with group foo
         * and bar with containerFactory fooKafkaListenerContainerFactory
         * and barKafkaListenerContainerFactory respectively.
         * It will also be recieved by the listener with
         * headersKafkaListenerContainerFactory as container factory
         */
        producer.sendMessage(message);
        listener.latch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to a topic with 5 partition,
         * each message to a different partition. But as per
         * listener configuration, only the messages from
         * partition 0 and 3 will be consumed.
         */
        for (int i = 0; i < 5; i++) {
            producer.sendMessageToPartion(message + " ---- Partioned Topic!", i);
        }
        listener.partitionLatch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to 'filtered' topic. As per listener
         * configuration,  all messages with char sequence
         * 'World' will be discarded.
         */
        producer.sendMessageToFiltered("Hello !" + message);
        producer.sendMessageToFiltered("Hello hahaha!" + message);
        listener.filterLatch.await(10, TimeUnit.SECONDS);

        /*
         * Sending message to 'greeting' topic. This will send
         * and recieved a java object with the help of
         * greetingKafkaListenerContainerFactory.
         */
        producer.sendGreetingMessage(new Greeting(message + "Greetings", "World!"));
        listener.greetingLatch.await(10, TimeUnit.SECONDS);

    }
}
