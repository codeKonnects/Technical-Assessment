package io.davidabejirin.assessment.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JsonBackReference
    private List<Subject> subject;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Clazz clazz;
}
