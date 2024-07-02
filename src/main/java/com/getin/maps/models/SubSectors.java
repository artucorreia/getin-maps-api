package com.getin.maps.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "SUBSECTORS")
public class SubSectors implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column
    private Integer room;

    @Column(nullable = false)
    private String description;

    @ManyToOne @JoinColumn(name = "sector_id", referencedColumnName = "id", nullable = false)
    private Sector sector;

    public SubSectors() {}

    public SubSectors(UUID id, String name, Integer room, String description, Sector sector) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.description = description;
        this.sector = sector;
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubSectors that = (SubSectors) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(room, that.room) && Objects.equals(description, that.description) && Objects.equals(sector, that.sector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, room, description, sector);
    }
}
