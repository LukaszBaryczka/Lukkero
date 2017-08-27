package inzynierka.lukkero.service;

import inzynierka.lukkero.model.Documentation;
import inzynierka.lukkero.repository.DocumentationRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service ( "documentationService" )
public class DocumentationService implements IService< Documentation > {
    
    @Autowired
    DocumentationRepository documentationRepository;
    
    @Override
    public String save ( Documentation documentation ) {
        if ( documentationRepository == null ) return StringUtils.EMPTY;
        documentationRepository.save ( documentation );
        return "Success";
    }
    
    @Override
    public String delete ( Documentation documentation ) {
        if ( documentationRepository == null ) return StringUtils.EMPTY;
        documentationRepository.delete ( documentation );
        return "Success";
    }
    
    @Override
    public Documentation findOne ( BigInteger id ) {
        if ( documentationRepository == null ) return new Documentation ( );
        return documentationRepository.findOne ( id );
    }
    
    @Override
    public List< Documentation > getAll () {
        if ( documentationRepository == null ) return new ArrayList<> ( );
        return ( List< Documentation > ) documentationRepository.findAll ( );
    }
}