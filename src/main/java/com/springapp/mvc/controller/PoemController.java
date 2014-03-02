package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Poem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/4/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class PoemController {

    @RequestMapping(value = "/angular-index", method = RequestMethod.GET)
    public String angularApp() {

        return "angular-index";
    }

}
