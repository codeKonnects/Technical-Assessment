package io.davidabejirin.assessment.utils;

import io.davidabejirin.assessment.dto.SchoolClassDTO;
import io.davidabejirin.assessment.exception.ResourceNotFoundException;
import io.davidabejirin.assessment.models.Clazz;
import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.repository.SchoolClassRepository;
import io.davidabejirin.assessment.repository.StudentRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Data
@Service
public class StudentUtil {
    private  final StudentRepository studentRepository;
    private final SchoolClassRepository schoolClassRepository;

    public Student findStudentById(Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }
    public SchoolClassDTO findClassDTOByName(String schoolClass) {
        return new SchoolClassDTO(schoolClassRepository.findByName(schoolClass)
                .orElseThrow(() -> new ResourceNotFoundException("Class not found")));
    }
}
