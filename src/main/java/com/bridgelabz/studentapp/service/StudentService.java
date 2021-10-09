package com.bridgelabz.studentapp.service;

import com.bridgelabz.studentapp.dto.StudentDTO;
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

  public StudentEntity getStudentById(int id) {
    Optional<StudentEntity> studentEntity = studentRepository.findById(id);
    if(studentEntity.isPresent()) {
      return studentEntity.get();
    }
    return null;
  }

  public StudentEntity getStudentByName(String firstName) {
    Optional<StudentEntity> studentEntity = studentRepository.findByFirstName(firstName);
    if(studentEntity.isPresent()) {
      return studentEntity.get();
    }
    return null;
  }

  public StudentEntity addStudent(StudentDTO studentDTO) {
    StudentEntity studentEntity = new StudentEntity();

    studentEntity.setFirstName(studentDTO.getFirstName());
    studentEntity.setLastName(studentDTO.getLastName());
    studentEntity.setRollNo(studentDTO.getRollNo());

    return studentRepository.save(studentEntity);
  }

  public StudentEntity updateStudent(int id, StudentDTO studentDTO) {
    Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
    if(optionalStudentEntity.isPresent()) {
      StudentEntity studentEntity = optionalStudentEntity.get();
      studentEntity.setFirstName(studentDTO.getFirstName());
      studentEntity.setLastName(studentDTO.getLastName());
      studentEntity.setRollNo(studentDTO.getRollNo());
      return studentRepository.save(studentEntity);
    }
    return null;
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
