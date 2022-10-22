package io.davidabejirin.assessment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.davidabejirin.assessment.utils.Term;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddScoreDTO implements Serializable {
    private Long subjectId;
    private String term;
    private Long classId;
    private int score;
}
