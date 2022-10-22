package io.davidabejirin.assessment.repository;

import io.davidabejirin.assessment.models.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SchoolClassRepository  extends JpaRepository<Clazz, Long> {
    @Query("SELECT s FROM Clazz s WHERE s.name = ?1")
    Optional<Clazz> findByName(String name);


}
