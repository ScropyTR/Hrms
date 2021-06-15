package io.github.zblackops.hrms.core.adapters.abstracts;

import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.JobSeeker;

import java.util.Date;

public interface VerificationService {

    Boolean isVerificationValid(JobSeeker jobSeeker);
}
