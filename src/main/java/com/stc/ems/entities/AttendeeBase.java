package com.stc.ems.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
public abstract class AttendeeBase implements Serializable {

    @Id
    @GeneratedValue
    private long id;

//    @ManyToMany(mappedBy = "employeeAttendees")
//    private List<Event> events;
    private boolean deleted = Boolean.FALSE;
    private boolean confirmed = Boolean.FALSE;
}
