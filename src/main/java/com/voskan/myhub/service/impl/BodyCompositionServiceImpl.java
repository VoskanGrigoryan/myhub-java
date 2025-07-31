package com.voskan.myhub.service.impl;

import com.voskan.myhub.dto.BodyCompositionDTO;
import com.voskan.myhub.entity.BodyComposition;
import com.voskan.myhub.exception.ResourceNotFoundException;
import com.voskan.myhub.repository.BodyCompositionRepository;
import com.voskan.myhub.service.BodyCompositionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BodyCompositionServiceImpl implements BodyCompositionService {

    private final BodyCompositionRepository repository;

    public BodyCompositionServiceImpl(BodyCompositionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BodyCompositionDTO> getByUserId(UUID userId) {
        return repository.findByUserId(userId)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public BodyCompositionDTO getById(Long id) {
        BodyComposition body = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return toDTO(body);
    }

    @Override
    public BodyCompositionDTO create(BodyCompositionDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    @Override
    public BodyCompositionDTO update(Long id, BodyCompositionDTO dto) {
        BodyComposition existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        existing.setMonth(dto.getMonth());
        existing.setBodyWeight(dto.getBodyWeight());
        existing.setBodyFatPercentage(dto.getBodyFatPercentage());
        existing.setBodyMusclePercentage(dto.getBodyMusclePercentage());
        existing.setBodySkinPercentage(dto.getBodySkinPercentage());
        existing.setBodyBonePercentage(dto.getBodyBonePercentage());
        existing.setBodyOtherPercentage(dto.getBodyOtherPercentage());
        return toDTO(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private BodyCompositionDTO toDTO(BodyComposition e) {
        return BodyCompositionDTO.builder()
                .id(e.getId())
                .month(e.getMonth())
                .bodyWeight(e.getBodyWeight())
                .bodyFatPercentage(e.getBodyFatPercentage())
                .bodyMusclePercentage(e.getBodyMusclePercentage())
                .bodySkinPercentage(e.getBodySkinPercentage())
                .bodyBonePercentage(e.getBodyBonePercentage())
                .bodyOtherPercentage(e.getBodyOtherPercentage())
                .userId(e.getUserId())
                .build();
    }

    private BodyComposition toEntity(BodyCompositionDTO d) {
        return BodyComposition.builder()
                .month(d.getMonth())
                .bodyWeight(d.getBodyWeight())
                .bodyFatPercentage(d.getBodyFatPercentage())
                .bodyMusclePercentage(d.getBodyMusclePercentage())
                .bodySkinPercentage(d.getBodySkinPercentage())
                .bodyBonePercentage(d.getBodyBonePercentage())
                .bodyOtherPercentage(d.getBodyOtherPercentage())
                .userId(d.getUserId())
                .build();
    }
}
