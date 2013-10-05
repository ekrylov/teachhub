package ru.teachhub.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.teachhub.domain.Assignment;
import ru.teachhub.domain.Contact;
import ru.teachhub.domain.Unit;
import ru.teachhub.service.AssignmentService;
import ru.teachhub.service.ContactService;
import ru.teachhub.service.UnitService;

@RequestMapping( "/lesson" )
@Controller
public class LessonController
{

    private static final Logger logger = LoggerFactory.getLogger( LessonController.class );

    @Autowired
    private UnitService unitService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping( method = RequestMethod.GET )
    public String lessons( Model uiModel )
    {
        logger.info( "Listing lessons" );

        Contact contact = contactService.findById( 1L );
        Set<Unit> lessons = new HashSet<Unit>();
        Unit recommendedLesson = null;
        for ( Assignment assignment : contact.getAssignment() )
        {
            lessons.add( assignment.getUnitTask().getUnit() );
            if ( recommendedLesson == null )
            {
                recommendedLesson = assignment.getUnitTask().getUnit();
            }
        }

        uiModel.addAttribute( "lessons", lessons );
        uiModel.addAttribute( "recommendedLesson", recommendedLesson );

        logger.info( "No. of lessons: " + lessons.size() );

        return "lesson/student_lesson_list";
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public String showLessonDetails( @PathVariable( "id" )
    Long id, Model uiModel )
    {
        logger.info( "Lesson details" );

        Unit unit = unitService.findById( id );
        Contact contact = contactService.findById( 1L );

        List<Assignment> assignments = assignmentService.findByContactAndUnitTaskUnit( contact, unit );

        uiModel.addAttribute( "assignments", assignments );

        return "lesson/student_lesson_details";
    }
}
