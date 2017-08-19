package inzynierka.lukkero.security;

import inzynierka.lukkero.dto.CustomerDTO;

import java.io.Serializable;

public class SignUpContext implements Serializable {
    
    private static final long serialVersionUID = -8445943548965154778L;
    
    private CustomerDTO userDto;
    private String username;
    private String password;
    
    public SignUpContext ( String username, String password ) {
        this.setUsername(username);
        this.setPassword ( password );
    }
    
    public SignUpContext () {
        super();
    }
    
    public String getUsername () {
        return username;
    }
    
    public void setUsername ( String username ) {
        this.username = username;
    }
    
    public String getPassword () {
        return password;
    }
    
    public void setPassword ( String password ) {
        this.password = password;
    }
    
    public CustomerDTO getUserDto () {
        return userDto;
    }
    
    public void setUserDto ( CustomerDTO userDto ) {
        this.userDto = userDto;
    }
}
