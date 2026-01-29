package io.app.model;

import io.app.exception.RequiredFieldException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;

import java.time.LocalDate;
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
    private long id;
    private double rating;
    private String description;
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;
    private long jobId;
    private long companyId;
    private long likeCount;
    private long dislikeCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void preCreate(){
        if (description==null){
            throw new RequiredFieldException("Description Required");
        }else if (rating<0 || rating>5){
            throw new RequiredFieldException("Rating should between 0 to 5");
        }else if (companyId==0 && jobId==0){
            throw new RequiredFieldException("Company or Job Id is required");
        }


        this.likeCount=0;
        this.dislikeCount=0;
        this.createdAt=LocalDateTime.now();
        this.updatedAt= LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedAt=LocalDateTime.now();
    }

}
