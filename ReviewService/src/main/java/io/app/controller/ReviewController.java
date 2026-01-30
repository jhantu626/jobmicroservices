package io.app.controller;

import io.app.dto.ApiResponse;
import io.app.model.Review;
import io.app.service.impl.ReviewServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewServiceImpl service;

    public ReviewController(ReviewServiceImpl service){
        this.service=service;
    }

    @PostMapping
    public ApiResponse createReview(@RequestBody Review review){
        return service.createReview(review);
    }


    @GetMapping("/company")
    public Page<Review> reviewsByCompanyId(@RequestParam("company") Long companyId,
                                           @RequestParam(required = false, value = "page",defaultValue = "0") int page,
                                           @RequestParam(required = false, value = "size",defaultValue = "10") int size){
        return service.getReviewsByCompanyId(companyId,page,size);
    }

    @GetMapping("/job")
    public Page<Review> reviewsByJobId(@RequestParam("job") Long jobId,
                                       @RequestParam(required = false,value = "page",defaultValue = "0") int pageNo,
                                       @RequestParam(required = false,value = "size",defaultValue = "10") int size){
        return service.getReviewsByJobId(jobId,pageNo,size);
    }


}
