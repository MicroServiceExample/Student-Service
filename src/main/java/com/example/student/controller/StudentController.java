package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.example.student.vo.ReponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @GetMapping("/{id}")
    public ReponseTemplateVO getStudentWithFaculty(@PathVariable("id") Long studentId){
        return studentService.getStudentWithFaculty(studentId);
    }
}
