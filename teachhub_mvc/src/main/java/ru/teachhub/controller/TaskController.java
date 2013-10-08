package ru.teachhub.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.teachhub.domain.Assignment;
import ru.teachhub.service.AssignmentService;

@RequestMapping( "/task" )
@Controller
public class TaskController
{

    private static final String OPTIONS_SEPARATOR = ",";

    private static final Logger logger = LoggerFactory.getLogger( TaskController.class );

    @Autowired
    private AssignmentService assignmentService;

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public String showTask( @PathVariable( "id" )
    Long id, Model uiModel )
    {
        logger.info( "Task details" );

        fillModel( id, uiModel );

        return "task/student_task";
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.POST )
    public String submit( @PathVariable( "id" )
    Long id, Model uiModel, HttpServletRequest httpServletRequest )
    {
        logger.info( "Submit task" );

        String answer = httpServletRequest.getParameter( "option" );
        if ( !isValidAnswer( answer ) )
        {
            fillModel( id, uiModel );
            return "task/student_task";
        }

        return "lesson/student_lesson_details";
    }

    private boolean isValidAnswer( String answer )
    {
        return StringUtils.isNotBlank( answer );
    }

    private void fillModel( Long id, Model uiModel )
    {
        Assignment assignment = assignmentService.findById( id );
        List<String> answerOptions =
            new ArrayList<String>(
                                   Arrays.asList( assignment.getUnitTask().getTask().getTaskContent().getResponseOption().split( OPTIONS_SEPARATOR ) ) );

        uiModel.addAttribute( "unitTask", assignment.getUnitTask() );

        uiModel.addAttribute( "options", answerOptions );
    }
}
