package com.springapp.mvc.controller;

import com.springapp.mvc.domain.Poem;
import com.springapp.mvc.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/8/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class SecondSentenceController {

    private final PoemService poemService;

    @Autowired
    public SecondSentenceController(PoemService poemService) {
        this.poemService = poemService;
    }

    @RequestMapping(value = "/home/second", method = RequestMethod.GET)
    public String onPage(ModelMap model,HttpServletRequest request) {

        poemService.addSentencesToModel(model,request);
        return "second";
    }

    @RequestMapping(value = "/home/second", method = RequestMethod.POST)
    public String addSentence(@Valid Poem poem, BindingResult result,HttpServletRequest request) {

        if (result.hasErrors()) {
            return "second";
        }
        poemService.addSentenceToCurrentPoem(request, poem.getNewSentence());

        return "redirect:/home/third";
    }
}
