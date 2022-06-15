package com.example.springsecurity.student;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> students = Arrays.asList(
            new Student(1,"Lalo Salamanca"),
            new Student(2,"Gustavo Fring"),
            new Student(3,"Jesse Pinkman")
    );
    @GetMapping
   // @PreAuthorize("hasAnyAuthority('ROLE_ADMIN, ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents(){
        return students;
    }
    @PostMapping
    //@PreAuthorize("hasAuthority('student:write')")

    public void registerNewStudent(@RequestBody Student student){
        System.out.println(student);
    }
    @DeleteMapping(path = "{studentId}")
    //@PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        System.out.println(studentId);
    }

    @PutMapping("{studentId}")
    //@PreAuthorize("hasAuthority('student:write')")

    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student){
        System.out.println(String.format("%s %s", studentId, student));
    }
}
