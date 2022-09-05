
package com.halit.icerikyonetimsistemi.service;

import com.halit.icerikyonetimsistemi.entity.Questions;
import com.halit.icerikyonetimsistemi.repository.QuestionsRepository;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryService;

public class QuestionsService extends MyFactoryService<QuestionsRepository , Questions, Long>{
    public QuestionsService(){
        super (new QuestionsRepository());
}
}
