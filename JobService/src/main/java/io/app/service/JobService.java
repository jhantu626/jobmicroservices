package io.app.service;

import io.app.dto.ApiResponse;
import io.app.model.Job;
import org.springframework.data.domain.Page;

import java.util.List;

public interface JobService {
    public ApiResponse createJob(Job job);
    public Page<Job> jobsByCompanyId(long companyId, int page, int size);
}
