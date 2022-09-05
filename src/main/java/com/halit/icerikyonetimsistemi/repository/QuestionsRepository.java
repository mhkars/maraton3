
package com.halit.icerikyonetimsistemi.repository;


import com.halit.icerikyonetimsistemi.entity.Questions;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryRepository;

public class QuestionsRepository extends MyFactoryRepository<Questions, Long>{
    public QuestionsRepository(){
        super(new Questions());
    }
    
}