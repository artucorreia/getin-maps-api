package com.getin.maps.services;

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

@Service
public class SectorService {
    private final Logger logger = Logger.getLogger(SectorService.class.getName());

    @Autowired
    SectorRepository repository;

    public SectorDTO findById(UUID id) {
        logger.info("Finding one sector");

        return Mapper.parseObject(
                repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id")),
                SectorDTO.class
        );
    }

    public SectorDTO findByName(String name) {
        logger.info("Finding one sector by name");

        return Mapper.parseObject(repository.findByName(name), SectorDTO.class);
    }

    public List<SectorDTO> findAll() {
        logger.info("Finding all sectors");

        return Mapper.parseListObjects(repository.findAll(), SectorDTO.class);
    }

    public SectorDTO create(SectorDTO sectorDTO) {
        logger.info("Creating one sector");

        Sector entity = Mapper.parseObject(sectorDTO, Sector.class);

        return Mapper.parseObject(repository.save(entity), SectorDTO.class);
    }

    public SectorDTO update(SectorDTO sectorDTO) {
        logger.info("Updating one sector");

        Sector entity = Mapper.parseObject(findById(sectorDTO.getId()), Sector.class);

        entity.setName(sectorDTO.getName());
        entity.setDescription(sectorDTO.getDescription());

        return Mapper.parseObject(repository.save(entity), SectorDTO.class);
    }

    public void delete(UUID id) {
        logger.info("Deleting one sector");

        repository.delete(Mapper.parseObject(findById(id), Sector.class));
    }
}
