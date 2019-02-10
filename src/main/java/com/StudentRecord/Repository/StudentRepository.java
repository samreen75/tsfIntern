package com.StudentRecord.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentRecord.Model.StudentModel;

//@Repository

public interface StudentRepository extends JpaRepository<StudentModel, Long>  {


}
