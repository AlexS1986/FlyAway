package com.schlueter.flyaway.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    public Airline() {
        // No-args constructor
    }

    public Airline(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}

