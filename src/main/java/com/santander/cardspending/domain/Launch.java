package com.santander.cardspending.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Launch implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private Timestamp register;
    private Double value;
    private String tags;

    public Launch(){

    }

    public Launch(Integer id, String name, String description, Timestamp register, Double value, String tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.register = register;
        this.value = value;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Timestamp getRegister() {
        return register;
    }

    public void setRegister(Timestamp register) {
        this.register = register;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Launch launch = (Launch) o;

        return id != null ? id.equals(launch.id) : launch.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
