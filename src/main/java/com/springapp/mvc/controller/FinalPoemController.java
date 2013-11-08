package com.springapp.mvc.controller;

import com.springapp.mvc.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/8/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class FinalPoemController {

    private final PoemService poemService;
    @Autowired
    public FinalPoemController(PoemService poemService) {
        this.poemService = poemService;
    }
    @RequestMapping(value = "/home/final", method = RequestMethod.GET)
    public String onPage(ModelMap model,HttpServletRequest request) {

        poemService.addSentencesToModel(model, request);
        return "final";
    }

    @RequestMapping(value = "/home/final", method = RequestMethod.POST)
    public String finalPage(HttpServletRequest request) {

        request.getSession().removeAttribute("poem");

        return "redirect:/";
    }
}
