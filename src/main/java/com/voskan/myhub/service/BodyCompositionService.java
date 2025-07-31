package com.voskan.myhub.service;

import com.voskan.myhub.dto.BodyCompositionDTO;

import java.util.List;
import java.util.UUID;

public interface BodyCompositionService {
    List<BodyCompositionDTO> getByUserId(UUID userId);
    BodyCompositionDTO getById(Long id);
    BodyCompositionDTO create(BodyCompositionDTO dto);
    BodyCompositionDTO update(Long id, BodyCompositionDTO dto);
    void delete(Long id);
}