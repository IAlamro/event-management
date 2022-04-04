package com.stc.ems.services.events.update;

import com.stc.ems.entities.Event;
import com.stc.ems.exceptions.events.update.NoChangesOnEventException;
import com.stc.ems.repositories.EventsRepository;
import com.stc.ems.services.events.fetch.EventsFetchingService;
import org.springframework.stereotype.Service;

@Service
public class EventUpdatingServiceImpl implements EventUpdatingService {

    private final EventsRepository repository;
    private final EventsFetchingService eventsFetchingService;

    public EventUpdatingServiceImpl(EventsRepository repository, EventsFetchingService eventsFetchingService) {
        this.repository = repository;
        this.eventsFetchingService = eventsFetchingService;
    }

    @Override
    public Event execute(Event event) {
        Event old = eventsFetchingService.execute(event.getId());
        if (event.equals(old))
            throw new NoChangesOnEventException();
        return repository.save(event);
    }
}
