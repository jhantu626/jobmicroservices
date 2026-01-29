package io.app.model;

import io.app.exception.RequiredFieldException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long jobId;
    private long companyId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    private void preCreate(){
        if (rating<0 || rating>5){
            throw new RequiredFieldException("Rating should between 0 to 5");
        }
        this.createdAt=LocalDateTime.now();
        this.updatedAt= LocalDateTime.now();
    }

}
