package io.github.zblackops.hrms.business.abstracts;

import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);

}
