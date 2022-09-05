package com.halit.icerikyonetimsistemi.repository;

import com.halit.icerikyonetimsistemi.entity.Subject;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryRepository;


public class SubjectRepository extends MyFactoryRepository<Subject, Long>{
    public SubjectRepository(){
        super(new Subject());
    }
}
