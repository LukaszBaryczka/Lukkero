package inzynierka.lukkero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table ( name = "documentation" )
public class Documentation implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    @Column(name = "documentation_id")
    private BigInteger id;
    
    @Column(name = "doc")
    private String doc;
    
    public BigInteger getId () {
        return id;
    }
    
    public void setId ( BigInteger id ) {
        this.id = id;
    }
    
    public String getDoc () {
        return doc;
    }
    
    public void setDoc ( String doc ) {
        this.doc = doc;
    }
}