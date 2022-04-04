package com.stc.ems.services.employees.create;

import com.stc.ems.converter.employees.create.EmployeeDtoToEmployeeAttendeeConverter;
import com.stc.ems.dtos.employees.create.EmployeeCreationDto;
import com.stc.ems.entities.EmployeeAttendee;
import com.stc.ems.repositories.EmployeeAttendeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCreationServiceImpl implements EmployeeCreationService {
    private final EmployeeAttendeeRepository repository;
    private final EmployeeDtoToEmployeeAttendeeConverter converter;

    public EmployeeCreationServiceImpl(EmployeeAttendeeRepository repository, EmployeeDtoToEmployeeAttendeeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public EmployeeAttendee execute(EmployeeCreationDto employeeCreationDto) {
        return repository.save(converter.convert(employeeCreationDto));
    }
}
