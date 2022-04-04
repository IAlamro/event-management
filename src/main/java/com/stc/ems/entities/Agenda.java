package com.stc.ems.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "stc_events_agenda")
@SQLDelete(sql = "UPDATE stc_events_agenda SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Agenda {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "agenda")
    private List<EventDay> eventDays = new java.util.ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Event event;
    private boolean deleted = Boolean.FALSE;
}
