package com.stc.ems.converter.notifications.fetch;

import com.stc.ems.dtos.notifications.fetch.NotificationEventDto;
import com.stc.ems.entities.Event;
import org.springframework.stereotype.Component;

@Component
public class EventToEventDtoConverterImpl implements EventToEventDtoConverter {
    @Override
    public NotificationEventDto convert(Event event) {
        return NotificationEventDto.builder().eventId(event.getId()).build();
    }
}
