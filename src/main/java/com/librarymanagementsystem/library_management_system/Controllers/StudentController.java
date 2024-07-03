package com.librarymanagementsystem.library_management_system.Controllers;

import com.librarymanagementsystem.library_management_system.Entities.Student;
import com.librarymanagementsystem.library_management_system.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        String result = studentService.addStudent(student);
        return result;
    }
}
