package io.app.service.impl;

import io.app.client.CompanyClient;
import io.app.dto.ApiResponse;
import io.app.exception.ResourceNotFoundException;
import io.app.model.Review;
import io.app.model.ReviewType;
import io.app.repository.ReviewRepository;
import io.app.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final CompanyClient companyClient;

    public ReviewServiceImpl(ReviewRepository repository,CompanyClient companyClient){
        this.repository=repository;
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

        }

        repository.save(review);

        return new ApiResponse("Review Created Successfully",true);
    }

    @Override
    public Page<Review> getReviewsByCompanyId(long companyId, long pageNo, long size) {
        return null;
    }

    @Override
    public Page<Review> getReviewsByJobId(long jobId, long pageNo, long size) {
        return null;
    }
}
