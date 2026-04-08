package com.learning.RestAPIs.service;

import com.learning.RestAPIs.DTO.AddStudentRequestDto;
import com.learning.RestAPIs.DTO.StudentDTO;

import java.util.List;

public interface StudentService {


    List<StudentDTO> getAllStudents();

    StudentDTO getStudenById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDTO updateStudentByID(Long id, AddStudentRequestDto addStudentRequestDto);


}
