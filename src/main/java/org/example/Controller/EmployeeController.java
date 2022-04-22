package org.example.Controller;

import org.example.Model.EmployeeModel;
import org.example.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintDeclarationException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/list")
    public ResponseEntity getAllEmployee() {
        try {
            return ResponseEntity.ok(employeeRepository.findAll());
        } catch (Exception e) {
            return new ResponseEntity(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/create")
    public ResponseEntity createEmployee(@RequestBody EmployeeModel body) {
        try {
            employeeRepository.save(new EmployeeModel(body));
            return ResponseEntity.ok(employeeRepository.findAll());
        } catch (ConstraintViolationException e) {
             e.getConstraintViolations().stream().map();
            return new ResponseEntity(e.getConstraintViolations(), HttpStatus.CONFLICT);
        }
    }

    public static List<ValidationError>
}
