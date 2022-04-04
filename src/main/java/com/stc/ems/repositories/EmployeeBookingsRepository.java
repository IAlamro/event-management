package com.stc.ems.repositories;

import com.stc.ems.entities.BookingStatus;
import com.stc.ems.entities.EmployeeBooking;
import com.stc.ems.entities.Event;
import com.stc.ems.repositories.utils.IBookingsCountByEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeBookingsRepository extends JpaRepository<EmployeeBooking, Long> {

    List<EmployeeBooking> findAllByEventAndBookingStatus(Event event, BookingStatus bookingStatus);
    @Query("SELECT b.event, COUNT(b.id) FROM EmployeeBooking AS b WHERE b.event.fromDateTime > :fromDateTime AND b.event.id IN (SELECT e.managedEvents FROM EmployeeAttendee AS e where e.id = :userId) GROUP BY b.event")
    List<IBookingsCountByEvent> countByEventAndBookingStatus(LocalDateTime fromDateTime, long userId);

}
