package com.stc.ems.exceptions.events.fetch;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Provided event couldn't be found")
public class EventNotFoundException extends RuntimeException {
}
