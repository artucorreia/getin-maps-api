package com.getin.maps.services;

import com.getin.maps.controllers.SectorController;
import com.getin.maps.controllers.SectorController;
import com.getin.maps.data.DTO.v1.SectorDTO;
import com.getin.maps.exceptions.ResourceNotFoundException;
import com.getin.maps.mapper.Mapper;
import com.getin.maps.models.Sector;
import com.getin.maps.repositories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SectorService {
    private final Logger logger = Logger.getLogger(SectorService.class.getName());

    @Autowired
    SectorRepository repository;

    public SectorDTO findById(UUID id) {
        logger.info("Finding one sector");

        SectorDTO sectorDTO = Mapper.parseObject(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")),
                SectorDTO.class
        );

        sectorDTO.add(linkTo(methodOn(SectorController.class).findById(sectorDTO.getId())).withSelfRel());
        sectorDTO.add(linkTo(methodOn(SectorController.class).findAll()).withRel("all sectors"));

        return sectorDTO;
    }

    public SectorDTO findByName(String name) {
        logger.info("Finding one sector by name");

        SectorDTO sectorDTO = Mapper.parseObject(repository.findByName(name), SectorDTO.class);

        sectorDTO.add(linkTo(methodOn(SectorController.class).findById(sectorDTO.getId())).withSelfRel());
        sectorDTO.add(linkTo(methodOn(SectorController.class).findAll()).withRel("all sectors"));

        return sectorDTO;
    }

    public List<SectorDTO> findAll() {
        logger.info("Finding all sectors");

        return Mapper.parseListObjects(
                repository.findAll(),
                SectorDTO.class
        ).stream().map(
                sectorDTO -> sectorDTO.add(
                        linkTo(methodOn(SectorController.class).findById(sectorDTO.getId())).withSelfRel()
                )
        ).toList();
    }

    public SectorDTO create(SectorDTO sectorDTO) {
        logger.info("Creating one sector");

        Sector entity = Mapper.parseObject(sectorDTO, Sector.class);

        SectorDTO sector = Mapper.parseObject(repository.save(entity), SectorDTO.class);

        sector.add(linkTo(methodOn(SectorController.class).findById(sector.getId())).withSelfRel());
        sector.add(linkTo(methodOn(SectorController.class).findAll()).withRel("all sectors"));

        return sector;
    }

    public SectorDTO update(SectorDTO sectorDTO) {
        logger.info("Updating one sector");

        Sector entity = Mapper.parseObject(findById(sectorDTO.getId()), Sector.class);

        entity.setName(sectorDTO.getName());
        entity.setDescription(sectorDTO.getDescription());

        SectorDTO sector = Mapper.parseObject(repository.save(entity), SectorDTO.class);

        sector.add(linkTo(methodOn(SectorController.class).findById(sector.getId())).withSelfRel());
        sector.add(linkTo(methodOn(SectorController.class).findAll()).withRel("all sectors"));

        return sector;
    }

    public void delete(UUID id) {
        logger.info("Deleting one sector");

        repository.delete(Mapper.parseObject(findById(id), Sector.class));
    }
}
