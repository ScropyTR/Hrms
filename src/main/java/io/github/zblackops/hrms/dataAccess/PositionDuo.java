package io.github.zblackops.hrms.dataAccess;

import io.github.zblackops.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDuo extends JpaRepository<Position, Integer> {
}
