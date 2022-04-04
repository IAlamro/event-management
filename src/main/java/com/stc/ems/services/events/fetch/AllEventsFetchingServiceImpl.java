package com.stc.ems.services.events.fetch;

import com.stc.ems.entities.Event;
import com.stc.ems.repositories.EventsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllEventsFetchingServiceImpl implements AllEventsFetchingService {

    private final EventsRepository repository;

    public AllEventsFetchingServiceImpl(EventsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> execute() {
        return repository.findAll();
    }
}
