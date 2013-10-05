package ru.teachhub.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Group;
import ru.teachhub.domain.Role;
import ru.teachhub.service.ContactService;

@RequestMapping( "/contacts" )
@Controller
public class ContactController
{

    private static final Logger logger = LoggerFactory.getLogger( ContactController.class );

    @Autowired
    MessageSource messageSource;

    @Autowired
    private ContactService contactService;

    @RequestMapping( method = RequestMethod.GET )
    public String list( Model uiModel )
    {
        logger.info( "Listing contacts" );

        List<Contact> contacts = getFakeContacts(); // contactService.findAll();
        uiModel.addAttribute( "contacts", contacts );

        logger.info( "No. of contacts: " + contacts.size() );

        return "contacts/list";
    }

    private List<Contact> getFakeContacts()
    {
        return Collections.singletonList( new Contact( "Eugene", "Krylov", "krylloff", "kryll@list.ru", new Role( 0L ),
                                                       new Group( "admin" ) ) );
    }
}
