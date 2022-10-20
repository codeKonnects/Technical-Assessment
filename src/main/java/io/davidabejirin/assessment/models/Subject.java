package io.davidabejirin.assessment.models;

import io.davidabejirin.assessment.utils.Term;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Term term;
    private int score;
    @ManyToOne
    private SchoolClass schoolClass;

    @ManyToOne
    private Student student;
}
