package io.app.model;

import io.app.exception.RequiredFieldException;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double rating;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    @Column(nullable = true)
    private Long jobId;
    @Column(nullable = true)
    private Long companyId;
    private Long likeCount;
    private Long dislikeCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void preCreate(){
        if (description==null){
            throw new RequiredFieldException("Description Required");
        }else if (rating<0 || rating>5){
            throw new RequiredFieldException("Rating should between 0 to 5");
        }else if (reviewType==ReviewType.REVIEW && companyId==null){
            throw new RequiredFieldException("Company Id is required");
        }else if (reviewType==ReviewType.JOB && companyId==null){
            throw new RequiredFieldException("Job Id is required");
        }


        this.likeCount=new Long(0);
        this.dislikeCount=new Long(0);
        this.createdAt=LocalDateTime.now();
        this.updatedAt= LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt=LocalDateTime.now();
    }

}
