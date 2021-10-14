package com.bridgelabz.studentapp.service;

import com.bridgelabz.studentapp.dto.StudentResponseDto;
import com.bridgelabz.studentapp.entity.StudentEntity;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Class for the business logic for student service
 *
 * @author Rishikesh Mhatre
 * @version 0.0.1
 * @since 11-10-2021
 */

public interface IStudentService {

  /**
   * Method for getting all the students from database
   *
   * @return list of {@link StudentEntity}
   */
  public List<StudentResponseDto> students();
}
