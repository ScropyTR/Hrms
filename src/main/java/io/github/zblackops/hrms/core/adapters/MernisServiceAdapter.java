package io.github.zblackops.hrms.core.adapters;

import io.github.zblackops.hrms.business.abstracts.VerificationService;
import io.github.zblackops.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service("Mernis")
public class MernisServiceAdapter implements VerificationService {

    @Override
    public Boolean isVerificationValid(JobSeeker jobSeeker) {
        return true;
    }
}
