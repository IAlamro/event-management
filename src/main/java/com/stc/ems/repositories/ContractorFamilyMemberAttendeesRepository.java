package com.stc.ems.repositories;

import com.stc.ems.entities.ContractorFamilyMemberAttendees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorFamilyMemberAttendeesRepository extends JpaRepository<ContractorFamilyMemberAttendees, Long> {
}