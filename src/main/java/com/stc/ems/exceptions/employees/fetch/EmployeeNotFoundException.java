package com.stc.ems.exceptions.employees.fetch;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Provided employee couldn't be found")
public class EmployeeNotFoundException extends RuntimeException{
}
