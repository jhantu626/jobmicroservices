package io.app.service.impl;

import io.app.dto.ApiResponse;
import io.app.model.Review;
import io.app.repository.ReviewRepository;
import io.app.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;

    public ReviewServiceImpl(ReviewRepository repository){
        this.repository=repository;
    }

    @Override
    public ApiResponse createReview(Review review) {

        return null;
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
