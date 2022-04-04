package com.stc.ems.repositories;

import com.stc.ems.entities.EmployeeAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAttendeeRepository extends JpaRepository<EmployeeAttendee, Long> {
}