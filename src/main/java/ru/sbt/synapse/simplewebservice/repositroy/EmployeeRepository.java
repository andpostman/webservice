package ru.sbt.synapse.simplewebservice.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.synapse.simplewebservice.model.EmployeeDto;

public interface EmployeeRepository extends JpaRepository<EmployeeDto, Long> {
}
