package com.halit.icerikyonetimsistemi.service;

import com.halit.icerikyonetimsistemi.entity.Answers;
import com.halit.icerikyonetimsistemi.repository.AnswersRepository;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryService;

public class AnswersService extends MyFactoryService<AnswersRepository , Answers, Long>{
    public AnswersService(){
        super (new AnswersRepository());
}
}