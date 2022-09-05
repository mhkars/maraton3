/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.halit.icerikyonetimsistemi.service;

import com.halit.icerikyonetimsistemi.entity.User;
import com.halit.icerikyonetimsistemi.repository.UserRepository;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryService;


public class UserService extends MyFactoryService<UserRepository , User, Long>{
    public UserService(){
        super (new UserRepository());
    }
}
