package ru.teachhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/login")
@Controller
public class AccessController {

    private static final Logger LOG = LoggerFactory.getLogger(AccessController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model uiModel) {
        LOG.info("Login");

        return "access/login";
    }

}
