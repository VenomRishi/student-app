package com.bridgelabz.studentapp.repository;

import com.bridgelabz.studentapp.entity.StudentEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
  Optional<StudentEntity> findByFirstName(String firstName);
}
