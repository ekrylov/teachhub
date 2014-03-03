package ru.teachhub.authentication;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Role;

@Service("springSecurityUserContext")
public class SpringSecurityUserContext implements ContactContext {

    @Override
    public Contact getContact() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return null;
        }
        return (Contact) authentication.getPrincipal();
    }

    @Override
    public void setContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(contact, contact.getPassword(),
                        getGrantedAuthorities(contact.getRole()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Role role) {
        return AuthorityUtils.createAuthorityList(role.getTitle());
    }

}
