package com.stc.ems.dtos.event.fetch;

import com.stc.ems.entities.EventStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class UpcomingEventDto implements Serializable {
    private final Long id;
    private final String name;
    private final String location;
    private final LocalDateTime fromDateTime;
    private final LocalDateTime toDateTime;
    private final String surveyLink;
    private final Boolean isVirtual;
    private final EventStatus eventStatus;
    private final boolean isFamilyMembersAllowed;
}
