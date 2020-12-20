package com.penguinvader.catlist;

import javax.persistence.*;

@Entity
@Table(name = "CAT_INFO")
@org.hibernate.annotations.NamedQuery(name = "Cat.findAll", query = "SELECT a FROM Cat a")
public class Cat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "COLOR", nullable = false)
    private String color;
    @Column(name = "AGE", nullable = false)
    private Integer age;
    @Column(name = "IMAGE", nullable = true)
    private String image;


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

    public String getColor() {
        return color;
    }

    public void setColor(String email) {
        this.color = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
