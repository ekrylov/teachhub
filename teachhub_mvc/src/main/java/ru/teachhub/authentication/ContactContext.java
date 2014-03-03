package ru.teachhub.authentication;

import ru.teachhub.domain.Contact;

public interface ContactContext {
    
    Contact getContact();
    
    void setContact(Contact contact);

}
