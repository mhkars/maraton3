package com.halit.icerikyonetimsistemi.service;

import com.halit.icerikyonetimsistemi.entity.SubjectDetail;
import com.halit.icerikyonetimsistemi.repository.SubjectDetailRepository;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryService;


public class SubjectDetailService extends MyFactoryService<SubjectDetailRepository , SubjectDetail, Long>{
    public SubjectDetailService(){
        super (new SubjectDetailRepository());
}
}