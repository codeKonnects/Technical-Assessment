package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {

}
