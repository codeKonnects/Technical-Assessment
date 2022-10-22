package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.Result;
import io.davidabejirin.assessment.utils.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    Optional<Result> findByStudentIdAndSubjectIdAndClazzNameAndTerm(Long student_id, Long subject_id, String clazz_name, Term term);
    List<Result> findAllByStudentIdAndTerm(Long student_id, Term term);

}
