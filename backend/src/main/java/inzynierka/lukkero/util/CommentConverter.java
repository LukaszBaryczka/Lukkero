package inzynierka.lukkero.util;

import inzynierka.lukkero.dto.CommentDTO;
import inzynierka.lukkero.model.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class CommentConverter implements IConverter<Comment, CommentDTO> {
    
    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public CommentDTO entityToDto ( Comment comment ) {
        CommentDTO commentDTO = modelMapper.map ( comment, CommentDTO.class );
        return commentDTO;
    }
    
    @Override
    public Comment dtoToEntity ( CommentDTO commentDTO ) throws ParseException {
        Comment comment = modelMapper.map ( commentDTO, Comment.class );
        return comment;
    }
    
}
