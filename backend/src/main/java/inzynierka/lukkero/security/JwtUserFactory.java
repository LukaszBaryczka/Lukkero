package inzynierka.lukkero.security;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.security.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    
    private JwtUserFactory() {
    }
    
    public static JwtUser create(Customer customer) {
        return new JwtUser(
                customer.getUserId().longValue (),
                customer.getUsername(),
                customer.getName (),
                customer.getSurname (),
                customer.getEmail(),
                customer.getPassword(),
                mapToGrantedAuthorities(customer.getAuthorities ()),
                customer.getEnabled(),
                customer.getLastPasswordResetDate()
        );
    }
    
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}