package com.getin.maps.repositories;

import com.getin.maps.models.Annex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnnexRepository extends JpaRepository<Annex, UUID> {
    Annex findByName(String name);
}
