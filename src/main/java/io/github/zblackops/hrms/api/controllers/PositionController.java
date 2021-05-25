package io.github.zblackops.hrms.api.controllers;

import io.github.zblackops.hrms.business.abstracts.PositionService;
import io.github.zblackops.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/getall")
    public List<Position> getAll(){
        return positionService.getAll();
    }

}
