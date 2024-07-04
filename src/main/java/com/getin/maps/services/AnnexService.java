package com.getin.maps.services;

import com.getin.maps.controllers.AnnexController;
import com.getin.maps.data.DTO.v1.AnnexDTO;
import com.getin.maps.exceptions.ResourceNotFoundException;
import com.getin.maps.mapper.Mapper;
import com.getin.maps.models.Annex;
import com.getin.maps.repositories.AnnexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Service
public class AnnexService {
    private final Logger logger = Logger.getLogger(AnnexService.class.getName());

    @Autowired
    AnnexRepository repository;

    public AnnexDTO findById(UUID id) {
        logger.info("Finding one annex");

        AnnexDTO annexDTO = Mapper.parseObject(
            repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")),
            AnnexDTO.class
        );

        annexDTO.add(linkTo(methodOn(AnnexController.class).findById(annexDTO.getId())).withSelfRel());
        annexDTO.add(linkTo(methodOn(AnnexController.class).findAll()).withRel("all annexes"));

        return annexDTO;
    }

    public AnnexDTO findByName(String name) {
        logger.info("Finding one annex by name");

        AnnexDTO annexDTO = Mapper.parseObject(repository.findByName(name), AnnexDTO.class);

        annexDTO.add(linkTo(methodOn(AnnexController.class).findById(annexDTO.getId())).withSelfRel());
        annexDTO.add(linkTo(methodOn(AnnexController.class).findAll()).withRel("all annexes"));

        return annexDTO;
    }

    public List<AnnexDTO> findAll() {
        logger.info("Finding all annexes");

        return Mapper.parseListObjects(
                repository.findAll(),
                AnnexDTO.class
        ).stream().map(
            annexDTO -> annexDTO.add(
                linkTo(
                        methodOn(AnnexController.class).findById(annexDTO.getId())
                ).withSelfRel()
            )
        ).toList();
    }

    public AnnexDTO create(AnnexDTO annexDTO) {
        logger.info("Creating one annex");

        Annex entity = Mapper.parseObject(annexDTO, Annex.class);

        AnnexDTO annex = Mapper.parseObject(repository.save(entity), AnnexDTO.class);

        annex.add(linkTo(methodOn(AnnexController.class).findById(annex.getId())).withSelfRel());
        annex.add(linkTo(methodOn(AnnexController.class).findAll()).withRel("all annexes"));

        return annex;
    }

    public AnnexDTO update(AnnexDTO annexDTO) {
        logger.info("Updating one annex");

        Annex entity = Mapper.parseObject(findById(annexDTO.getId()), Annex.class);

        entity.setName(annexDTO.getName());
        entity.setDescription(annexDTO.getDescription());

        AnnexDTO annex = Mapper.parseObject(repository.save(entity), AnnexDTO.class);

        annex.add(linkTo(methodOn(AnnexController.class).findById(annex.getId())).withSelfRel());
        annex.add(linkTo(methodOn(AnnexController.class).findAll()).withRel("all annexes"));

        return annex;
    }

    public void delete(UUID id) {
        logger.info("Deleting one annex");

        repository.delete(Mapper.parseObject(findById(id), Annex.class));
    }
}
