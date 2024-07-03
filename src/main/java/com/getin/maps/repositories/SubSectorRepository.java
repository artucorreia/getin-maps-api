package com.getin.maps.repositories;

import com.getin.maps.models.SubSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubSectorRepository extends JpaRepository<SubSector, UUID> {
    SubSector findByName(String name);
}
