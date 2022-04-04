package com.stc.ems.converter.event.fetch;

import com.stc.ems.converter.Converter;
import com.stc.ems.dtos.event.fetch.UpcomingEventDto;
import com.stc.ems.entities.Event;

import java.util.List;

public interface EventsToUpComingEventsConverter extends Converter<List<Event>, List<UpcomingEventDto>> {
}
