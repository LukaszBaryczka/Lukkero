package inzynierka.lukkero.util;

import inzynierka.lukkero.dto.ChangeDTO;
import inzynierka.lukkero.model.Change;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class ChangesConverter implements IConverter<Change, ChangeDTO> {
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public ChangeDTO entityToDto ( Change change ) {
        ChangeDTO changeDTO = modelMapper.map ( change, ChangeDTO.class );
        return changeDTO;
    }
    
    @Override
    public Change dtoToEntity ( ChangeDTO changeDTO ) throws ParseException {
        Change change = modelMapper.map ( changeDTO, Change.class );
        return change;
    }
    
}
