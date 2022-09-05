/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halit.icerikyonetimsistemi.service;

import com.halit.icerikyonetimsistemi.entity.Subject;
import com.halit.icerikyonetimsistemi.repository.SubjectRepository;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryService;


public class SubjectService extends MyFactoryService<SubjectRepository , Subject, Long>{
    public SubjectService(){
        super (new SubjectRepository());
}
}
