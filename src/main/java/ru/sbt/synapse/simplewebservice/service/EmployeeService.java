package ru.sbt.synapse.simplewebservice.service;

import ru.sbt.synapse.simplewebservice.property.Employee;
import ru.sbt.synapse.simplewebservice.model.EmployeeDto;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeDto> findAllEmployees();
    EmployeeDto saveEmployee(Employee employee);
    EmployeeDto findEmployeeById(long id);
    EmployeeDto updateEmployee(long id, Employee employee);
    Map<String, Boolean> deleteEmployee(long id);
}
