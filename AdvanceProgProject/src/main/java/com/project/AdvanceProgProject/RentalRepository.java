package com.project.AdvanceProgProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RentalRepository extends JpaRepository<RentalEntity,Long> {
}
