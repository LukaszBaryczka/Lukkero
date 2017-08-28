package inzynierka.lukkero.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Table ( name = "comment" )
public class Comment implements Serializable {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO )
    @Column(name = "comment_id")
    private BigInteger id;
    
    @Column(name = "content")
    private String content;
    
    @ManyToOne
    @JoinColumn ( name = "project" )
    private Project project;
    
    @ManyToOne
    @JoinColumn ( name = "task" )
    private Task task;
    
    public BigInteger getId () {
        return id;
    }
    
    public void setId ( BigInteger id ) {
        this.id = id;
    }
    
    public String getContent () {
        return content;
    }
    
    public void setContent ( String content ) {
        this.content = content;
    }
    
    public Project getProject () {
        return project;
    }
    
    public void setProject ( Project project ) {
        this.project = project;
    }
    
    public Task getTask () {
        return task;
    }
    
    public void setTask ( Task task ) {
        this.task = task;
    }
}