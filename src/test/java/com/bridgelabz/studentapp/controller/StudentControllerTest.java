package com.bridgelabz.studentapp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.bridgelabz.studentapp.entity.StudentEntity;
import com.bridgelabz.studentapp.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

  @InjectMocks
  private StudentController studentController;
  @Mock
  private StudentService studentService;

  @Test
  public void studentsTest() {
    StudentEntity studentEntity1 = new StudentEntity();
    studentEntity1.setFirstName("test1");
    studentEntity1.setLastName("testLastName1");
    studentEntity1.setRollNo(1);
    studentEntity1.setId(1);
    StudentEntity studentEntity2 = new StudentEntity();
    studentEntity2.setFirstName("test2");
    studentEntity2.setLastName("testLastName2");
    studentEntity2.setRollNo(2);
    studentEntity2.setId(2);
    List<StudentEntity> studentEntities = new ArrayList<>();
    studentEntities.add(studentEntity1);
    studentEntities.add(studentEntity2);

//    when(studentService.students()).thenReturn(studentEntities);
//    List<StudentEntity> students = studentController.students();
//    assertEquals(2, students.size());
  }
}
