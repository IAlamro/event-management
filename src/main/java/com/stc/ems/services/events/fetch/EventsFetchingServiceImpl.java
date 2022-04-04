package com.stc.ems.services.events.fetch;

import com.stc.ems.entities.Event;
import com.stc.ems.exceptions.events.fetch.EventNotFoundException;
import com.stc.ems.repositories.EventsRepository;
import org.springframework.stereotype.Service;

@Service
public class EventsFetchingServiceImpl implements EventsFetchingService {

    private final EventsRepository repository;

    public EventsFetchingServiceImpl(EventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Event execute(Long id) {
        return repository.findById(id).orElseThrow(EventNotFoundException::new);
    }
}
