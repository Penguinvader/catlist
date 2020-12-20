package com.penguinvader.catlist;

import java.io.Serializable;

/**
 * @author s727953
 *
 */
public class CatUITO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4840260415183676656L;
    private Integer id;

    private String name;

    private String color;

    private String image;

    private Integer age;



    @Override
    public String toString() {
        return "CatUITO [id=" + id + ", name=" + name + ", color=" + color + ", age="
                + age + ", image=" + image +"]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CatUITO other = (CatUITO) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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