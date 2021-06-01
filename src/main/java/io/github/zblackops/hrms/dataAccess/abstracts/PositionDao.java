package io.github.zblackops.hrms.dataAccess.abstracts;

import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionDao extends JpaRepository<Position, Integer> {

    boolean existsByName(String name);
}
