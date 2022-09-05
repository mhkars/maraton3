/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halit.icerikyonetimsistemi.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="tblquestions")
@Entity
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  
    private Long id;
    @ManyToOne(cascade =CascadeType.ALL)
    private SubjectDetail subjectDetail;
    @ManyToOne(cascade =CascadeType.ALL)
    private User user;
    private String title;
    private String question;        
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt; 
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private boolean enabled;

    public Questions() {
    }

    
    
    public Questions(SubjectDetail subjectDetail, User user, String title, String question, Date createdAt, Date updatedAt, boolean enabled) {
        this.subjectDetail = subjectDetail;
        this.user = user;
        this.title = title;
        this.question = question;
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

    public SubjectDetail getSubjectDetail() {
        return subjectDetail;
    }

    public void setSubjectDetail(SubjectDetail subjectDetail) {
        this.subjectDetail = subjectDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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
        return "Questions{" + "id=" + id + ", subjectDetail=" + subjectDetail + ", user=" + user + ", title=" + title + ", question=" + question + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", enabled=" + enabled + '}';
    }
    
    
}