package com.stc.ems.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stc_employee_attendees")
@SQLDelete(sql = "UPDATE stc_employee_attendees SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class EmployeeAttendee extends AttendeeBase{

    private long employeeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<FamilyMemberAttendee> familyMemberAttendees;
    @ManyToMany(mappedBy = "managers")
    private List<Event> managedEvents;
    @OneToMany(mappedBy = "employeeAttendee", cascade = CascadeType.ALL)
    private List<EmployeeBooking> bookings;
    @OneToMany(mappedBy = "employeeAttendee", cascade = CascadeType.ALL)
    private List<FamilyMemberBooking> familyMemberBooking;
    @OneToOne(mappedBy = "employeeAttendee", cascade = CascadeType.ALL)
    private Gift gift;
}
