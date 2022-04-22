package org.example.Controller;

import org.example.Model.JobTitleModel;
import org.example.Repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-title")
public class JobTitleController {

    @Autowired
    JobTitleRepository jobTitleRepository;

    @GetMapping("/list")
    public ResponseEntity getAllJobTitle() {
        try {
            return ResponseEntity.ok(jobTitleRepository.findAll());
        } catch (Exception e) {
            return new ResponseEntity(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/create")
    public ResponseEntity createJobTitle(@RequestBody JobTitleModel body) {
        try {
           jobTitleRepository.save(new JobTitleModel(body.getName()));
           return ResponseEntity.ok(jobTitleRepository.findAll());
        } catch (Exception e) {
            return new ResponseEntity(e.getCause().getCause().getMessage(), HttpStatus.CONFLICT);
        }
    }
}
