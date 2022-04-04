package com.stc.ems.services.notifications.fetch;

import com.stc.ems.dtos.notifications.fetch.EventNotificationDto;
import com.stc.ems.services.Query;

import java.util.List;

public interface NotificationsByUserFetchingService extends Query<Long, List<EventNotificationDto>> {
}
