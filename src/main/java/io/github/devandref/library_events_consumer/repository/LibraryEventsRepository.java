package io.github.devandref.library_events_consumer.repository;

import io.github.devandref.library_events_consumer.entity.LibraryEvent;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent, Integer> {

}
