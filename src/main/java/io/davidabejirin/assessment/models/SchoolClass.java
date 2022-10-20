package io.davidabejirin.assessment.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "school_id" , referencedColumnName = "id")
    @JsonManagedReference
    private School school;

    @OneToOne(mappedBy = "schoolClass", cascade = CascadeType.MERGE)
    @JsonManagedReference
    private Student students;

    @OneToMany(mappedBy = "schoolClass")
    @JsonBackReference
    private List<Subject> subjects;
    public SchoolClass(String name) {
        this.name = name;
    }
}
