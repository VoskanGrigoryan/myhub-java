package com.voskan.myhub.dto;

import lombok.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyCompositionDTO {
    private Long id;
    private LocalDate month;
    private Double bodyWeight;
    private Double bodyFatPercentage;
    private Double bodyMusclePercentage;
    private Double bodySkinPercentage;
    private Double bodyBonePercentage;
    private Double bodyOtherPercentage;
    private UUID userId;

    private LocalDate createdAt;
    private LocalDate updatedAt;
}
