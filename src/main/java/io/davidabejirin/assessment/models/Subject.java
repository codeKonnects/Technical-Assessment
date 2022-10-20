package io.davidabejirin.assessment.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.davidabejirin.assessment.utils.Term;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Term term;

    @Max(value = 100, message = "Score cannot be greater than 100")
    @Min(value = 0, message = "Score cannot be less than 0")
    private int score;
    @ManyToOne
    @JsonBackReference
    private SchoolClass schoolClass;

    @ManyToOne
    @JsonManagedReference
    private Student student;
}
