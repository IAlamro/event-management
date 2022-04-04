package com.stc.ems.converter.notifications.fetch;

import com.stc.ems.converter.Converter;
import com.stc.ems.dtos.notifications.fetch.NotificationEventDto;
import com.stc.ems.entities.Event;

public interface EventToEventDtoConverter extends Converter<Event, NotificationEventDto> {
}
