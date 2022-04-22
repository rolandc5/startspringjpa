package org.example.Controller;

import org.example.Model.DepartmentModel;
import org.example.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;

@RestController
@RequestMapping("/departments")
public class Departments {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/list")
    public ResponseEntity getAllDepartment() throws SQLException {
       try {
           return ResponseEntity.ok(departmentRepository.findAll());
       } catch (Exception e) {
           return new ResponseEntity(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
       }
    }

    @PostMapping("/create")
    public ResponseEntity createDepartment(@RequestBody DepartmentModel body) {
        try {
            departmentRepository.save(new DepartmentModel(body.getName()));
            return ResponseEntity.ok(departmentRepository.findAll());
        } catch (Exception e){
            return new ResponseEntity(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }
}
