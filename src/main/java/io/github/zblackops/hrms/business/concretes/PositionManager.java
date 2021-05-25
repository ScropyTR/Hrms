package io.github.zblackops.hrms.business.concretes;

import io.github.zblackops.hrms.business.abstracts.PositionService;
import io.github.zblackops.hrms.dataAccess.PositionDuo;
import io.github.zblackops.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionManager implements PositionService {

    PositionDuo positionDuo;

    @Autowired
    public PositionManager(PositionDuo positionDuo) {
        this.positionDuo = positionDuo;
    }

    @Override
    public List<Position> getAll() {
        return positionDuo.findAll();
    }
}
