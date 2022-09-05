package com.halit.icerikyonetimsistemi.utiliy;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static final SessionFactory FACTORY;

    static{
        try {
            Configuration configuration = new Configuration();
//            configuration.addAnnotatedClass(Adres.class);
//            configuration.addAnnotatedClass(Araba.class);
//            configuration.addAnnotatedClass(Kiralama.class);
//            configuration.addAnnotatedClass(Musteri.class);
//            configuration.addAnnotatedClass(Personel.class);
            

           
            FACTORY = new  Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    
}
