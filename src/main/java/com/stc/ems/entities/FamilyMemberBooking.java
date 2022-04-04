package com.stc.ems.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "stc_events_fm_booking")
@SQLDelete(sql = "UPDATE stc_events_fm_booking SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class FamilyMemberBooking {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private EmployeeAttendee employeeAttendee;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Event event;
    @Enumerated
    private BookingStatus bookingStatus;
    private boolean deleted = Boolean.FALSE;
}
