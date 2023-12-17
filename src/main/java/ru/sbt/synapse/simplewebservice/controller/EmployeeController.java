package ru.sbt.synapse.simplewebservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbt.synapse.simplewebservice.property.Employee;
import ru.sbt.synapse.simplewebservice.model.EmployeeDto;
import ru.sbt.synapse.simplewebservice.service.EmployeeServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
@Slf4j
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        log.info("Calling get all employees method");
        return service.findAllEmployees();
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody Employee employee){
        log.info("Calling create employee method");
        return service.saveEmployee(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")long id){
        log.info("Calling get employee by id method");
        return ResponseEntity.ok(service.findEmployeeById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        log.info("Calling update employee method");
        return ResponseEntity.ok(service.updateEmployee(id,employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id){
        log.info("Calling delete employee method");
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
