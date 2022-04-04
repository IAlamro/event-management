package com.stc.ems.converter.event.create;

import com.stc.ems.dtos.event.create.EventDto;
import com.stc.ems.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class EventDtoToEventConverterImpl implements EventDtoToEventConverter {

    @Override
    public Event convert(EventDto eventDto) {
        Event event = new Event();
        event.setName(eventDto.getName());
        event.setLocation(eventDto.getLocation());
        event.setFromDateTime(eventDto.getStartDate());
        event.setToDateTime(eventDto.getToDate());
        return event;
    }
}
