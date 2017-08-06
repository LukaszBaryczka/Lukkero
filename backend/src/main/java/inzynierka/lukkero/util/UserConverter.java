package inzynierka.lukkero.util;

import inzynierka.lukkero.dto.CustomerDTO;
import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.text.ParseException;

@Component
public class UserConverter implements IConverter<Customer, CustomerDTO> {
    
    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    UserService userService;
    
    public CustomerDTO entityToDto ( Customer customer ) {
        CustomerDTO customerDTO = modelMapper.map ( customer, CustomerDTO.class );
        customerDTO.setWorkTime ( customer.getWorkTime ( ) );
        return customerDTO;
    }
    
    public Customer dtoToEntity ( CustomerDTO customerDTO ) throws ParseException {
        Customer customer = modelMapper.map ( customerDTO, Customer.class );
        customer.setWorkTime ( customerDTO.getWorkTime ( ) );
        
        if ( customerDTO.getUserId ( ) != null ) {
            Customer oldCustomer = userService.findOne ( BigInteger.valueOf ( Long.valueOf ( customerDTO.getUserId ( ) ) ) );
            customer.setProjects ( oldCustomer.getProjects ( ) );
            customer.setTasks ( oldCustomer.getTasks ( ) );
        }
        return customer;
    }
}
