package com.stc.ems.converter.event.fetch;

import com.stc.ems.dtos.event.fetch.UpcomingEventDto;
import com.stc.ems.entities.Event;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class EventsToUpComingEventsConverterImpl implements EventsToUpComingEventsConverter {

    @Override
    public List<UpcomingEventDto> convert(List<Event> events) {
        List<UpcomingEventDto> upcomingEvents = new LinkedList<>();
        for (Event event : events) {
            upcomingEvents.add(getUpcomingEventDtoFromEvent(event));
        }
        return upcomingEvents;
    }

    private UpcomingEventDto getUpcomingEventDtoFromEvent(Event event) {
        return UpcomingEventDto.builder()
                .id(event.getId())
                .fromDateTime(event.getFromDateTime())
                .toDateTime(event.getToDateTime())
                .eventStatus(event.getEventStatus())
                .isFamilyMembersAllowed(event.isFamilyMembersAllowed())
                .isVirtual(event.getIsVirtual())
                .location(event.getLocation())
                .name(event.getName())
                .surveyLink(event.getSurveyLink()).build();
    }
}
