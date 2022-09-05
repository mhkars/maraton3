
package com.halit.icerikyonetimsistemi.entity;

import java.util.Date;
import javax.persistence.CascadeType;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Table(name="tblanswers")
@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  
    private Long id;
    @OneToOne(cascade=CascadeType.ALL)
    private Questions question;
    @ManyToOne(cascade =CascadeType.ALL)
    private User user;
    private String title;
    private String answers;        
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt; 
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private boolean enabled;

    public Answers() {
    }

    
    
    public Answers(Questions question, User user, String title, String answers, Date createdAt, Date updatedAt, boolean enabled) {
        this.question = question;
        this.user = user;
        this.title = title;
        this.answers = answers;
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

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
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

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
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
        return "Answers{" + "id=" + id + ", question=" + question + ", user=" + user + ", title=" + title + ", answers=" + answers + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", enabled=" + enabled + '}';
    }
    
    
    
    
}