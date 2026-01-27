package io.app.service.impl;

import io.app.dto.ApiResponse;
import io.app.exception.DuplicateFoundException;
import io.app.exception.RequiredFieldException;
import io.app.exception.ResouceNotFoundException;
import io.app.modal.Company;
import io.app.repository.CompanyRepository;
import io.app.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository){
        this.repository=repository;
    }


    @Override
    public ApiResponse create(Company company) {
        if (company.getName() == null || company.getName().trim().isEmpty()) {
            throw new RequiredFieldException("Company Name is Required");
        }

        if (company.getMinSize() == 0) {
            throw new RequiredFieldException("Minimum Company Size is Required");
        }

        if (company.getMaxSize() == 0) {
            throw new RequiredFieldException("Maximum Company Size is Required");
        }

        if (repository.existsByName(company.getName())){
            throw new DuplicateFoundException("Company Already Exist!");
        }

        repository.save(company);

        return new ApiResponse("Company Created Successfully",true);
    }


    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> company=repository.findById(id);

        if (!company.isPresent()){
            throw new ResouceNotFoundException("Company Not Found");
        }

        return company.get();
    }

    @Override
    public ApiResponse isCompanyExist(Long id) {
        boolean isCompanyExist=repository.existsById(id);
        return new ApiResponse("",isCompanyExist);
    }
}
