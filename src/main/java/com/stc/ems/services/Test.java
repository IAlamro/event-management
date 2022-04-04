package com.stc.ems.services;

import com.stc.ems.dtos.event.create.EventDto;
import com.stc.ems.services.events.create.EventCreationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Test {
    private final EventCreationService eventCreationService;

    public Test(EventCreationService eventCreationService) {
        this.eventCreationService = eventCreationService;
    }

    public void test(){

        eventCreationService.execute(EventDto.builder().name("abc").location("test").startDate(LocalDateTime.now().plusDays(30)).userId(123L).build());

    }
}
