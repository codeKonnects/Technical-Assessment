package io.davidabejirin.assessment.service.impl;

import io.davidabejirin.assessment.dto.SchoolClassDTO;
import io.davidabejirin.assessment.exception.ResourceNotFoundException;
import io.davidabejirin.assessment.models.Result;
import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.models.Subject;
import io.davidabejirin.assessment.repository.ResultRepository;
import io.davidabejirin.assessment.repository.SubjectRepository;
import io.davidabejirin.assessment.service.ResultService;
import io.davidabejirin.assessment.utils.ApiResponse;
import io.davidabejirin.assessment.utils.StudentUtil;
import io.davidabejirin.assessment.utils.Term;
import io.davidabejirin.assessment.utils.TermlyResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResultServiceImpl implements ResultService {

    private final SubjectRepository subjectRepository;
    private final StudentUtil studentUtil;

    private final ResultRepository resultRepository;

    @Override
    public ApiResponse<Object> getStudentResult(Long studentID, Long id, String schoolClass, String term) {
        SchoolClassDTO schoolClassDTO = studentUtil.findClassDTOByName(schoolClass);
        Result result = resultRepository
                .findByStudentIdAndSubjectIdAndClazzNameAndTerm(studentID, id , schoolClassDTO.getName(), Term.valueOf(term))
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        System.out.println("SUBJECT" + result);

        return ApiResponse.builder()
                .status(HttpStatus.ACCEPTED)
                .message("Result retrieved successfully")
                .data(result)
                .build();
    }
    @Override
    public ApiResponse<Object> getStudentTermlyResult(Long studentId , Term term) {

        List<Result> results = resultRepository.findAllByStudentIdAndTerm(studentId , term);
        Double average = results.stream()
                .mapToDouble(Result::getScore)
                .average().orElseGet(() -> 0.0);

        Map<String, Double> score = results.stream()
                .collect(
                        Collectors.groupingBy(
                                result -> result.getSubject().getName(),
                                Collectors.averagingDouble(Result::getScore)
                        )
                );

         TermlyResult termlyResult = new TermlyResult(average, score);
        return ApiResponse.builder()
                .status(HttpStatus.ACCEPTED)
                .message("Result retrieved successfully")
                .data(termlyResult)
                .build();
    }
}
