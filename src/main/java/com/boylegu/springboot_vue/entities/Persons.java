package com.boylegu.springboot_vue.entities;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;


@Entity
public class Persons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private Date create_datetime;
    private String username;
    private String email;
    private String phone;
    private String sex;
    private TextArea zone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreate_datetime() {
        return create_datetime;

    }

    public void setCreate_datetime(Date create_datetime) {
        this.create_datetime = create_datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}