package com.stc.ems.repositories;

import com.stc.ems.entities.FamilyMemberAttendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberAttendeeRepository extends JpaRepository<FamilyMemberAttendee, Long> {
}