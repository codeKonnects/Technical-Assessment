package io.davidabejirin.assessment.service;

import io.davidabejirin.assessment.dto.AddScoreDTO;
import io.davidabejirin.assessment.exception.ResourceNotFoundException;
import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.repository.SchoolClassRepository;
import io.davidabejirin.assessment.repository.StudentRepository;
import io.davidabejirin.assessment.repository.SubjectRepository;
import io.davidabejirin.assessment.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl {

    private final SubjectRepository subjectRepository;
    private  final StudentRepository studentRepository;
    private  final SchoolClassRepository schoolClassRepository;

    public ApiResponse<String> addScore(Long studentId, AddScoreDTO addScoreDTO){
        Student student = findStudentById(studentId);

    }


    public Student findStudentById(Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

}
