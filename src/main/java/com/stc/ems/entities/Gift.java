package com.stc.ems.entities;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "stc_event_gifts")
@SQLDelete(sql = "UPDATE stc_event_gifts SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Gift {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private boolean daily = Boolean.FALSE;
    private boolean deleted = Boolean.FALSE;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private EventDay eventDay;
    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeAttendee employeeAttendee;
}
