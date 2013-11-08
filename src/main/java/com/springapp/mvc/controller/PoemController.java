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
//@Controller
//@RequestMapping("/")
public class PoemController {

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String firstOnPage() {
//
//        return "home";
//    }
//
//    @RequestMapping(value = "/home", method = RequestMethod.POST)
//    public String firstSentence(HttpServletRequest request)
//    {
//
//        initTheNewPoem(request);
//        addSentenceToCurrentPoem(request,"first");
//
//        return "redirect:/home/second";
//    }

//    @RequestMapping(value = "/home/second", method = RequestMethod.GET)
//    public String secondOnPage(ModelMap model,HttpServletRequest request) {
//
//        addSentencesToModel(model,request);
//        return "second";
//    }
//
//    @RequestMapping(value = "/home/second", method = RequestMethod.POST)
//    public String secondSentence(HttpServletRequest request) {
//
//        addSentenceToCurrentPoem(request, "second");
//
//        return "redirect:/home/third";
//    }
//    @RequestMapping(value = "/home/third", method = RequestMethod.GET)
//    public String thirdOnPage(ModelMap model,HttpServletRequest request) {
//
//        addSentencesToModel(model, request);
//        return "third";
//    }
//
//    @RequestMapping(value = "/home/third", method = RequestMethod.POST)
//    public String thirdSentence(HttpServletRequest request) {
//
//        addSentenceToCurrentPoem(request, "third");
//
//        return "redirect:/home/fourth";
//    }
//    @RequestMapping(value = "/home/fourth", method = RequestMethod.GET)
//    public String fourthOnPage(ModelMap model,HttpServletRequest request) {
//
//        addSentencesToModel(model, request);
//        return "fourth";
//    }
//    @RequestMapping(value = "/home/fourth", method = RequestMethod.POST)
//    public String fourthSentence(HttpServletRequest request) {
//
//        addSentenceToCurrentPoem(request,"fourth");
//
//        return "redirect:/home/final";
//    }
//    @RequestMapping(value = "/home/final", method = RequestMethod.GET)
//    public String finalOnPage(ModelMap model,HttpServletRequest request) {
//
//        addSentencesToModel(model, request);
//        return "final";
//    }
//
//    @RequestMapping(value = "/home/final", method = RequestMethod.POST)
//    public String finalPage(HttpServletRequest request) {
//
//        request.getSession().removeAttribute("poem");
//
//        return "redirect:/";
//    }
//    public void initTheNewPoem(HttpServletRequest request){
//        Poem poem = new Poem(new ArrayList());
//        request.getSession().invalidate();
//        request.getSession().setAttribute("poem",poem);
//    }
//    public void addSentencesToModel(ModelMap model,HttpServletRequest request){
//        Poem poem = (Poem)request.getSession().getAttribute("poem");
//        model.addAttribute("sentences", poem.getSentences());
//    }
//
//    public void addSentenceToCurrentPoem(HttpServletRequest request,String sentence){
//        Poem poem = (Poem)request.getSession().getAttribute("poem");
//        poem.getSentences().add(request.getParameter(sentence));
//        request.getSession().setAttribute("poem",poem);
//    }
}
