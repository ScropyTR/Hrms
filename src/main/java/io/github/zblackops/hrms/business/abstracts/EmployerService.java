package io.github.zblackops.hrms.business.abstracts;

import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

    DataResult<List<Employer>> getAll();
    Result add(Employer employer);

}
