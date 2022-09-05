package com.halit.icerikyonetimsistemi.utiliy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class MyFactoryRepository<T,ID> implements IMyCrud<T, ID>{

    private Session ss;
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    private Transaction tt;
    private T t;
    public MyFactoryRepository(T t){
        entityManager = HibernateUtility.getFACTORY().createEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
        this.t = t;
    }
    
    public void openSession(){
        ss = HibernateUtility.getFACTORY().openSession();
        tt = ss.beginTransaction();
    }
    
    public void closeSuccess(){
        tt.commit();
        ss.close();
    }
    
    public void closeError(){
        tt.rollback();
        ss.close();
    }
    

    @Override
    public <S extends T> S save(S entity) {
        try{
            openSession();
            ss.save(entity);
            closeSuccess();
            return entity;
        }catch(Exception exception){
            closeError();
            throw exception;
        }
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        try{
            openSession();
            entities.forEach(entity->{              
                ss.save(entity);               
            });
            closeSuccess();
            return entities;
        }catch(Exception exception){
            closeError();
            throw exception;
        }
    }

    @Override
    public void deleteById(ID id) {
        T deleteEntity=null;
        CriteriaQuery<T> criteria = (CriteriaQuery<T>)criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"), id));       
        List<T> result = entityManager.createQuery(criteria).getResultList();
        if(!result.isEmpty()){
            deleteEntity = (T)result.get(0);
            try{
                openSession();
               ss.delete(deleteEntity);
               closeSuccess();
            }catch(Exception e){
               closeError();
            }
           
        }
        
    }

    @Override
    public void delete(T entity) {
        try{
            openSession();
            ss.delete(entity);
            closeSuccess();          
        }catch(Exception exception){
            closeError();
            throw exception;
        }
    }

    @Override
    public Optional<T> findById(ID id) {
     
        CriteriaQuery<T> criteria = (CriteriaQuery<T>)criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get("id"), id));        
     
        List<T> result = entityManager.createQuery(criteria).getResultList();
        if(!result.isEmpty())
            return Optional.of(result.get(0));
        else
            return Optional.empty();
    }

    @Override
    public boolean existById(ID id) {
        try{
           CriteriaQuery<T> criteria = (CriteriaQuery<T>)criteriaBuilder.createQuery(t.getClass());
           Root<T> root = (Root<T>) criteria.from(t.getClass());
           criteria.select(root); 
           criteria.where(criteriaBuilder.equal(root.get("id"), id));        
  
           List<T> result = entityManager.createQuery(criteria).getResultList();
           return !result.isEmpty(); 
        }catch(Exception exception){
            return false;
        }
    }

    @Override
    public List<T> findAll() {
             CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);

        return  entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<T> findByColumnAndValue(String column, Object value) {
         CriteriaQuery<T> criteria = (CriteriaQuery<T>) criteriaBuilder.createQuery(t.getClass());
        Root<T> root = (Root<T>) criteria.from(t.getClass());
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get(column), value));
        return entityManager.createQuery(criteria).getResultList();
    }


    @Override
    public List<T> findByEntity(T entity) {
        List<T> result = null;
        Class cl = entity.getClass(); 
        Field[] fl = cl.getDeclaredFields(); 
        try{
     
            CriteriaQuery<T> criteria =(CriteriaQuery<T>) criteriaBuilder.createQuery(entity.getClass());
            Root<T> root = (Root<T>) criteria.from(t.getClass());            
            criteria.select(root);
            List<Predicate> list = new ArrayList<>();
            for(int i=0;i<fl.length;i++){
       
                fl[i].setAccessible(true);
                if(fl[i].get(t)!=null && !fl[i].getName().equals("id")){
                    if(fl[i].getType().isAssignableFrom(String.class)) 
                        list.add(criteriaBuilder.like(root.get(fl[i].getName()), "%"+fl[i].get(t)+"%"));
                    else
                        list.add(criteriaBuilder.equal(root.get(fl[i].getName()), fl[i].get(t)));
                }
            }
            criteria.where(list.toArray(new Predicate[]{})); 
            result = entityManager.createQuery(criteria).getResultList();
                     
                    
        }catch(Exception exception){
            System.out.println("findByEntiy Error.....: "+ exception.getLocalizedMessage());
        }
        
        return result;
    }
 
   
    
}
