package io.davidabejirin.assessment.service.impl;

import io.davidabejirin.assessment.dto.AddScoreDTO;
import io.davidabejirin.assessment.exception.ResourceNotFoundException;
import io.davidabejirin.assessment.models.SchoolClass;
import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.models.Subject;
import io.davidabejirin.assessment.repository.SchoolClassRepository;
import io.davidabejirin.assessment.repository.StudentRepository;
import io.davidabejirin.assessment.repository.SubjectRepository;
import io.davidabejirin.assessment.service.ScoreService;
import io.davidabejirin.assessment.utils.ApiResponse;
import io.davidabejirin.assessment.utils.StudentUtil;
import io.davidabejirin.assessment.utils.Term;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.CREATED;

@Service
@RequiredArgsConstructor
@Data
@Builder
public class ScoreServiceImpl implements ScoreService {

    private final StudentUtil studentUtil;
    private final SubjectRepository subjectRepository;
    private  final StudentRepository studentRepository;
    private  final SchoolClassRepository schoolClassRepository;

    public ApiResponse<Subject> addScore(Long studentId, AddScoreDTO addScoreDTO){
        Student student = studentUtil.findStudentById(studentId);
        SchoolClass schoolClass = studentUtil.findClassByName(addScoreDTO.getSchoolClass());
        Subject subject = Subject.builder()
                .name(addScoreDTO.getSubjectName())
                .term(Term.valueOf(addScoreDTO.getTerm()))
                .score(addScoreDTO.getScore())
                .schoolClass(schoolClass)
                .student(student)
                .build();
        subject = subjectRepository.save(subject);
        return new ApiResponse<>(CREATED, "Score added successfully" , subject);
    }


}
