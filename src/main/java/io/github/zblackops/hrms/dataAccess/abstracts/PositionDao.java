package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<JobPosition, Integer> {

    boolean existsByName(String name);
}
