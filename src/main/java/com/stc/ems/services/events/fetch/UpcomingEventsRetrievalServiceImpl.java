package com.stc.ems.services.events.fetch;

import com.stc.ems.converter.event.fetch.EventsToUpComingEventsConverter;
import com.stc.ems.dtos.event.fetch.UpcomingEventDto;
import com.stc.ems.repositories.EventsRepository;
import com.stc.ems.services.employees.fetch.EmployeesFetchingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UpcomingEventsRetrievalServiceImpl implements UpcomingEventsRetrievalService {

    private final EventsRepository repository;
    private final EmployeesFetchingService employeesFetchingService;
    private final EventsToUpComingEventsConverter converter;

    public UpcomingEventsRetrievalServiceImpl(EventsRepository repository,
                                              EmployeesFetchingService employeesFetchingService, EventsToUpComingEventsConverter converter) {
        this.repository = repository;
        this.employeesFetchingService = employeesFetchingService;
        this.converter = converter;
    }

    @Override
    public List<UpcomingEventDto> execute(Long employeeId) {
        return converter.convert(repository.findAllByManagers_employeeIdAndFromDateTimeIsAfter(employeesFetchingService.execute(employeeId).getEmployeeId(), LocalDateTime.now()));
//                        findAllByManagers(
//                Collections.singletonList(employeesFetchingService.execute(employeeId)), LocalDateTime.now()));
    }
}
