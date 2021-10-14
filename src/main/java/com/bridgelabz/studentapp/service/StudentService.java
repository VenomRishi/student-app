package com.bridgelabz.studentapp.service;

import com.bridgelabz.studentapp.dto.StudentDTO;
import com.bridgelabz.studentapp.dto.StudentResponseDto;
import com.bridgelabz.studentapp.entity.StudentEntity;
import com.bridgelabz.studentapp.exception.CustomException;
import com.bridgelabz.studentapp.repository.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<StudentResponseDto> students() {
    return studentRepository.findAll()
        .stream()
        .map(studentEntity -> modelMapper.map(studentEntity, StudentResponseDto.class))
        .collect(Collectors.toList());
  }

  /**
   * Method for getting student by its id
   *
   * @param id unique identifier for record
   * @return singular {@link StudentEntity}
   */
  public StudentEntity getStudentById(int id) {
    return studentRepository.findById(id)
        .orElseThrow(() -> new CustomException("Record does not exists with this id : " + id));
  }

  public StudentEntity getStudentByName(String firstName) {
    return studentRepository.findByFirstName(firstName)
        .orElseThrow(
            () -> new CustomException("Record does not exists with this firstName : " + firstName));
  }


  /**
   *
   */
  public StudentEntity addStudent(StudentDTO studentDTO) {
    StudentEntity studentEntity = new StudentEntity();
    modelMapper.map(studentDTO, studentEntity);
    return studentRepository.save(studentEntity);
  }

  public StudentEntity updateStudent(int id, StudentDTO studentDTO) {
    StudentEntity studentEntity = getStudentById(id);
    modelMapper.map(studentDTO, studentEntity);
    return studentRepository.save(studentEntity);
  }

  public String deleteStudent(int id) {
    StudentEntity studentEntity = getStudentById(id);

    studentRepository.delete(studentEntity);
    return "Record deleted successfully";
  }
}
