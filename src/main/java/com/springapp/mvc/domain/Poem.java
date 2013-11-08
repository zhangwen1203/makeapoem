package com.springapp.mvc.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/4/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Poem implements Serializable{

    private String title;
    private List<String> sentences;

    public Poem() {
    }

    public Poem(String title) {
        this.title = title;
    }

    public Poem(List sentences) {
        this.sentences = sentences;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

}
