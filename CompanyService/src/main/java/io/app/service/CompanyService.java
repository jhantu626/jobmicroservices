package io.app.service;

import io.app.dto.ApiResponse;
import io.app.modal.Company;

public interface CompanyService {
    public ApiResponse create(Company company);
    public Company getCompanyById(Long id);
    public ApiResponse isCompanyExist(Long id);
}
