package com.stc.ems.exceptions.events.update;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "No fields have been changed")
public class NoChangesOnEventException extends RuntimeException {
}
