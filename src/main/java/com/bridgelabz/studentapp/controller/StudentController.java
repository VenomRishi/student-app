package com.bridgelabz.studentapp.controller;

import com.bridgelabz.studentapp.entity.StudentEntity;
import com.bridgelabz.studentapp.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  // CRUD
  //read
  //creating
  //updating
  //deleting

  @Autowired
  private StudentService studentService;

  @GetMapping(value = "/students")
  public List<StudentEntity> students() {
    return studentService.students();
  }

  @GetMapping(value = "/get-student-by-id")
  public StudentEntity getStudentById(@RequestParam int id) {
    return studentService.getStudentById(id);
  }

  @GetMapping(value = "/get-student-by-name")
  public StudentEntity getStudentByName(@RequestParam String name) {
    return studentService.getStudentByName(name);
  }

  @PostMapping(value = "/student")
  public StudentEntity addStudent(@RequestBody StudentEntity studentEntity) {
    return studentService.addStudent(studentEntity);
  }

  @PutMapping(value = "/student")
  public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity) {
    return studentService.updateStudent(studentEntity);
  }

  @DeleteMapping(value = "/student")
  public String deleteStudent(@RequestParam int id) {
    return studentService.deleteStudent(id);
  }

}
