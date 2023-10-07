package ru.sbt.synapse.simplewebservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.synapse.simplewebservice.model.Employee;
import ru.sbt.synapse.simplewebservice.repositroy.EmployeeRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class EmployeeController {

    private final EmployeeRepository repository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }
}
