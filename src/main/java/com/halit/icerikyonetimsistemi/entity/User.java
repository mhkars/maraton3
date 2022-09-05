/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halit.icerikyonetimsistemi.entity;

import java.util.Date;
import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="tbluser")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  
    private Long id;
    private String name;
    private String surname;
    private ERole role;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt; 
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private boolean enabled;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "tbladresid")
//    private Adres adres;

    public User() {
    }

    public User(String name, String surname, ERole role, Date createdAt, Date updatedAt, boolean enabled) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", role=" + role + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", enabled=" + enabled + '}';
    }
    
    
    
}
