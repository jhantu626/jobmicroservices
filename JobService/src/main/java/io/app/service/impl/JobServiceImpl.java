package io.app.service.impl;

import io.app.dto.ApiResponse;
import io.app.model.Job;
import io.app.repository.JobRepository;
import io.app.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository repository;

    public JobServiceImpl(JobRepository repository){
        this.repository=repository;
    }


    @Override
    public ApiResponse createJob(Job job) {
        repository.save(job);


        return new ApiResponse("Job Created Successfully",true);
    }

    @Override
    public Page<Job> jobsByCompanyId(long companyId, int pageNo, int pageSize) {
        Pageable pageable=PageRequest.of(pageNo,pageSize);
        Page<Job> jobs=repository.findByCompanyId(companyId,pageable);

        return jobs;
    }
}
