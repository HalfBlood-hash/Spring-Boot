package com.learning.RestAPIs.service.implematation;

import com.learning.RestAPIs.DTO.AddStudentRequestDto;
import com.learning.RestAPIs.DTO.StudentDTO;
import com.learning.RestAPIs.entity.StudentEntity;
import com.learning.RestAPIs.resp.StudentRepo;
import com.learning.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServicesImpl implements StudentService {

    private final StudentRepo studentRepo;  // ✅ Correct dependency
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDTO> getAllStudents() {

        List<StudentEntity> students = studentRepo.findAll(); // ✅ DB call

        return students.stream()
                .map(student -> modelMapper
                        .map(student, StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO getStudenById(Long id) {
        StudentEntity studentEntity =
                studentRepo.findById(id).
                        orElseThrow(() ->
                                new IllegalArgumentException
                                        ("Student not fund by this id" + id));
        StudentDTO studentDTO = modelMapper
                .map(studentEntity, StudentDTO.class);
        return studentDTO;
    }

    @Override
    public StudentDTO createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        StudentEntity newStudentEntity = modelMapper
                .map(addStudentRequestDto, StudentEntity.class);
        StudentEntity student = studentRepo.save(newStudentEntity);


        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public void deleteStudentById(Long id) {
     if(!studentRepo.existsById(id)){
         throw new IllegalArgumentException("Student is not Exist with this id");
     }
    studentRepo.deleteById(id);
    }

    @Override
    public StudentDTO
    updateStudentByID(Long id, AddStudentRequestDto addStudentRequestDto) {
        StudentEntity student=studentRepo.findById(id).
                orElseThrow(() ->
                        new IllegalArgumentException
                                ("Student not fund by this id" + id));
        modelMapper.map(addStudentRequestDto,student);
        student=studentRepo.save(student);
        System.out.print("Student Updated:"+student);
        return modelMapper.map(student,StudentDTO.class);
    }


}
