package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {


}
