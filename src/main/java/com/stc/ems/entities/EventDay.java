package com.stc.ems.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "stc_event_day")
@SQLDelete(sql = "UPDATE stc_event_day SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class EventDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private LocalTime fromDateTime;
    private LocalTime toDateTime;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Agenda agenda;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventDay")
    private List<Gift> gifts;

}