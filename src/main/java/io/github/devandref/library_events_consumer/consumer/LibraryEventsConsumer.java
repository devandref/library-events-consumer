package io.github.devandref.library_events_consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.devandref.library_events_consumer.service.LibraryEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LibraryEventsConsumer {

    @Autowired
    private LibraryEventsService libraryEventsService;

    @KafkaListener(topics = {"library-events"}, groupId = "library-events-consumer")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        log.info("ConsumerRecord: {}", consumerRecord);
        libraryEventsService.processLibraryEvent(consumerRecord);
    }

}
