package com.stc.ems.services.events.create;

import com.stc.ems.dtos.event.create.EventDto;
import com.stc.ems.entities.Event;
import com.stc.ems.services.Query;

public interface EventCreationService extends Query<EventDto, Event> {
}
