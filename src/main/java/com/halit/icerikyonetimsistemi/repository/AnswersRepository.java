
package com.halit.icerikyonetimsistemi.repository;

import com.halit.icerikyonetimsistemi.entity.Answers;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryRepository;


public class AnswersRepository extends MyFactoryRepository<Answers, Long>{
    public AnswersRepository(){
        super(new Answers());
    }
    
}