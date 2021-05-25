package io.github.zblackops.hrms.business.abstracts;

import io.github.zblackops.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {

    List<Position> getAll();

}
