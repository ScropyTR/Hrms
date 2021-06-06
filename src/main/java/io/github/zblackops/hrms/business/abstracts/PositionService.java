package io.github.zblackops.hrms.business.abstracts;

import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.JobPosition;

import java.util.List;

public interface PositionService {

    DataResult<List<JobPosition>> getAll();
    Result add(JobPosition jobPosition);
}
