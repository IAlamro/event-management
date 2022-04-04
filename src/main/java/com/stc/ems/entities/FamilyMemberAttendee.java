package com.stc.ems.entities;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity(name = "stc_family_member_attendees")
@SQLDelete(sql = "UPDATE stc_family_member_attendees SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
public class FamilyMemberAttendee extends AttendeeBase{

    private long dependantId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private EmployeeAttendee employee;
}
