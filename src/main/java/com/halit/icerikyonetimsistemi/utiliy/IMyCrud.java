package com.halit.icerikyonetimsistemi.utiliy;

import java.util.List;
import java.util.Optional;

public interface IMyCrud<T,ID> extends IMyRepository<T, ID>{
    <S extends T> S save(S entity); // verilen entity nesnesi kayıt edilecek
    <S extends T> Iterable<S> save(Iterable<S> entities); // bir liste şeklinde nesneleri göndererek kayıt edebiliriz.
    void deleteById(ID id); // generic olarak verilen ID nin tipine göre id iletilerek silme işlemi yapılır.
    void delete(T entity); // nesnenin kendisi verilerek kayıt silinir.
    Optional<T> findById(ID id); // id ye göre iligili kayıt optional olarak döner
    boolean existById(ID id); // id si veilen kayıt ın olup olmadığı dönülür (true/false)
    List<T> findAll(); // tüm kayıtları listeler
    List<T> findByColumnAndValue(String column, Object value); // kolon ve değeri verilen kayıtları eşleştirelek listeler
    List<T> findByEntity(T entity); // nesnenin kendisi sorgulama yapılacak alanları ile doldurularak işlenir. 
    
}
