package com.halit.icerikyonetimsistemi;

import com.halit.icerikyonetimsistemi.entity.ERole;
import com.halit.icerikyonetimsistemi.entity.Lesson;
import com.halit.icerikyonetimsistemi.entity.Subject;
import com.halit.icerikyonetimsistemi.entity.SubjectDetail;
import com.halit.icerikyonetimsistemi.entity.User;
import com.halit.icerikyonetimsistemi.service.LessonService;

import com.halit.icerikyonetimsistemi.service.SubjectDetailService;
import com.halit.icerikyonetimsistemi.service.SubjectService;
import com.halit.icerikyonetimsistemi.service.UserService;

import com.halit.icerikyonetimsistemi.utiliy.HibernateUtility;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;




public class ImplementsAndQueries {
        private static EntityManager entityManager;
        

    
    static void ImplData(){
        UserService userSer = new UserService();
        LessonService lessonSer = new LessonService();
        SubjectService subjectSer = new SubjectService();
        SubjectDetailService subjectDetailSer = new SubjectDetailService();


        
        User user1 = new User("Ahmet", "YENER", ERole.USER, new Date(), null, true);
        User user2 = new User("Mehmet", "YANAR", ERole.EDITOR, new Date(), null, true);
        User user3 = new User("Mahmut", "KARAR", ERole.EDITOR, new Date(), null, true);
        User user4 = new User("Ali", "BEKAR", ERole.EDITOR, new Date(), null, true);
        User user5 = new User("Veli", "BAKAR", ERole.EDITOR, new Date(), null, true);
        
        Lesson lesson1 = new Lesson("Java","Java Basic" , new Date(), null, true);
        Lesson lesson2 = new Lesson(".Net",".Net Advanced" , new Date(), null, true);
        Lesson lesson3 = new Lesson("C++","C++ Basic" , new Date(), null, true);
        
        Subject subject1 = new Subject("Java 101", lesson1, new Date(), null, true);
        Subject subject2 = new Subject("Java 102", lesson1, new Date(), null, true);
        Subject subject3 = new Subject(".Net 101", lesson2, new Date(), null, true);
        Subject subject4 = new Subject(".Net 102", lesson2, new Date(), null, true);
        Subject subject5 = new Subject("C++ 101", lesson3, new Date(), null, true);
        Subject subject6 = new Subject("C++ 102", lesson3, new Date(), null, true);
        
        
        SubjectDetail subjectDetail1 = new SubjectDetail(subject1, user2, "Spring", "The main s of Java.", "Articale of Spring", new Date(), null, true);
        SubjectDetail subjectDetail2 = new SubjectDetail(subject2, user2, "React", "The main second of Java.", "Articale of React", new Date(), null, true);
        SubjectDetail subjectDetail3 = new SubjectDetail(subject3, user3, "OOP", "The main first of .Net.", "Articale of Abstraction", new Date(), null, true);
        SubjectDetail subjectDetail4 = new SubjectDetail(subject4, user4, "ORM", "The main second of .Net.", "Articale of JDBC", new Date(), null, true);
        SubjectDetail subjectDetail5 = new SubjectDetail(subject5, user4, "Hibernate", "The first subject of C++.", "Articale of DataProcessing", new Date(), null, true);
        SubjectDetail subjectDetail6 = new SubjectDetail(subject6, user5, "Database", "The second subject of C++.", "Articale of Data", new Date(), null, true);
       
     
        userSer.save(user1);
        userSer.save(user2);
        userSer.save(user3);
        userSer.save(user4);
        userSer.save(user5);

        lessonSer.save(lesson1);
        lessonSer.save(lesson2);
        lessonSer.save(lesson3);
        
        
        subjectSer.save(subject1);
        subjectSer.save(subject2);
        subjectSer.save(subject3);
        subjectSer.save(subject4);
        subjectSer.save(subject5);
        subjectSer.save(subject6);
        
        subjectDetailSer.save(subjectDetail1);
        subjectDetailSer.save(subjectDetail2);
        subjectDetailSer.save(subjectDetail3);
        subjectDetailSer.save(subjectDetail4);
        subjectDetailSer.save(subjectDetail5);
        subjectDetailSer.save(subjectDetail6);
  
                
    }
    public static void EnCokIcerikUretmisKullanıcıKim(){
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        User user = (User) entityManager.createNativeQuery("select count(sd.id) as number_of_content, sd.user_id, u.name, u.surname "
            + "from tblsubjectdetail as sd join tbluser as u on sd.user_id = u.id group by u.name, u.surname, sd.user_id order by number_of_content desc limit 1", User.class).getSingleResult(); 
        System.out.println(user); 
    }

    public static Object SorularGenellikleHangiDersteSorulmus(){
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        return entityManager.createNativeQuery("select count(q.user_id) as number_of_questions, l.name, from tblquestion as q join tblsubjectdetail as sd "
                + "on q.subjectdetail_id = sd.id join tblsubject as s on sd.subject_id=s.id join tbllesson as l on s.lesson_id = l.id group by l.name "
                + "order by number_of_questions desc limit 1").getSingleResult(); 
           }

    public static List<Object> BirdenFazlaDersIcinIcerikUretenKacEditorVar(){
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
  
        return entityManager.createNativeQuery("select count(*) as count from (select sd.user_id, count(distinct(lesson_id)) from "
                + "tblsubjectdetail as sub join tblsubject as s on sub.subject_id=s.id group by sd.user_id) as tblnew where tblnew.count>1").getResultList(); 
    }
    
    public static Object SoruCevaplamaHızıEnYuksekOlanEditorHangisidir(){
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        return entityManager.createNativeQuery("select EXTRACT(EPOCH FROM (a.createddate - q.createddate)) as period, a.user_id, u.name, u.surname  from tblanswer as a "
                + "join tblquestion as q on a.question_id = q.id join tbluser as u on u.id = a.user_id group by a.createddate, a.user_id, q.createddate, u.name, u.surname"
                + " order by time asc limit 1").getSingleResult(); 
    }

    public static List<Object> MakaleIcindeBasliktanHicbirKelimeIcermeyenMakalelerHangileridir(){
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        return entityManager.createNativeQuery("select * from tblsubjectdetail where tblsubjectdetail.article not ilike '%'|| tblsubjectdetail.title ||'%'", User.class).getResultList(); 
    }
    
  
}

