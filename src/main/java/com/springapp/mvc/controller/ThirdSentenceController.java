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
public class ThirdSentenceController {

    private final PoemService poemService;
    @Autowired
    public ThirdSentenceController(PoemService poemService) {
        this.poemService = poemService;
    }

    @RequestMapping(value = "/home/third", method = RequestMethod.GET)
    public String onPage(ModelMap model,HttpServletRequest request) {

        poemService.addSentencesToModel(model, request);
        return "third";
    }

    @RequestMapping(value = "/home/third", method = RequestMethod.POST)
    public String addSentence(HttpServletRequest request) {

        poemService.addSentenceToCurrentPoem(request, "third");

        return "redirect:/home/fourth";
    }
}
