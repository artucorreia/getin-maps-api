package com.getin.maps.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table
@Entity(name = "ANNEXES")
public class Annex implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 150)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "annex")
    private List<Sector> sectors;

    public Annex() {}

    public Annex(UUID id, String name, String description, List<Sector> sectors) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sectors = sectors;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Annex annex = (Annex) o;
        return Objects.equals(id, annex.id) && Objects.equals(name, annex.name) && Objects.equals(description, annex.description) && Objects.equals(sectors, annex.sectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, sectors);
    }
}
