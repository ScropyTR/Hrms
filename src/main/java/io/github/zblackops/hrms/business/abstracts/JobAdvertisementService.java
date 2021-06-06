package io.github.zblackops.hrms.business.abstracts;


import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.Employer;
import io.github.zblackops.hrms.entities.concretes.JobAdvertisement;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisement jobAdvertisement);

    Result close(int id);

    DataResult<List<JobAdvertisement>> getByIsActiveTrue();

    DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateDesc();

    DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer(Employer employer);

}
