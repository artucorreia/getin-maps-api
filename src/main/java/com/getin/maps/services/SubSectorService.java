package com.getin.maps.services;

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

@Service
public class SubSectorService {
    private final Logger logger = Logger.getLogger(SubSectorService.class.getName());

    @Autowired
    SubSectorRepository repository;

    public SubSectorDTO findById(UUID id) {
        logger.info("Finding one Sub Sector");

        return Mapper.parseObject(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")),
                SubSectorDTO.class
        );
    }

    public SubSectorDTO findByName(String name) {
        logger.info("Finding one Sub Sector by name");

        return Mapper.parseObject(repository.findByName(name), SubSectorDTO.class);
    }

    public List<SubSectorDTO> findAll() {
        logger.info("Finding all Sub Sectors");

        return Mapper.parseListObjects(repository.findAll(), SubSectorDTO.class);
    }

    public SubSectorDTO create(SubSectorDTO subsectorDTO) {
        logger.info("Creating one Sub Sector");

        SubSector entity = Mapper.parseObject(subsectorDTO, SubSector.class);

        return Mapper.parseObject(repository.save(entity), SubSectorDTO.class);
    }

    public SubSectorDTO update(SubSectorDTO subsectorDTO) {
        logger.info("Updating one Sub Sector");

        SubSector entity = Mapper.parseObject(findById(subsectorDTO.getId()), SubSector.class);

        entity.setName(subsectorDTO.getName());
        entity.setDescription(subsectorDTO.getDescription());

        return Mapper.parseObject(repository.save(entity), SubSectorDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one SubSector");

        repository.delete(Mapper.parseObject(findById(id), SubSector.class));
    }
}
