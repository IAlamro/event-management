package com.stc.ems.dtos.notifications.fetch;

import com.stc.ems.entities.NotificationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventNotificationDto {

    private String title;
    private String body;
    private Long eventId;
    private NotificationType type;
}
