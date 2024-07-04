package com.getin.maps.services;

import com.getin.maps.controllers.SubSectorController;
import com.getin.maps.data.DTO.v1.SubSectorDTO;
import com.getin.maps.exceptions.ResourceNotFoundException;
import com.getin.maps.mapper.Mapper;
import com.getin.maps.models.SubSector;
import com.getin.maps.repositories.SubSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SubSectorService {
    private final Logger logger = Logger.getLogger(SubSectorService.class.getName());

    @Autowired
    SubSectorRepository repository;

    public SubSectorDTO findById(UUID id) {
        logger.info("Finding one Sub Sector");

        SubSectorDTO subSectorDTO = Mapper.parseObject(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")),
                SubSectorDTO.class
        );

        subSectorDTO.add(linkTo(methodOn(SubSectorController.class).findById(subSectorDTO.getId())).withSelfRel());
        subSectorDTO.add(linkTo(methodOn(SubSectorController.class).findAll()).withRel("all sub sectors"));

        return subSectorDTO;
    }

    public SubSectorDTO findByName(String name) {
        logger.info("Finding one Sub Sector by name");

        SubSectorDTO subSectorDTO = Mapper.parseObject(repository.findByName(name), SubSectorDTO.class);

        subSectorDTO.add(linkTo(methodOn(SubSectorController.class).findById(subSectorDTO.getId())).withSelfRel());
        subSectorDTO.add(linkTo(methodOn(SubSectorController.class).findAll()).withRel("all sub sectors"));

        return subSectorDTO;
    }

    public List<SubSectorDTO> findAll() {
        logger.info("Finding all Sub Sectors");

        return Mapper.parseListObjects(
                repository.findAll(),
                SubSectorDTO.class
        ).stream().map(
            subSectorDTO -> subSectorDTO.add(
                linkTo(methodOn(SubSectorController.class).findById(subSectorDTO.getId())).withSelfRel()
            )
        ).toList();
    }

    public SubSectorDTO create(SubSectorDTO subsectorDTO) {
        logger.info("Creating one Sub Sector");

        SubSector entity = Mapper.parseObject(subsectorDTO, SubSector.class);

        SubSectorDTO subSector = Mapper.parseObject(repository.save(entity), SubSectorDTO.class);

        subSector.add(linkTo(methodOn(SubSectorController.class).findById(subSector.getId())).withSelfRel());
        subSector.add(linkTo(methodOn(SubSectorController.class).findAll()).withRel("all sub sectors"));

        return subSector;
    }

    public SubSectorDTO update(SubSectorDTO subsectorDTO) {
        logger.info("Updating one Sub Sector");

        SubSector entity = Mapper.parseObject(findById(subsectorDTO.getId()), SubSector.class);

        entity.setName(subsectorDTO.getName());
        entity.setDescription(subsectorDTO.getDescription());

        SubSectorDTO subSector = Mapper.parseObject(repository.save(entity), SubSectorDTO.class);

        subSector.add(linkTo(methodOn(SubSectorController.class).findById(subSector.getId())).withSelfRel());
        subSector.add(linkTo(methodOn(SubSectorController.class).findAll()).withRel("all sub sectors"));

        return subSector;
    }

    public void delete(UUID id) {
        logger.info("Deleting one SubSector");

        repository.delete(Mapper.parseObject(findById(id), SubSector.class));
    }
}
