package ru.teachhub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Role;

public interface ContactRepository
    extends CrudRepository<Contact, Long>
{

    List<Contact> findByFirstNameAndLastName( String firstName, String lastName );

    List<Contact> findByEmail( String email );

    List<Contact> findByRole( Role role );

}
