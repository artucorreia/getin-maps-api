package com.getin.maps.data.DTO.v1;

import java.util.List;
import java.util.UUID;

public class AnnexDTO {
    private UUID id;
    private String name;
    private String description;
    private List<SectorDTO> sectors;

    public AnnexDTO() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SectorDTO> getSectors() {
        return sectors;
    }

    public void setSectors(List<SectorDTO> sectors) {
        this.sectors = sectors;
    }
}
