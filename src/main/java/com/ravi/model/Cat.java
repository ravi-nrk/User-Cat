package com.ravi.model;

import javax.persistence.*;

@Entity
//defining class name as Table name
@Table
public class Cat {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String url;

    @Column
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
