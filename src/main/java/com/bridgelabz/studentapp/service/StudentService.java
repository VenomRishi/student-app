package com.bridgelabz.studentapp.service;

import com.bridgelabz.studentapp.dto.StudentDTO;
import com.bridgelabz.studentapp.entity.StudentEntity;
import com.bridgelabz.studentapp.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class for the business logic for student service
 *
 * @author Rishikesh Mhatre
 * @version 0.0.1
 * @since 11-10-2021
 */

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private ModelMapper modelMapper;

  /**
   * Method for getting all the students from database
   * @return list of {@link StudentEntity}
   */
  public List<StudentEntity> students() {
    return studentRepository.findAll();
  }

  /**
   * Method for getting student by its id
   * @param id unique identifier for record
   * @return singular {@link StudentEntity}
   */
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


  /**
   *
   * @param studentDTO
   * @return
   */
  public StudentEntity addStudent(StudentDTO studentDTO) {
    StudentEntity studentEntity = new StudentEntity();

    modelMapper.map(studentDTO, studentEntity);

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
