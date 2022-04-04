package com.stc.ems.services.events.fetch;

import com.stc.ems.dtos.event.fetch.UpcomingEventDto;
import com.stc.ems.services.Query;

import java.util.List;

public interface UpcomingEventsRetrievalService extends Query<Long, List<UpcomingEventDto>> {
}
