package com.voskan.myhub.controller;

import com.voskan.myhub.dto.BodyCompositionDTO;
import com.voskan.myhub.service.BodyCompositionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/body-composition")
@CrossOrigin
public class BodyCompositionController {
    private final BodyCompositionService service;

    public BodyCompositionController(BodyCompositionService service) {
        this.service = service;
    }

    // Return only entries for the currently authenticated user
    @GetMapping("/me")
    public List<BodyCompositionDTO> getMyEntries(@AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.getByUserId(userId);
    }

    // Optional: still allow admin or diagnostics with manual userId
    @GetMapping("/user/{userId}")
    public List<BodyCompositionDTO> getByUserId(@PathVariable UUID userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/{id}")
    public BodyCompositionDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Automatically associate new record with the authenticated user
    @PostMapping
    public BodyCompositionDTO create(@RequestBody BodyCompositionDTO dto, @AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        dto.setUserId(userId);
        return service.create(dto);
    }

    // This assumes users can only update their own records (can be extended later)
    @PutMapping("/{id}")
    public BodyCompositionDTO update(@PathVariable Long id, @RequestBody BodyCompositionDTO dto, @AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        return service.update(id, dto, userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @AuthenticationPrincipal Jwt jwt) {
        UUID userId = UUID.fromString(jwt.getSubject());
        service.delete(id, userId);
    }
}
