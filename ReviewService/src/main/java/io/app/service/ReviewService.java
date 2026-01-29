package io.app.service;

import io.app.dto.ApiResponse;
import io.app.model.Review;
import org.springframework.data.domain.Page;

public interface ReviewService {
    public ApiResponse createReview(Review review);
    public Page<Review> getReviewsByCompanyId(long companyId,long pageNo,long size);
    public Page<Review> getReviewsByJobId(long jobId,long pageNo,long size);
}
