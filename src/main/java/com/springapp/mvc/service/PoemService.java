package com.springapp.mvc.service;

import com.springapp.mvc.domain.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/4/13
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class PoemService {



    public void initTheNewPoem(HttpServletRequest request){
        request.getSession().invalidate();
        request.getSession().setAttribute("poem", new Poem(new ArrayList()));
    }
    public void addSentencesToModel(ModelMap model,HttpServletRequest request){
        model.addAttribute("sentences", ((Poem)request.getSession().getAttribute("poem")).getSentences());
    }

    public void addSentenceToCurrentPoem(HttpServletRequest request,String sentence){
        Poem poem = (Poem)request.getSession().getAttribute("poem");
        poem.getSentences().add(request.getParameter(sentence));
        request.getSession().setAttribute("poem",poem);
    }

}
