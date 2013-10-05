package ru.teachhub.service;

import java.util.List;

import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Role;

public interface ContactService
{

    List<Contact> findAll();

    List<Contact> findByFirstNameAndLastName( String firstName, String lastName );

    List<Contact> findByEmail( String email );

    List<Contact> findByRole( Role role );

    Contact findById( Long id );

    void save( Contact contact );

    void delete( Contact contact );

}
