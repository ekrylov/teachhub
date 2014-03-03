package ru.teachhub.authentication;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Role;
import ru.teachhub.service.ContactService;

@Service("contactUserAuthenticationProvider")
public class ContactUserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ContactService contactService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        String userName = token.getName();

        Contact contact = userName == null ? null : contactService.findByUserName(userName);
        if (contact == null) {
            throw new UsernameNotFoundException("Invalid username/password");
        }

        String password = contact.getPassword();
        if (!password.equals(token.getCredentials())) {
            throw new BadCredentialsException("Invalid username/password");
        }

        return new UsernamePasswordAuthenticationToken(contact, password, getGrantedAuthorities(contact.getRole()));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Role role) {
        return AuthorityUtils.createAuthorityList(role.getTitle());
    }

}
