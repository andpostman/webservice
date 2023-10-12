package ru.sbt.synapse.simplewebservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sbt.synapse.simplewebservice.dto.Employee;
import ru.sbt.synapse.simplewebservice.model.EmployeeDto;
import ru.sbt.synapse.simplewebservice.service.EmployeeServiceImpl;

import java.util.List;

@CrossOrigin(origins = "${react.url}")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        return service.findAllEmployees();
    }

    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }
}
