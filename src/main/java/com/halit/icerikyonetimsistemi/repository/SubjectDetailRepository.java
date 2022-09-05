package com.halit.icerikyonetimsistemi.repository;


import com.halit.icerikyonetimsistemi.entity.SubjectDetail;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryRepository;

public class SubjectDetailRepository extends MyFactoryRepository<SubjectDetail, Long>{
    public SubjectDetailRepository(){
        super(new SubjectDetail());
    }
    
}
