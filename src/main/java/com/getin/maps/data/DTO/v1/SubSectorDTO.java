package com.getin.maps.data.DTO.v1;

import java.util.UUID;

public class SubSectorDTO {
    private UUID id;
    private String name;
    private Integer room;
    private String description;
    private UUID sectorId;

    public SubSectorDTO() {}

    public SubSectorDTO(UUID id, String name, Integer room, String description, UUID sectorId) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.description = description;
        this.sectorId = sectorId;
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

    public UUID getSectorId() {
        return sectorId;
    }

    public void setSectorId(UUID sectorId) {
        this.sectorId = sectorId;
    }
}
