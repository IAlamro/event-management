package com.stc.ems.repositories;

import com.stc.ems.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository <Event, Long> {

    List<Event> findAllByManagers_employeeIdAndFromDateTimeIsAfter(Long employeeAttendees, LocalDateTime localDateTime);
    List<Event> findAllByIsSurveySentIsFalse();
}
