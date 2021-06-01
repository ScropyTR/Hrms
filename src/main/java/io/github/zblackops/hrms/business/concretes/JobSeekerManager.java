package io.github.zblackops.hrms.business.concretes;

import io.github.zblackops.hrms.business.abstracts.JobSeekerService;
import io.github.zblackops.hrms.business.abstracts.VerificationService;
import io.github.zblackops.hrms.business.constants.Messages;
import io.github.zblackops.hrms.core.utilities.email.abstracts.EmailService;
import io.github.zblackops.hrms.core.utilities.results.*;
import io.github.zblackops.hrms.dataAccess.abstracts.JobSeekerDao;
import io.github.zblackops.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    JobSeekerDao jobSeekerDao;
    VerificationService verificationService;
    EmailService emailService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationService verificationService, EmailService emailService) {
        this.jobSeekerDao = jobSeekerDao;
        this.verificationService = verificationService;
        this.emailService=emailService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "İşarayanlar listelendi");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (isFieldsEmpty(
                jobSeeker.getFirstName(),
                jobSeeker.getLastName(),
                jobSeeker.getEmail(),
                jobSeeker.getPassword(),
                jobSeeker.getNationalityId(),
                String.valueOf(jobSeeker.getDateOfBirth())
        )) return new ErrorResult(Messages.allFieldsAreRequired);

        if (jobSeekerDao.existsByNationalityId(jobSeeker.getNationalityId()))
            return new ErrorResult(Messages.nationalityIdAlreadyExists);
        if (jobSeekerDao.existsByEmail(jobSeeker.getEmail())) return new ErrorResult(Messages.eMailAlreadyExists);
        if (!verificationService.isVerificationValid(jobSeeker)) return new ErrorResult(Messages.verificationIsInvalid);
        emailService.sendVerificationMail(jobSeeker.getEmail());
        if (!emailService.theLinkIsClicked()) return new ErrorResult(Messages.verificationNotConfirmed);
        jobSeekerDao.save(jobSeeker);
        return new SuccessResult(Messages.successfullyAddedJobSeeker);

    }

    public boolean isFieldsEmpty(String... fields) {
        for (String field : fields) {
            if (field.isEmpty() || field == null) {
                return field.isEmpty();
            }
        }
        return false;
    }

}