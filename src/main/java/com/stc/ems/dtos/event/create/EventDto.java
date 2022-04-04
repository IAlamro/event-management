package com.stc.ems.dtos.event.create;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventDto {

    private String name;
    private String location;
    private Long userId;
    private LocalDateTime startDate;
    private LocalDateTime toDate;
}
