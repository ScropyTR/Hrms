package io.github.zblackops.hrms.business.concretes;

import io.github.zblackops.hrms.business.abstracts.PositionService;
import io.github.zblackops.hrms.business.constants.Messages;
import io.github.zblackops.hrms.core.utilities.results.*;
import io.github.zblackops.hrms.dataAccess.abstracts.PositionDao;
import io.github.zblackops.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionManager implements PositionService {

    PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>>(positionDao.findAll(), Messages.jobPositionsListed);
    }

    @Override
    public Result add(Position position) {
        if(positionDao.existsByName(position.getName())) return new ErrorResult(Messages.positionAlreadyExists);
        positionDao.save(position);
        return new SuccessResult(Messages.successfullyAddedJobPosition);
    }
}
