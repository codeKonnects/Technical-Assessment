package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository  extends JpaRepository<Subject, Long> {

}
