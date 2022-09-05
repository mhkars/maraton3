package com.halit.icerikyonetimsistemi.repository;

import com.halit.icerikyonetimsistemi.entity.User;
import com.halit.icerikyonetimsistemi.utiliy.MyFactoryRepository;

public class UserRepository extends MyFactoryRepository<User, Long>{
    public UserRepository(){
        super(new User());
    }
}
