package com.getin.maps.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "SECTORS")
public class Sector implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column
    private Integer room;

    @Column(nullable = false)
    private String description;

    @ManyToOne @JoinColumn(name = "annex_id", referencedColumnName = "id", nullable = false)
    private Annex annex;

    @OneToMany(mappedBy = "sector")
    private List<SubSectors> subSectors;

    public Sector() {}

    public Sector(UUID id, String name, Integer room, String description, Annex annex, List<SubSectors> subSectors) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.description = description;
        this.annex = annex;
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

    public Annex getAnnex() {
        return annex;
    }

    public void setAnnex(Annex annex) {
        this.annex = annex;
    }

    public List<SubSectors> getSubSectors() {
        return subSectors;
    }

    public void setSubSectors(List<SubSectors> subSectors) {
        this.subSectors = subSectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sector sector = (Sector) o;
        return Objects.equals(id, sector.id) && Objects.equals(name, sector.name) && Objects.equals(room, sector.room) && Objects.equals(description, sector.description) && Objects.equals(annex, sector.annex) && Objects.equals(subSectors, sector.subSectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, room, description, annex, subSectors);
    }
}