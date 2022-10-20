package io.davidabejirin.assessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private School school;

    @OneToOne(mappedBy = "schoolClass", cascade = CascadeType.MERGE)
    private Student students;

    @OneToMany(mappedBy = "schoolClass")
    private List<Subject> schoolClasses;

    public SchoolClass(String name, School school) {
        this.name = name;
        this.school = school;
    }

    public SchoolClass(String name) {
        this.name = name;
    }
}
