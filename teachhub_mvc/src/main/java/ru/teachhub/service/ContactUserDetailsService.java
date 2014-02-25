package ru.teachhub.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Role;

@Service("customUserDetailsService")
@Repository
@Transactional
public class ContactUserDetailsService implements UserDetailsService {

    @Autowired
    private ContactService contactService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Contact contact = contactService.findByUserName(userName);

        if (contact == null) {
            throw new UsernameNotFoundException("Invalid username/password: '" + userName + "'");
        }

        return new User(contact.getUserName(), contact.getPassword(), getGrantedAuthorities(contact.getRole()));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Role role) {
        return AuthorityUtils.createAuthorityList(role.getTitle());
    }

}
