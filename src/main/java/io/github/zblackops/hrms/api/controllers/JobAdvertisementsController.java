package io.github.zblackops.hrms.api.controllers;

import io.github.zblackops.hrms.business.abstracts.JobAdvertisementService;
import io.github.zblackops.hrms.core.utilities.results.DataResult;
import io.github.zblackops.hrms.core.utilities.results.Result;
import io.github.zblackops.hrms.entities.concretes.Employer;
import io.github.zblackops.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/close")
    public Result close(@RequestParam int id){
        return this.jobAdvertisementService.close(id);
    }

    @GetMapping("/getByIsActiveTrue")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrue(){
        return this.jobAdvertisementService.getByIsActiveTrue();
    }

    @GetMapping("/getByIsActiveTrueOrderByReleaseDateDesc")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByReleaseDateDesc(){
        return this.jobAdvertisementService.getByIsActiveTrueOrderByReleaseDateDesc();
    }

    @GetMapping("/getByIsActiveTrueAndEmployer")
    public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer(@RequestParam Employer employer){
        return this.jobAdvertisementService.getByIsActiveTrueAndEmployer(employer);
    }

}
