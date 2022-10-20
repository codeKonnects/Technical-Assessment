package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolClassRepository  extends JpaRepository<SchoolClass, Long> {

}
