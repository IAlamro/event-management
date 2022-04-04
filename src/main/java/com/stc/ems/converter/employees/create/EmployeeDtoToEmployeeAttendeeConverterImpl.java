package com.stc.ems.converter.employees.create;

import com.stc.ems.dtos.employees.create.EmployeeCreationDto;
import com.stc.ems.entities.EmployeeAttendee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoToEmployeeAttendeeConverterImpl implements EmployeeDtoToEmployeeAttendeeConverter {

    @Override
    public EmployeeAttendee convert(EmployeeCreationDto employeeCreationDto) {
        return getEmployeeAttendee(employeeCreationDto);
    }

    private EmployeeAttendee getEmployeeAttendee(EmployeeCreationDto employeeCreationDto) {
        EmployeeAttendee employeeAttendee = getEmployeeAttendee(employeeCreationDto);
        employeeAttendee.setEmployeeId(employeeAttendee.getEmployeeId());
        return employeeAttendee;
    }
}
