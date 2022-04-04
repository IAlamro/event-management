package com.stc.ems.services.employees.fetch;

import com.stc.ems.entities.EmployeeAttendee;
import com.stc.ems.repositories.EmployeeAttendeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeesFetchingServiceImpl implements EmployeesFetchingService {

    private final EmployeeAttendeeRepository repository;

    public EmployeesFetchingServiceImpl(EmployeeAttendeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeAttendee execute(Long employeeId) {
        return repository.findById(employeeId).orElseThrow(RuntimeException::new);
    }
}
