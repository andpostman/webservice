package ru.sbt.synapse.simplewebservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sbt.synapse.simplewebservice.property.Employee;
import ru.sbt.synapse.simplewebservice.exception.ResourceNotFoundException;
import ru.sbt.synapse.simplewebservice.model.EmployeeDto;
import ru.sbt.synapse.simplewebservice.repositroy.EmployeeRepository;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    @Override
    public List<EmployeeDto> findAllEmployees() {
        return repository.findAll();
    }

    @Override
    public EmployeeDto saveEmployee(Employee employee) {
        return repository.save(new EmployeeDto(employee.getFirstName(), employee.getLastName(), employee.getEmailId()));
    }

    @Override
    public EmployeeDto findEmployeeById(long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
    }

    @Override
    public EmployeeDto updateEmployee(long id, Employee employee) {
        EmployeeDto employeeDto = findEmployeeById(id);
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmailId(employee.getEmailId());
        return repository.save(employeeDto);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(long id) {
        return null;
    }
}
