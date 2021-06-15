package io.github.zblackops.hrms.business.concretes;

import io.github.zblackops.hrms.business.abstracts.PositionService;
import io.github.zblackops.hrms.business.constants.Messages;
import io.github.zblackops.hrms.core.utilities.results.*;
import io.github.zblackops.hrms.dataAccess.abstracts.PositionDao;
import io.github.zblackops.hrms.entities.concretes.JobAdvertisement;
import io.github.zblackops.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManager implements PositionService {

    PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(positionDao.findAll(), Messages.listedJobPositions);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        if(positionDao.existsByName(jobPosition.getName())) return new ErrorResult(Messages.positionAlreadyExists);
        positionDao.save(jobPosition);
        return new SuccessResult(Messages.successfullyAddedJobPosition);
    }
}
