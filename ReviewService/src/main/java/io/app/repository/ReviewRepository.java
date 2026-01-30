package io.app.repository;

import io.app.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    public Page<Review> getReviewByCompanyId(Long companyId, Pageable pageable);
    public Page<Review> getReviewByJobId(Long jobId, Pageable pageable);
}
