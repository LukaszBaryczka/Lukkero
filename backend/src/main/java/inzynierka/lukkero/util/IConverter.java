package inzynierka.lukkero.util;

import java.text.ParseException;

/**
 * Created by lukasz on 05.08.17.
 */
public interface IConverter <E, D> {
    D entityToDto ( E entityObject );
    E dtoToEntity ( D dtoObject ) throws ParseException;
}
