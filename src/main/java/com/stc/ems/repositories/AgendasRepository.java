package com.stc.ems.repositories;

import com.stc.ems.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendasRepository extends JpaRepository <Agenda, Long> {
}
