package io.app.service;

import io.app.dto.ApiResponse;
import io.app.model.Job;

import java.util.List;

public interface JobService {
    public ApiResponse createJob(Job job);
    public List<Job> jobsByCompanyId(long companyId);
}
