package com.learning.RestAPIs.controllers;


import com.learning.RestAPIs.DTO.AddStudentRequestDto;
import com.learning.RestAPIs.DTO.StudentDTO;
import com.learning.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentControllers {


    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents() {
        return ResponseEntity.status(HttpStatus.OK).
                body(studentService.getAllStudents());
//        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentService.getStudenById(id));


    }

    @PostMapping
    public ResponseEntity<StudentDTO>
    createStudent(@RequestBody  AddStudentRequestDto addStudentRequestDto)
    {
//        System.out.print("value:"+addStudentRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id,
                                                    @RequestBody
                                                    AddStudentRequestDto
                                                            addStudentRequestDto)
    {
        System.out.println(id+":"+addStudentRequestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.
                        updateStudentByID(id,addStudentRequestDto));
    }



}
