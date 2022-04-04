package com.stc.ems.services.notifications.fetch;

import com.stc.ems.converter.notifications.fetch.EventToEventDtoConverter;
import com.stc.ems.dtos.notifications.fetch.EventNotificationDto;
import com.stc.ems.dtos.notifications.fetch.NotificationEventDto;
import com.stc.ems.entities.NotificationType;
import com.stc.ems.repositories.EmployeeBookingsRepository;
import com.stc.ems.repositories.EventsRepository;
import com.stc.ems.repositories.utils.IBookingsCountByEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationsByUserFetchingServiceImpl implements NotificationsByUserFetchingService {

    private final EventsRepository eventsRepository;
    private final EventToEventDtoConverter converter;
    private final EmployeeBookingsRepository employeeBookingsRepository;

    public NotificationsByUserFetchingServiceImpl(EventsRepository eventsRepository,
                                                  EventToEventDtoConverter converter,
                                                  EmployeeBookingsRepository employeeBookingsRepository) {
        this.eventsRepository = eventsRepository;
        this.converter = converter;
        this.employeeBookingsRepository = employeeBookingsRepository;
    }

    @Override
    public List<EventNotificationDto> execute(Long userId) {
        List<EventNotificationDto> notificationDtos = new LinkedList<>();

        List<NotificationEventDto> eventsToSendSurvey = fetchEventsToSendSurveyFromDatabase();
        List<IBookingsCountByEvent> iBookingsCountByEvents = employeeBookingsRepository.countByEventAndBookingStatus(LocalDateTime.now(), userId);

        for(NotificationEventDto notificationEventDto : eventsToSendSurvey){
            notificationDtos.add(EventNotificationDto.builder().eventId(notificationEventDto.getEventId()).title("").body("").type(NotificationType.SEND_SURVEY).build());
        }
        for (IBookingsCountByEvent iBookingsCountByEvent : iBookingsCountByEvents){
            notificationDtos.add(EventNotificationDto.builder().eventId(iBookingsCountByEvent.getEvent().getId()).title("").body("").type(NotificationType.CONFIRMATION_REMINDER).build());
        }

        return notificationDtos;
    }

    private List<NotificationEventDto> fetchEventsToSendSurveyFromDatabase() {
        return eventsRepository.findAllByIsSurveySentIsFalse().stream()
                .map(converter::convert).collect(Collectors.toList());
    }

//    private Map<Long, List<EmployeeBooking>> fetchNonConfirmedBookingsFromDatabase(Long userId) {
//        return eventsRepository
//                .findAllByManagers_employeeIdAndFromDateTimeIsAfter(userId, LocalDateTime.now())
//                .stream()
//                .map(e -> employeeBookingsRepository.findAllByEventAndBookingStatus(e, BookingStatus.NOT_CONFIRMED))
//                .collect(Collectors.groupingBy());
//    }
}
