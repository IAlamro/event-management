package com.stc.ems.entities;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity(name = "stc_contractor_family_member_attendees")
@SQLDelete(sql = "UPDATE stc_contractor_family_member_attendees SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ContractorFamilyMemberAttendees extends FamilyMemberAttendee{

    private String firstName;
    private String middleName;
    private String familyName;
}
