package com.halit.icerikyonetimsistemi.repository;

import com.halit.icerikyonetimsistemi.entity.Lesson;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryRepository;

public class LessonRepository extends MyFactoryRepository<Lesson, Long>{
    public LessonRepository(){
        super(new Lesson());
    }
    
}