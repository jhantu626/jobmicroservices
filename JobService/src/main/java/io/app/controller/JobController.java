package io.app.controller;

import io.app.dto.ApiResponse;
import io.app.model.Job;
import io.app.service.impl.JobServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    private final JobServiceImpl service;

    public JobController(JobServiceImpl service){
        this.service=service;
    }

    @PostMapping
    public ApiResponse createJob(@RequestBody Job job){
        return service.createJob(job);
    }

    @GetMapping
    public Page<Job> getJobs(@RequestParam("company") long  companyId,
                             @RequestParam(required = false,defaultValue = "10") int size,
                             @RequestParam(required = false,defaultValue = "0") int pageNo){
        return service.jobsByCompanyId(companyId,pageNo,size);
    }


}
