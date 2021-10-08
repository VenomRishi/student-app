package com.bridgelabz.studentapp.service;

import com.bridgelabz.studentapp.entity.StudentEntity;
import com.bridgelabz.studentapp.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<StudentEntity> students() {
    return studentRepository.findAll();
  }

  public StudentEntity addStudent(StudentEntity studentEntity) {
    return studentRepository.save(studentEntity);
  }

  public StudentEntity updateStudent(StudentEntity studentEntity) {
    return studentRepository.save(studentEntity);
  }

  public String deleteStudent(int id) {
    Optional<StudentEntity> studentEntity = studentRepository.findById(id);
    if (studentEntity.isPresent()) {
      studentRepository.delete(studentEntity.get());
      return "Record deleted successfully";
    }
    return "Record does not exists with this id : " + id;
  }
}
