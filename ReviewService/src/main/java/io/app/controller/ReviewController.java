package io.app.controller;

import io.app.dto.ApiResponse;
import io.app.model.Review;
import io.app.service.impl.ReviewServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
