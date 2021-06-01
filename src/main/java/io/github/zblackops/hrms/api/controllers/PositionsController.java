package io.github.zblackops.hrms.api.controllers;

import io.github.zblackops.hrms.business.abstracts.PositionService;
import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {

    PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getall")
    public DataResult<List<Position>> getAll(){
        return positionService.getAll();
    }

    @PostMapping
    public Result add(@RequestBody Position position){
        return positionService.add(position);
    }
}
