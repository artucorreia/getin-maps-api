package com.getin.maps.data.DTO.v1;

import java.util.List;
import java.util.UUID;

public class SectorDTO {
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
}
