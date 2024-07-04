package com.getin.maps.controllers;

import com.getin.maps.data.DTO.v1.SubSectorDTO;
import com.getin.maps.services.SubSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/subsectors")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
public class SubSectorController {

    @Autowired
    SubSectorService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SubSectorDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping(
            value = "/find",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SubSectorDTO findByName(@RequestParam(name = "name") String name) {
        return service.findByName(name);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SubSectorDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SubSectorDTO create(@RequestBody SubSectorDTO subSectorDTO) {
        return service.create(subSectorDTO);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public SubSectorDTO update(@RequestBody SubSectorDTO subSectorDTO) {
        return service.update(subSectorDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
