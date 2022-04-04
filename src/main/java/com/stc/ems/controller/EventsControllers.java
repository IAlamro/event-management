package com.stc.ems.controller;

import com.stc.ems.dtos.event.create.EventDto;
import com.stc.ems.dtos.event.fetch.UpcomingEventDto;
import com.stc.ems.entities.Event;
import com.stc.ems.services.events.create.EventCreationService;
import com.stc.ems.services.events.delete.EventsDeletionService;
import com.stc.ems.services.events.fetch.AllEventsFetchingService;
import com.stc.ems.services.events.fetch.EventsFetchingService;
import com.stc.ems.services.events.fetch.UpcomingEventsRetrievalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import sa.com.stc.cs.blinkplus.core.util.DoBoxUtils;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/events")
public class EventsControllers {

    private final EventCreationService eventCreationService;
    private final AllEventsFetchingService allEventsFetchingService;
    private final EventsFetchingService eventsFetchingService;
    private final UpcomingEventsRetrievalService upcomingEventsRetrievalService;
    private final EventsDeletionService eventsDeletionService;

    public EventsControllers(EventCreationService eventCreationService,
                             AllEventsFetchingService allEventsFetchingService,
                             EventsFetchingService eventsFetchingService,
                             UpcomingEventsRetrievalService upcomingEventsRetrievalService,
                             EventsDeletionService eventsDeletionService) {
        this.eventCreationService = eventCreationService;
        this.allEventsFetchingService = allEventsFetchingService;
        this.eventsFetchingService = eventsFetchingService;
        this.upcomingEventsRetrievalService = upcomingEventsRetrievalService;
        this.eventsDeletionService = eventsDeletionService;
    }

    @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody EventDto eventDto){
        return status(CREATED).body(eventCreationService.execute(eventDto).getId());
    }

    @GetMapping
    public ResponseEntity<List<Event>> fetchEvents(){
        return ok(allEventsFetchingService.execute());
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEvent(@PathVariable("eventId") Long eventId){
        return ResponseEntity.ok(eventsFetchingService.execute(eventId));
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("eventId") Long eventId){
        eventsDeletionService.execute(eventId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/upcoming-events")
    public ResponseEntity<List<UpcomingEventDto>> getUpcomingEvents(@RequestHeader(value = "Authorization") String token){
//        Long userId = DoBoxUtils.getUserIdFromJWT(token);
        return ResponseEntity.ok(upcomingEventsRetrievalService.execute(123L));
    }
}
