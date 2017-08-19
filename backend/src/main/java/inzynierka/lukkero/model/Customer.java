package inzynierka.lukkero.model;

import inzynierka.lukkero.model.security.Authority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table ( name = "customer" )
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column ( name = "customer_id" )
    private BigInteger userId;
    
    @Column(name = "username", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;
    
    @Column(name = "password", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;
    
    @Column(name = "enabled")
    @NotNull
    private Boolean enabled;
    
    @Column(name = "last_password_reset_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date lastPasswordResetDate;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "authority_id")})
    private List<Authority> authorities;
    
    @Column ( name = "first_name" )
    private String name;
    @Column ( name = "last_name" )
    private String surname;
    @Column ( name = "email" )
    private String email;
    @Column ( name = "work_time" )
    private Date workTime;
    
    @ManyToMany ( fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    @JoinTable ( name = "user_project", joinColumns = {
            @JoinColumn ( name = "customer_id", nullable = false, updatable = false ) },
            inverseJoinColumns = { @JoinColumn ( name = "project_id" ) } )
    private List< Project > projects;
    
    @OneToMany ( mappedBy = "customer", cascade = CascadeType.ALL )
    private List< Task > tasks;
    
    public Customer () {
    }
    
    public Customer ( String name, String surname, String email, Date workTime ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.workTime = workTime;
    }
    
    public BigInteger getUserId () {
        return userId;
    }
    
    public void setUserId ( BigInteger userId ) {
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
    
    public Date getWorkTime () {
        return workTime;
    }
    
    public void setWorkTime ( Date workTime ) {
        this.workTime = workTime;
    }
    
    public List< Project > getProjects () {
        return projects;
    }
    
    public void setProjects ( List< Project > projects ) {
        this.projects = projects;
    }
    
    public List< Task > getTasks () {
        return tasks;
    }
    
    public void setTasks ( List< Task > tasks ) {
        this.tasks = tasks;
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
    
    public Boolean getEnabled () {
        return enabled;
    }
    
    public void setEnabled ( Boolean enabled ) {
        this.enabled = enabled;
    }
    
    public Date getLastPasswordResetDate () {
        return lastPasswordResetDate;
    }
    
    public void setLastPasswordResetDate ( Date lastPasswordResetDate ) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
    
    public List< Authority > getAuthorities () {
        return authorities;
    }
    
    public void setAuthorities ( List< Authority > authorities ) {
        this.authorities = authorities;
    }
    
    @Override
    public String toString () {
        return "Customer{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", workTime=" + workTime +
                '}';
    }
}