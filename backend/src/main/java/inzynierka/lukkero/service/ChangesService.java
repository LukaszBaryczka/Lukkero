package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Change;
import inzynierka.lukkero.repository.ChangesRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "changesService" )
//@Scope("session")
public class ChangesService implements IService< Change > {
    
    @Autowired
    ChangesRepository changesRepository;
    
    @Override
    public String save ( Change change ) {
        if ( changesRepository == null ) return StringUtils.EMPTY;
        changesRepository.save ( change );
        return "Success";
    }
    
    @Override
    public String delete ( Change change ) {
        if ( changesRepository == null ) return StringUtils.EMPTY;
        changesRepository.delete ( change );
        return "Success";

    }
    
    @Override
    public Change findOne ( BigInteger id ) {
        if ( changesRepository == null ) return new Change ( );
        return changesRepository.findOne ( id );
    }
    
    @Override
    public List< Change > getAll () {
        if ( changesRepository == null ) return new ArrayList<> ( );
        return ( List< Change > ) changesRepository.findAll ( );
    }
}