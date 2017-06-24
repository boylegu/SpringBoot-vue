package com.boylegu.springboot_vue.entities;

import javax.persistence.*;
import java.util.Date;
import java.io.Serializable;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "persons")
public class Persons implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name = "create_datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_datetime;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "sex")
    private String sex;
    @Column(name = "zone")
    private String zone;

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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}