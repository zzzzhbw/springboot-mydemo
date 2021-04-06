package com.zhoubw.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sport")
public class SportEntity {
    private int id;
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportEntity that = (SportEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "SportEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
