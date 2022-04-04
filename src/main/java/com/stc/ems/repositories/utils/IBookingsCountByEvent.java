package com.stc.ems.repositories.utils;

import com.stc.ems.entities.Event;

public interface IBookingsCountByEvent {
    Event getEvent();
    Long getTotalBookings();
}
