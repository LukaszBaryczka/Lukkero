package inzynierka.lukkero.dto;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDTO {
    
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat ( "yyyy-MM-dd HH:mm" );
    
    private String userId;
    
    private String name;
    
    private String surname;
    
    private String email;
    
    private String workTime;
    
    public String getUserId () {
        return userId;
    }
    
    public void setUserId ( String userId ) {
        this.userId = userId;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    
    public String getSurname () {
        return surname;
    }
    
    public void setSurname ( String surname ) {
        this.surname = surname;
    }
    
    public String getEmail () {
        return email;
    }
    
    public void setEmail ( String email ) {
        this.email = email;
    }
    
    public Date getWorkTime () throws ParseException {
        if ( ( this.workTime != null && this.workTime.isEmpty ( ) ) || this.workTime == null ) {
            return null;
        }
        return dateFormat.parse ( this.workTime );
    }
    
    public void setWorkTime ( Date date ) {
        if ( date != null ) {
            this.workTime = dateFormat.format ( date );
        } else {
            this.workTime = StringUtils.EMPTY;
        }
    }
}
