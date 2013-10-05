package ru.teachhub.service.jpa;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.github.springtestdbunit.annotation.DatabaseSetup;

import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Group;
import ru.teachhub.domain.Role;
import ru.teachhub.service.ContactService;
import ru.teachhub.service.GroupService;
import ru.teachhub.service.RoleService;

public class ContactServiceImplTest
    extends AbstractServiceImplTest
{

    @Autowired
    private ContactService contactService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private GroupService groupService;

    private Contact expectedAdminContact = new Contact( "Eugene", "Krylov", "pass1", "ekrylov@teachhub.ru",
                                                        new Role( "admin", "11111111" ), new Group( "admins" ) );

    private Contact expectedTeacherContact = new Contact( "Elena", "Krylova", "pass2", "ekrylova@teachhub.ru",
                                                          new Role( "teacher", "11110000" ), new Group( "teachers" ) );

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void findAll()
        throws Exception
    {
        List<Contact> contacts = contactService.findAll();

        Assert.assertNotNull( contacts );
        Assert.assertEquals( 2, contacts.size() );

        Contact adminContact = contacts.get( 0 );
        Contact teacherContact = contacts.get( 1 );

        Assert.assertEquals( expectedAdminContact, adminContact );
        Assert.assertEquals( expectedTeacherContact, teacherContact );
    }

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void findByFirstNameAndLastName()
        throws Exception
    {
        List<Contact> contacts = contactService.findByFirstNameAndLastName( "Eugene", "Krylov" );

        Assert.assertNotNull( contacts );
        Assert.assertEquals( 1, contacts.size() );

        Contact adminContact = contacts.get( 0 );

        Assert.assertEquals( expectedAdminContact, adminContact );
    }

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void findByEmail()
    {
        List<Contact> contacts = contactService.findByEmail( "ekrylova@teachhub.ru" );

        Assert.assertNotNull( contacts );
        Assert.assertEquals( 1, contacts.size() );

        Contact teacherContact = contacts.get( 0 );

        Assert.assertEquals( expectedTeacherContact, teacherContact );
    }

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void findByRole()
    {
        List<Contact> contacts = contactService.findByRole( new Role( 1l ) );

        Assert.assertNotNull( contacts );
        Assert.assertEquals( 1, contacts.size() );

        Contact adminContact = contacts.get( 0 );

        Assert.assertEquals( expectedAdminContact, adminContact );
    }

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void errorFindByFirstName()
    {
        List<Contact> contacts = contactService.findByFirstNameAndLastName( "Eugene", null );

        Assert.assertNotNull( contacts );
        Assert.assertTrue( "Result set should not contain any contact because of 'null' in search query",
                           contacts.isEmpty() );
    }

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void errorFindByLastName()
    {
        List<Contact> contacts = contactService.findByFirstNameAndLastName( null, "Krylov" );

        Assert.assertNotNull( contacts );
        Assert.assertTrue( "Result set should not contain any contact because of 'null' in search query",
                           contacts.isEmpty() );
    }

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void addContact()
    {
        Role adminRole = roleService.findByTitle( "admin" ).get( 0 );
        Group adminGroup = groupService.findByTitle( "admins" ).get( 0 );
        Contact newContact = new Contact( "Ivan", "Ivanov", "pass", "iivanov@teachhub.ru", adminRole, adminGroup );

        contactService.save( newContact );
        List<Contact> contacts = contactService.findAll();

        Assert.assertEquals( 3, contacts.size() );
        Assert.assertEquals( expectedAdminContact, contacts.get( 0 ) );
        Assert.assertEquals( expectedTeacherContact, contacts.get( 1 ) );
        Assert.assertEquals( newContact, contacts.get( 2 ) );
    }

    @Test( expected = DataIntegrityViolationException.class )
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void error_addContactWithExistingEmail()
    {
        Role adminRole = roleService.findByTitle( "admin" ).get( 0 );
        Group adminGroup = groupService.findByTitle( "admins" ).get( 0 );
        Contact newContact = new Contact( "Ivan", "Ivanov", "pass", "ekrylov@teachhub.ru", adminRole, adminGroup );

        contactService.save( newContact );
    }

    @Test
    @DatabaseSetup( "ContactServiceImplTest.xml" )
    public void deleteContact()
    {
        Contact deleteContact = contactService.findByFirstNameAndLastName( "Eugene", "Krylov" ).get( 0 );

        contactService.delete( deleteContact );
        List<Contact> contacts = contactService.findAll();

        Assert.assertEquals( 1, contacts.size() );
        Assert.assertEquals( expectedTeacherContact, contacts.get( 0 ) );
    }
}
