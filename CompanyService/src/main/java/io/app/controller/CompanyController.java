package io.app.controller;

import io.app.dto.ApiResponse;
import io.app.modal.Company;
import io.app.service.CompanyService;
import io.app.service.impl.CompanyServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyServiceImpl service;

    public CompanyController(CompanyServiceImpl service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(service.create(company), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        return ResponseEntity.ok(service.getCompanyById(id));
    }

    @GetMapping("/check/{id}")
    public ResponseEntity<ApiResponse> checkCompanyExist(@PathVariable Long id){
        return ResponseEntity.ok(service.isCompanyExist(id));
    }

}
