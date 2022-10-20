package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolClassRepository  extends JpaRepository<SchoolClass, Long> {
    Optional<SchoolClass> findSchoolClassByName(String name);
}
