package io.app.service.impl;

import io.app.client.CompanyClient;
import io.app.dto.ApiResponse;
import io.app.exception.RequiredFieldException;
import io.app.exception.ResourceNotFoundException;
import io.app.model.Job;
import io.app.repository.JobRepository;
import io.app.service.JobService;
import org.hibernate.ResourceClosedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository repository;
    private final CompanyClient companyClient;

    public JobServiceImpl(JobRepository repository,CompanyClient companyClient){
        this.repository=repository;
        this.companyClient=companyClient;
    }


    @Override
    public ApiResponse createJob(Job job) {
        if (job.getCompanyId()==0){
            throw new RequiredFieldException("Please Provide Company");
        }
        ApiResponse apiResponse=companyClient.companyExist(job.getCompanyId());
        if (!apiResponse.status()){
            throw new ResourceNotFoundException("Company Does not exist");
        }
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
