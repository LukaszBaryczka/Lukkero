package inzynierka.lukkero.service;

import java.math.BigInteger;
import java.util.List;

public interface IService < T > {
    public String save ( T t );
    
    public String delete ( T t );
    
    public T findOne ( BigInteger id );
    
    public List< T > getAll ();
}
