package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
