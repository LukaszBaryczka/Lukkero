package inzynierka.lukkero.model.context;

import inzynierka.lukkero.dto.CustomerDTO;
import inzynierka.lukkero.dto.ProjectDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukasz on 26.08.17.
 */
public class NewProjectContext implements Serializable {
    
    private static final long serialVersionUID = -8445943548965154778L;
    
    private ProjectDTO project;
    List<CustomerDTO> selectedUser = new ArrayList<> (  );
    
    public ProjectDTO getProject () {
        return project;
    }
    
    public void setProject ( ProjectDTO project ) {
        this.project = project;
    }
    
    public List< CustomerDTO > getSelectedUser () {
        return selectedUser;
    }
    
    public void setSelectedUser ( List< CustomerDTO > selectedUser ) {
        this.selectedUser = selectedUser;
    }
}
