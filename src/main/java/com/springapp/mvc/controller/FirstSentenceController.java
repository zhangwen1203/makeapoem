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
    public String onPage(ModelMap model) {

        model.addAttribute("poem", new Poem());
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String addSentence(@Valid Poem poem, BindingResult result,HttpServletRequest request)
    {
        if (result.hasErrors()) {
            return "/home";
        }
        poemService.initTheNewPoem(request);
        poemService.addSentenceToCurrentPoem(request, poem.getNewSentence());

        return "redirect:/home/second";
    }

}
