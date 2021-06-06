package io.github.zblackops.hrms.api.controllers;

import io.github.zblackops.hrms.business.abstracts.PositionService;
import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {

    PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return positionService.getAll();
    }

    @PostMapping
    public Result add(@RequestBody JobPosition jobPosition){
        return positionService.add(jobPosition);
    }
}
