package io.davidabejirin.assessment.dto;

import io.davidabejirin.assessment.utils.Term;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddScoreDTO {
    private String subjectName;
    private String term;
    private String schoolClass;
    private int score;
}
