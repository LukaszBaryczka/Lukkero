package inzynierka.lukkero.util;

import java.util.List;

public interface DefaultService<T> {	
	T findById(String id);
    T findByName(String name);     
    void save(T object);     
    void update(T object);     
    void deleteById(long id); 
    List<T> findAll();   
}
