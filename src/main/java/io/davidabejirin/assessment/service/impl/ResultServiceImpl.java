package io.davidabejirin.assessment.service.impl;

import io.davidabejirin.assessment.exception.ResourceNotFoundException;
import io.davidabejirin.assessment.models.SchoolClass;
import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.models.Subject;
import io.davidabejirin.assessment.repository.SubjectRepository;
import io.davidabejirin.assessment.service.ResultService;
import io.davidabejirin.assessment.utils.ApiResponse;
import io.davidabejirin.assessment.utils.StudentUtil;
import io.davidabejirin.assessment.utils.Term;
import io.davidabejirin.assessment.utils.TermlyResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {

    private final SubjectRepository subjectRepository;
    private final StudentUtil studentUtil;
    @Override
    public ApiResponse<Object> getStudentResult(Long studentID, String name, String schoolClass, String term) {
        Student student = studentUtil.findStudentById(studentID);
        SchoolClass className = studentUtil.findClassByName(schoolClass);
        Subject subject = subjectRepository
                .findByStudentAndNameAndSchoolClassNameAndTerm(student, name , className.getName() , Term.valueOf(term))
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        return ApiResponse.builder()
                .status(OK)
                .message("Result retrieved successfully")
                .data(subject)
                .build();
    }
    @Override
    public ApiResponse<Object> getStudentTermlyResult(Long studentId , Term term) {
        Student student = studentUtil.findStudentById(studentId);
        List<Subject> subjects = subjectRepository.findAllByStudentIdAndTerm(student.getId() , term);
        Map<String, Double> result = subjects.stream()
                .collect(
                        Collectors.groupingBy(
                                Subject::getName,
                                Collectors.averagingDouble(Subject::getScore)
                        )
                );

        OptionalDouble average = subjects
                .stream()
                .mapToInt(Subject::getScore)
                .average();
         TermlyResult termlyResult = new TermlyResult(average, result);
        return ApiResponse.builder()
                .status(OK)
                .message("Result retrieved successfully")
                .data(termlyResult)
                .build();
    }
}
