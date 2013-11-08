package com.springapp.mvc.controller;

import com.springapp.mvc.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/8/13
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class FirstSentenceController {

    private final PoemService poemService;
    @Autowired
    public FirstSentenceController(PoemService poemService) {
        this.poemService = poemService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String onPage() {

        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String addSentence(HttpServletRequest request)
    {
        poemService.initTheNewPoem(request);
        poemService.addSentenceToCurrentPoem(request,"first");

        return "redirect:/home/second";
    }
}
