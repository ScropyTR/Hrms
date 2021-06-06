package io.github.zblackops.hrms.business.concretes;

import io.github.zblackops.hrms.business.abstracts.JobAdvertisementService;
import io.github.zblackops.hrms.business.constants.Messages;
import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.core.utilities.results.SuccessDataResult;
import io.github.zblackops.hrms.core.utilities.results.SuccessResult;
import io.github.zblackops.hrms.dataAccess.abstracts.JobAdvertisementDao;
import io.github.zblackops.hrms.entities.concretes.Employer;
import io.github.zblackops.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.successfullyAddedJobAdvertisement);
    }

    @Override
    public Result close(int id) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findByJobAdvertisementId(id);
        jobAdvertisement.setActive(false);
        return new SuccessResult(Messages.closedJobAdvertisement);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueOrderByReleaseDateDesc(), Messages.listedJobAdvertisementsByDate);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer(Employer employer) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActiveTrueAndEmployer(employer), Messages.listedJobAdvertisementsByEmployer);
    }
}
