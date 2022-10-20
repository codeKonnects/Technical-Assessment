package io.davidabejirin.assessment.service;

import io.davidabejirin.assessment.dto.AddScoreDTO;
import io.davidabejirin.assessment.models.Subject;
import io.davidabejirin.assessment.utils.ApiResponse;

public interface ScoreService {
     ApiResponse<Subject> addScore(Long studentId, AddScoreDTO addScoreDTO);
}
