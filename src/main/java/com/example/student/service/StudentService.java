package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.vo.Faculty;
import com.example.student.vo.ReponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    public ReponseTemplateVO getStudentWithFaculty(Long studentId){
        ReponseTemplateVO vo = new ReponseTemplateVO();
        Student student = studentRepository.findById(studentId).get();
        vo.setStudent(student);
        Faculty faculty = restTemplate.getForObject("http://localhost:9001/faculty/"
                        +student.getFacultyId(),Faculty.class);
        vo.setFaculty(faculty);
        return vo;
    }
}
