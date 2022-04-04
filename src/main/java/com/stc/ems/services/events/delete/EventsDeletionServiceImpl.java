package com.stc.ems.services.events.delete;

import com.stc.ems.repositories.EventsRepository;
import com.stc.ems.services.events.fetch.EventsFetchingService;
import org.springframework.stereotype.Service;

@Service
public class EventsDeletionServiceImpl implements EventsDeletionService {

    private final EventsRepository repository;
    private final EventsFetchingService eventsFetchingService;

    public EventsDeletionServiceImpl(EventsRepository repository, EventsFetchingService eventsFetchingService) {
        this.repository = repository;
        this.eventsFetchingService = eventsFetchingService;
    }

    @Override
    public void execute(Long eventId) {
        repository.delete(eventsFetchingService.execute(eventId));
    }
}
