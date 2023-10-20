package ru.sbt.synapse.simplewebservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbt.synapse.simplewebservice.property.Employee;
import ru.sbt.synapse.simplewebservice.model.EmployeeDto;
import ru.sbt.synapse.simplewebservice.service.EmployeeServiceImpl;

import java.util.List;

@CrossOrigin(origins = "${react.url}")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @GetMapping
    public List<EmployeeDto> getAllEmployees(){
        return service.findAllEmployees();
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")long id){
        return ResponseEntity.ok(service.findEmployeeById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return ResponseEntity.ok(service.updateEmployee(id,employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id){
        service.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
