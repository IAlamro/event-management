package com.stc.ems.services.events.create;

import com.stc.ems.converter.event.create.EventDtoToEventConverter;
import com.stc.ems.dtos.event.create.EventDto;
import com.stc.ems.entities.Event;
import com.stc.ems.repositories.EventsRepository;
import com.stc.ems.services.employees.fetch.EmployeesFetchingService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class EventCreationServiceImpl implements EventCreationService {

    private final EventsRepository repository;
    private final EventDtoToEventConverter converter;
    private final EmployeesFetchingService employeesFetchingService;

    public EventCreationServiceImpl(EventsRepository repository, EventDtoToEventConverter converter, EmployeesFetchingService employeesFetchingService) {
        this.repository = repository;
        this.converter = converter;
        this.employeesFetchingService = employeesFetchingService;
    }

    @Override
    public Event execute(EventDto eventDto) {
        Event event = converter.convert(eventDto);
        //TODO
//        event.setManagers(Collections.singletonList(employeesFetchingService.execute()));
        return repository.save(event);
    }
}
