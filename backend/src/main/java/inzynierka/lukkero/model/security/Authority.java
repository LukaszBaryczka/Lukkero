package inzynierka.lukkero.model.security;

import inzynierka.lukkero.model.Customer;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority {
    
    @Id
    @Column(name = "authority_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq")
    @SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", allocationSize = 1)
    private Long id;
    
    @Column(name = "name", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;
    
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<Customer> users;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public AuthorityName getName() {
        return name;
    }
    
    public void setName(AuthorityName name) {
        this.name = name;
    }
    
    public List<Customer> getUsers() {
        return users;
    }
    
    public void setUsers(List<Customer> users) {
        this.users = users;
    }
}
