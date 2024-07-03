package com.getin.maps.repositories;

import com.getin.maps.models.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SectorRepository extends JpaRepository<Sector, UUID> {
    Sector findByName(String name);
}
