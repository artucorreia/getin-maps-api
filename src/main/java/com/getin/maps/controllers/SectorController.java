package com.getin.maps.controllers;

import com.getin.maps.data.DTO.v1.SectorDTO;
import com.getin.maps.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sectors")
public class SectorController {

    @Autowired
    SectorService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SectorDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(
            value = "/find",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SectorDTO findByName(@RequestParam(name = "name") String name) {
        return service.findByName(name);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SectorDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SectorDTO create(@RequestBody SectorDTO sectorDTO) {
        return service.create(sectorDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SectorDTO update(@RequestBody SectorDTO sectorDTO) {
        return service.update(sectorDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
