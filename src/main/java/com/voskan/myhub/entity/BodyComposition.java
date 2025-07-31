package com.voskan.myhub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "body_composition")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyComposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate month;

    private Double  bodyWeight;
    private Double  bodyFatPercentage;
    private Double  bodyMusclePercentage;
    private Double  bodySkinPercentage;
    private Double  bodyBonePercentage;
    private Double  bodyOtherPercentage;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    private LocalDate createdAt;
    private LocalDate updatedAt;
}
