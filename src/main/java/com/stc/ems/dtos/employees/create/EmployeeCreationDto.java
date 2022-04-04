package com.stc.ems.dtos.employees.create;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeCreationDto {

    private Long id;
    private List<Long> managedEvents;
}
