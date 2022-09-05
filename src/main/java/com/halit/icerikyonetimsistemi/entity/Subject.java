
package com.halit.icerikyonetimsistemi.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="tblsubject")
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  
    private Long id;
    private String name;
    @ManyToOne(cascade =CascadeType.ALL) 
    private Lesson lesson;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt; 
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    private boolean enabled;
  

    public Subject() {
    }

    
    
    public Subject(String name, Lesson lesson, Date createdAt, Date updatedAt, boolean enabled) {
        this.name = name;
        this.lesson = lesson;
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
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
        return "Subject{" + "id=" + id + ", name=" + name + ", lesson=" + lesson + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", enabled=" + enabled + '}';
    }
    
    
    
    
}

