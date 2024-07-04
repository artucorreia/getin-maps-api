package com.getin.maps.controllers;

import com.getin.maps.data.DTO.v1.AnnexDTO;
import com.getin.maps.services.AnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/annexes")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class AnnexController {

    @Autowired
    AnnexService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AnnexDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(
            value = "/find",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AnnexDTO findByName(@RequestParam(name = "name") String name) {
        return service.findByName(name);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnnexDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AnnexDTO create(@RequestBody AnnexDTO annexDTO) {
        return service.create(annexDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AnnexDTO update(@RequestBody AnnexDTO annexDTO) {
        return service.update(annexDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
