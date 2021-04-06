package com.zhoubw.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
public class StudentEntity {
    private int id;
    private String name;
    private Integer age;
    private SportEntity sportEntity;

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

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @JoinColumn(name = "sport")
    @ManyToOne(cascade = CascadeType.ALL)
    public SportEntity getSportEntity() {
        return sportEntity;
    }

    public void setSportEntity(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(sportEntity, that.sportEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, sportEntity);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sportEntity=" + sportEntity.toString() +
                '}';
    }
}
