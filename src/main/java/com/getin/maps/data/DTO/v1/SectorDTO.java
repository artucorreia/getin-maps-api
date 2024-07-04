package com.getin.maps.data.DTO.v1;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SectorDTO extends RepresentationModel<SectorDTO> {
    private UUID id;
    private String name;
    private Integer room;
    private String description;
    private UUID annexId;
    private List<SubSectorDTO> subSectors;

    public SectorDTO() {}

    public SectorDTO(UUID id, String name, Integer room, String description, UUID annexId, List<SubSectorDTO> subSectors) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.description = description;
        this.annexId = annexId;
        this.subSectors = subSectors;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getAnnexId() {
        return annexId;
    }

    public void setAnnexId(UUID annexId) {
        this.annexId = annexId;
    }

    public List<SubSectorDTO> getSubSectors() {
        return subSectors;
    }

    public void setSubSectors(List<SubSectorDTO> subSectors) {
        this.subSectors = subSectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectorDTO sectorDTO = (SectorDTO) o;
        return Objects.equals(id, sectorDTO.id) && Objects.equals(name, sectorDTO.name) && Objects.equals(room, sectorDTO.room) && Objects.equals(description, sectorDTO.description) && Objects.equals(annexId, sectorDTO.annexId) && Objects.equals(subSectors, sectorDTO.subSectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, room, description, annexId, subSectors);
    }
}
