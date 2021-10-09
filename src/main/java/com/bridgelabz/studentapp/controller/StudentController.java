package com.bridgelabz.studentapp.controller;

import com.bridgelabz.studentapp.dto.StudentDTO;
import com.bridgelabz.studentapp.entity.StudentEntity;
import com.bridgelabz.studentapp.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public StudentEntity getStudentByName(@RequestParam String firstName) {
    return studentService.getStudentByName(firstName);
  }

  @PostMapping(value = "/student")
  public StudentEntity addStudent(@RequestBody StudentDTO studentDTO) {
    return studentService.addStudent(studentDTO);
  }

  @PutMapping(value = "/student")
  public StudentEntity updateStudent(
      @PathVariable int id,
      @RequestBody StudentDTO studentDTO) {
    return studentService.updateStudent(id, studentDTO);
  }

  @DeleteMapping(value = "/student")
  public String deleteStudent(@RequestParam int id) {
    return studentService.deleteStudent(id);
  }

}
