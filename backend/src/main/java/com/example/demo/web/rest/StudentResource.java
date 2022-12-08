package com.example.demo.web.rest;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api")
public class StudentResource {


    private final StudentRepository studentRepository;

    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody Student student) throws URISyntaxException {
        Student student1 = studentRepository.save(student);
        return ResponseEntity.created(new URI("/students/" + student1.getId())).body(student1);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    @GetMapping("/{id}")
    public Student getAll(@PathVariable Long id) {
        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Student student) {
        Student student1 = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        student1.setName(student.getName());
        student1.setLastName(student.getLastName());
        student1.setEmail(student.getEmail());
        student1.setPassword(student.getPassword());
        return ResponseEntity.ok(student1);
    }

}
