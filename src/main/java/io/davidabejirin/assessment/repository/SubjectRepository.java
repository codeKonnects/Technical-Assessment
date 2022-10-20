package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.Student;
import io.davidabejirin.assessment.models.Subject;
import io.davidabejirin.assessment.utils.Term;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository  extends JpaRepository<Subject, Long> {
    Optional<Subject> findByStudentAndNameAndSchoolClassNameAndTerm(Student studentID, String name, String schoolClass, Term term);

    List<Subject> findAllByStudentIdAndTerm(Long studentId , Term term);
}
