package io.github.zblackops.hrms.business.abstracts;

import com.zaxxer.hikari.metrics.PoolStats;
import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.JobSeeker;
import io.github.zblackops.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {

    DataResult<List<Position>> getAll();
    Result add(Position position);
}
