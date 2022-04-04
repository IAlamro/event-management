package com.stc.ems.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "stc_events")
@SQLDelete(sql = "UPDATE stc_events SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private String surveyLink;
    private Boolean isVirtual = Boolean.FALSE;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "event")
    private Agenda agenda;
    @Enumerated
    private EventStatus eventStatus;
    private boolean isDraft = Boolean.FALSE;
    private boolean isFamilyMembersAllowed = Boolean.FALSE;
    private boolean isSurveySent = Boolean.FALSE;
    @ManyToMany
    @JoinTable(
            name = "stc_events_managers",
            joinColumns = @JoinColumn(name = "stc_events_id"),
            inverseJoinColumns = @JoinColumn(name = "stc_employee_attendees_id"))
    private List<EmployeeAttendee> managers;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EmployeeBooking> booking;
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<FamilyMemberBooking> familyMemberBooking;
    private boolean deleted = Boolean.FALSE;
//    @ManyToMany
//    @JoinTable(
//            name = "stc_employees_events_attendees",
//            joinColumns = @JoinColumn(name = "stc_events_id"),
//            inverseJoinColumns = @JoinColumn(name = "stc_employee_attendees_id"))
//    private List<EmployeeAttendee> employeeAttendees;
//    @ManyToMany
//    @JoinTable(
//            name = "stc_family_member_events_attendees",
//            joinColumns = @JoinColumn(name = "stc_events_id"),
//            inverseJoinColumns = @JoinColumn(name = "stc_family_member_attendees_id"))
//    private List<FamilyMemberAttendee> familyMemberAttendees;

}
