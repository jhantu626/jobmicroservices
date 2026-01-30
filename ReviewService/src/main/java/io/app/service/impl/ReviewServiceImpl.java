package io.app.service.impl;

import io.app.client.CompanyClient;
import io.app.client.JobClient;
import io.app.dto.ApiResponse;
import io.app.exception.ResourceNotFoundException;
import io.app.model.Review;
import io.app.model.ReviewType;
import io.app.repository.ReviewRepository;
import io.app.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final CompanyClient companyClient;
    private final JobClient jobClient;

    public ReviewServiceImpl(ReviewRepository repository,CompanyClient companyClient,JobClient jobClient){
        this.repository=repository;
        this.jobClient=jobClient;
        this.companyClient=companyClient;
    }

    @Override
    public ApiResponse createReview(Review review) {

        if (review.getReviewType()== ReviewType.REVIEW){
            ApiResponse apiResponse=companyClient.companyExist(review.getCompanyId());
            if (!apiResponse.status()){
                throw new ResourceNotFoundException("Company Not Found");
            }
        } else {
            ApiResponse apiResponse=jobClient.checkJobExist(review.getJobId());
            if (!apiResponse.status()){
                throw new ResourceNotFoundException("Job Not Found");
            }
        }

        repository.save(review);

        return new ApiResponse("Review Created Successfully",true);
    }

    @Override
    public Page<Review> getReviewsByCompanyId(long companyId, int pageNo, int size) {
        Pageable pageable=PageRequest.of(pageNo,size);
        Page<Review> reviews=repository.findReviewByCompanyId(companyId,pageable);
        return reviews;
    }

    @Override
    public Page<Review> getReviewsByJobId(long jobId, int pageNo, int size) {
        Pageable pageable=PageRequest.of(pageNo,size);
        Page<Review> reviews=repository.findReviewByJobId(jobId);
        return reviews;
    }
}
