
package com.halit.icerikyonetimsistemi.service;

import com.halit.icerikyonetimsistemi.entity.Lesson;
import com.halit.icerikyonetimsistemi.repository.LessonRepository;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryService;


public class LessonService extends MyFactoryService<LessonRepository , Lesson, Long>{
    public LessonService(){
        super (new LessonRepository());
}
}