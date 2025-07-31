package com.voskan.myhub.controller;

import com.voskan.myhub.dto.BodyCompositionDTO;
import com.voskan.myhub.service.BodyCompositionService;
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

    @GetMapping("/user/{userId}")
    public List<BodyCompositionDTO> getByUserId(@PathVariable UUID userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/{id}")
    public BodyCompositionDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public BodyCompositionDTO create(@RequestBody BodyCompositionDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public BodyCompositionDTO update(@PathVariable Long id, @RequestBody BodyCompositionDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
