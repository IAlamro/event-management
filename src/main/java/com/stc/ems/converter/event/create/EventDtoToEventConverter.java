package com.stc.ems.converter.event.create;

import com.stc.ems.converter.Converter;
import com.stc.ems.dtos.event.create.EventDto;
import com.stc.ems.entities.Event;

public interface EventDtoToEventConverter extends Converter<EventDto, Event> {

}
