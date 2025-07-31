package com.voskan.myhub.repository;
import com.voskan.myhub.entity.BodyComposition;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BodyCompositionRepository extends JpaRepository<BodyComposition, Long> {
    List<BodyComposition> findByUserId(UUID userId);
}