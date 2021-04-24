package fit.imc.infra.security.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fit.imc.models.mongo.User;
import fit.imc.services.abstracts.UserServiceTemplate;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceTemplate usersSvc;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersSvc.getAll()
            .stream()
            .filter(x -> x.getUsername().equalsIgnoreCase(username))
            .findFirst();

        if (user.isEmpty()) return null;

        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
    }
    
}
