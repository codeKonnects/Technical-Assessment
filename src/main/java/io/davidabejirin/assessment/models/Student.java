package io.davidabejirin.assessment.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "student")
    private List<Subject> subject;
    @OneToOne(cascade = CascadeType.MERGE)
    private SchoolClass schoolClass;
}
