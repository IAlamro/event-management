package com.stc.ems.repositories;

import com.stc.ems.entities.EventDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDayRepository extends JpaRepository<EventDay, Long> {
}