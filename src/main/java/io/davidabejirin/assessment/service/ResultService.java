package io.davidabejirin.assessment.service;

import io.davidabejirin.assessment.utils.ApiResponse;
import io.davidabejirin.assessment.utils.Term;

public interface ResultService {
    ApiResponse<Object> getStudentResult(Long studentID, Long Id, String schoolClass, String term);
    ApiResponse<Object> getStudentTermlyResult(Long studentId , Term term);
}
