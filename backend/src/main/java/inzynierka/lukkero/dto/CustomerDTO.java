package inzynierka.lukkero.dto;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerDTO {
    
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
    
    public String getWorkTime () {
        return workTime;
    }
    
    public void setWorkTime ( String workTime ) {
        this.workTime = workTime;
    }
}
