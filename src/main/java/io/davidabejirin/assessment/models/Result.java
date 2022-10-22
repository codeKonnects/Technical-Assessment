package io.davidabejirin.assessment.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.davidabejirin.assessment.utils.Term;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    @Enumerated(EnumType.STRING)
    private Term term;
    @ManyToOne
    @JsonIgnore
    private Subject subject;
    @ManyToOne
    @JsonIgnore
    private Clazz clazz;
    @Min(0 )
    @Max(100)
    private double score;
}
