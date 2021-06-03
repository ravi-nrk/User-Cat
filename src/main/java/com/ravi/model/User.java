package com.ravi.model;
import javax.persistence.*;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class User
{

@Id
@Column
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;

@Column
private String name;


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
}